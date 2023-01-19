package ks45team02.ire.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.CategoryMedium;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.service.CategoryService;
import ks45team02.ire.admin.service.FileService;
import ks45team02.ire.admin.service.GoodsService;

@Controller
@RequestMapping("/admin")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private final GoodsService goodsService;
	private final CategoryService categoryService;
	private FileService fileService;
	
	public GoodsController(GoodsService goodsService, 
						   CategoryService categoryService,
						   FileService fileService) {
		this.categoryService = categoryService;
		this.goodsService = goodsService;
		this.fileService = fileService;
		
		
	}
	
	//상품 검색
	@GetMapping("/goodsSearch")
	public String goodsSearchForBasketadd(@RequestParam(value="searchKey", required = false) String searchKey
										 ,@RequestParam(value="searchValue", required = false) String searchValue
										 ,Model model) {
			
		List<Goods> goodsList = goodsService.searchGoods(searchKey, searchValue);
		model.addAttribute("title", "상품 검색");
		model.addAttribute("goodsList", goodsList);
			
		return "admin/search/goodsSearch";
	}
	
	/**
	 * 상품등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		List<CategoryMedium> listAllCategory = categoryService.getMediumCategory();
		model.addAttribute("title", "상품등록");
		model.addAttribute("pageTitle", "상품등록");
		model.addAttribute("listAllCategory", listAllCategory);
		return "admin/goods/goodsAdd";
	}
	
	/**
	 * 상품 등록 처리
	 * @param goods
	 * @return
	 */
	@PostMapping("/addGoods")
	public String addGoods(Goods goods,@RequestParam MultipartFile[] uploadfile
						  ,Model model, HttpServletRequest request) {

		log.info("goods : {}", goods);
		log.info("uploadfile : {}", uploadfile);
		
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		int addfile = fileService.fileUpload(uploadfile, fileRealPath);
		log.info("addfile : {}", addfile);
		if(addfile != 0)goodsService.addGoods(goods);
	
		return "redirect:/admin/listGoods";
	}
	
	/**
	 * 상품 삭제 처리
	 * @param param, reAttr
	 * @return reResult
	 */
	@ResponseBody
	@RequestMapping(value="deleteGoods", method = {RequestMethod.POST})
	public HashMap<String, String> deleteGoods(@RequestParam Map<String, Object> param
							  ,RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		String goodsCode = (String) param.get("goodsCode");
		
		int result = goodsService.deletegoods(goodsCode);

		if(result == 0) {
			reResult.put("result", "실패");			
		}else {
			reResult.put("result", "성공");			
		}
			reResult.put("goodsCode", goodsCode);	
			reResult.put("redirect", "/admin/listGoods");			
			
		return reResult;
	}
	
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return listGoods
	 */
	@GetMapping("/listGoods")
	public String listGoods(Model model
						   ,@RequestParam(value="msg", required=false) String msg) {
		
		List<Goods> listGoods = goodsService.getListGoods();
		log.info("상품리스트 : {}", listGoods);
		model.addAttribute("title", "상품목록");
		model.addAttribute("pageTitle", "상품목록");
		model.addAttribute("listGoods", listGoods);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/goods/goodsList";
	}
	
	/**
	 * 상품 수정 화면
	 * @param goodsCode, model
	 */
	@GetMapping("/modifyGoods")
	public String modifyGoods(@RequestParam(value = "goodsCode")String goodsCode, Model model) {
		log.info("goodsCode : {}", goodsCode);
		List<Goods> GodosUnitPriceInfo = goodsService.getListGoodsAndUnitPrice(goodsCode);
		List<CategoryMedium> listAllCategory = categoryService.getMediumCategory();
		log.info("GodosUnitPriceInfo : {}", GodosUnitPriceInfo);
		model.addAttribute("title", "상품수정");
		model.addAttribute("pageTitle", "상품수정");
		model.addAttribute("GodosUnitPriceInfo", GodosUnitPriceInfo);
		model.addAttribute("listAllCategory", listAllCategory);
		
		return "admin/goods/goodsModify";
	}
	
	/**
	 * 상품 수정처리
	 * @param goods, reAttr
	 */
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods
							 ,RedirectAttributes reAttr) {
		
		int result = goodsService.modifyGoods(goods);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "상품 수정에 실패하였습니다.");
			return "redirect:/admin/modifyBigCategory";
		}else if(result == 10){                                                                                                                                                                                                                                                                                                                                                             
			reAttr.addAttribute("msg", "상품코드가 존재하지 않습니다.");
			return "redirect:/admin/modifyBigCategory";
		}else {
			reAttr.addAttribute("msg", "상품 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listGoods";
	}
}

