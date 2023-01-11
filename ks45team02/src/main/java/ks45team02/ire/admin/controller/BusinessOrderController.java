package ks45team02.ire.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.service.BusinessOrderService;

@Controller
@RequestMapping("/admin")
public class BusinessOrderController {
	
	private static final Logger log = LoggerFactory.getLogger(DonationController.class);
	
	private BusinessOrderService businessOrderService;

	public BusinessOrderController(BusinessOrderService businessOrderService) {
		
		this.businessOrderService = businessOrderService;

	}
	
	/**
	 * 발주 목록 전체 조회
	 * @param model
	 * @return businessOrderList
	 */
	@GetMapping("/listBusinessOrder")
	public String listBusinessOrder(Model model
									,@RequestParam(value="msg", required = false) String msg) {
		
		List<BusinessOrder> businessOrderList = businessOrderService.getListBusinessOrder();
		model.addAttribute("title", "발주 목록");
		model.addAttribute("pageTitle", "발주 목록");
		model.addAttribute("businessOrderList", businessOrderList);
		
		log.info("businessOrderList:{}", businessOrderList);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/businessorder/businessOrderList";
	}
	
	/**
	 * 상품 판매단가 검색
	 * @param searchKey, searchValue, model
	 * @return goodsList
	 */
	@GetMapping("/goodsSearchForBusinessOrderadd")
	public String goodsSearchForBusinessOrderadd(@RequestParam(value="searchKey", required = false) String searchKey
										 		,@RequestParam(value="searchValue", required = false) String searchValue
										 		,Model model) {
		
		List<Goods> goodsList = businessOrderService.searchGoods(searchKey, searchValue);
		model.addAttribute("title", "상품 검색");
		model.addAttribute("goodsList", goodsList);
		log.info("goodsList :{}", goodsList);
		
		return "admin/businessorder/goodsSearchForBusinessOrderadd";
	}
	
	/**
	 * 거래처 검색
	 * @param searchKey, searchValue, model
	 * @return goodsList
	 */
	@GetMapping("/businessSearchForBusinessOrderadd")
	public String businessSearchForBusinessOrderadd(@RequestParam(value="searchKey", required = false) String searchKey
												   ,@RequestParam(value="searchValue", required = false) String searchValue
												   ,Model model) {
		
		List<Business> businessList = businessOrderService.searchBusiness(searchKey, searchValue);
		model.addAttribute("title", "거래처 검색");
		model.addAttribute("businessList", businessList);
		log.info("businessList :{}", businessList);
		
		return "admin/businessorder/businessSearchForBusinessOrderadd";
	}
	
	/**
	 * 발주 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addBusinessOrder")
	public String addBusinessOrder(Model model
								   ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "발주 등록");
		model.addAttribute("pageTitle", "발주 등록");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/businessorder/businessOrderAdd";
	}
	
	/**
	 * 발주 등록 처리
	 * @param businessOrder
	 */
	@PostMapping("/addBusinessOrder")
	public String addBusinessOrder(BusinessOrder businessOrder
								   ,RedirectAttributes reAttr) {
		
		log.info("businessOrder :{}", businessOrder);
		int result = businessOrderService.addBusinessOrder(businessOrder);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "발주 등록에 실패하였습니다.");
			return "redirect:/admin/addBusinessOrder";
		}else {
			reAttr.addAttribute("msg", "발주 등록에 성공하였습니다.");
		}
		
		
		return "redirect:/admin/listBusinessOrder";
	}
	
	/**
	 * 발주 삭제 처리
	 * @param param, reAttr
	 * @return reResult
	 */
	@ResponseBody
	@RequestMapping(value="deleteBusinessOrder", method = {RequestMethod.POST})
	public HashMap<String, String> deleteBusinessOrder(@RequestParam Map<String, Object> param
			 						  ,RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		String businessOrderCode = (String) param.get("businessOrderCode");
		int result = businessOrderService.deleteBusinessOrder(businessOrderCode);
		
		if(result == 0) {
			reResult.put("result", "실패");			
		}else {
			reResult.put("result", "성공");					
		}
			reResult.put("businessOrderCode", businessOrderCode);	
			reResult.put("redirect", "/admin/listBusinessOrder");				
		
		return reResult;
	}
	
	/**
	 * 발주 수정 화면
	 * @param businessOrderCode, msg, model
	 * @return businessorderinfo
	 */
	@GetMapping("/modifyBusinessOrder")
	public String modifyBusinessOrder(@RequestParam(value = "businessOrderCode")String businessOrderCode
									  ,@RequestParam(value="msg", required = false) String msg, Model model) {
		log.info("businessOrderCode :{}", businessOrderCode);
		List<BusinessOrder> businessorderinfo = businessOrderService.getListBusinessOrderByCode(businessOrderCode);

		model.addAttribute("title", "발주 수정");
		model.addAttribute("pageTitle", "발주 수정");
		model.addAttribute("businessorderinfo", businessorderinfo);
		
		log.info("businessorderinfo :{}", businessorderinfo);
		
		return "admin/businessorder/businessOrderModify";
	}
	
	/**
	 * 발주 수정 처리
	 * @param businessOrder, reAttr
	 */
	@PostMapping("/modifyBusinessOrder")
	public String modifyBusinessOrder(BusinessOrder businessOrder
									 ,RedirectAttributes reAttr) {
		
			log.info("businessOrder :{}", businessOrder);
			int result = businessOrderService.modifyBusinessOrder(businessOrder);
			
			if(result == 0) {
				reAttr.addAttribute("msg", "발주 수정에 실패하였습니다.");
				return "redirect:/admin/modifyBusinessOrder";
			}else {
				reAttr.addAttribute("msg", "발주 수정에 성공하였습니다.");
			}
			
			
			return "redirect:/admin/listBusinessOrder";
	   }
	
	/**
	 * 발주 업데이트 화면
	 * @param businessOrderCode, model
	 * @return businessOrderList
	 */
	@GetMapping("/businessOrderUpdate")
	public String businessOrderUpdate(@RequestParam(value="businessOrderCode")String businessOrderCode,Model model) {
		
		log.info("businessOrderCode :{}", businessOrderCode);
		List<BusinessOrder> businessOrderList =  businessOrderService.getListBusinessOrderByCode(businessOrderCode);
		model.addAttribute("title", "거래처 수신");
		model.addAttribute("businessOrderList", businessOrderList);
		log.info("businessOrderList :{}", businessOrderList);
		
		return "admin/businessorder/businessOrderUpdate";
	}
	
	@PostMapping("/updateBusinessOrder")
	public String businessOrderUpdate(BusinessOrder businessOrder
									  ,RedirectAttributes reAttr) {
		
		log.info("businessOrderCode :{}", businessOrder);
		int result = businessOrderService.modifyBusinessOrder(businessOrder);
	
		
		return "redirect:/admin/listBusinessOrder";
	}
}

