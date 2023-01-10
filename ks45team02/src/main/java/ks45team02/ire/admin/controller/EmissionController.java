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

import ks45team02.ire.admin.dto.GoodsEmission;
import ks45team02.ire.admin.dto.RawMaterialsEmission;
import ks45team02.ire.admin.mapper.EmissionMapper;
import ks45team02.ire.admin.service.EmissionService;


@Controller
@RequestMapping("/admin")
public class EmissionController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmissionController.class);

	
	private final EmissionService emissionService;
	
	public EmissionController (EmissionService emissionService) {
		this.emissionService = emissionService;
		
	}
	
	/**
	 * 기부받은 의류 CO2 등록 화면
	 * @param model
	 * @return admin/emission/AddRawMaterialsEmission
	 */
	@GetMapping("/addRawMaterialsEmission")
	public String addRawMaterialsEmission(Model model) {
		
		List<RawMaterialsEmission> listRawMaterialsEmission = emissionService.getRawMaterialsEmissionList();
		log.info("기부받은 의류 CO2 기준 : {}" , listRawMaterialsEmission);
		model.addAttribute("title", "기부받은 의류 CO2 기준 등록");
		model.addAttribute("listRawMaterialsEmission" ,listRawMaterialsEmission);
		
		return "admin/emission/emissionAddRawMaterials";
	}
	
	
	/**
	 * 기부받은 의류 CO2 기준 등록 처리
	 * @param RawMaterialsEmission
	 * @return redirect:/admin/listRawMaterialsEmission
	 */
	@PostMapping("/addRawMaterialsEmission")
	public String addRawMaterialsEmission(RawMaterialsEmission rawMaterialsEmission) {
		
		log.info("기부받은 의류 CO2 기준 입력 정보: {]" , rawMaterialsEmission);
		emissionService.addRawMaterialsEmission(rawMaterialsEmission);
		
		return "redirect:/admin/listRawMaterialsEmission";
	}
	
	/**
	 * 기부받은 의류 CO2 기준 수정화면
	 * @param rawMaterialsEmission model
	 * @return admin/rawMaterialsModify
	 */
	@GetMapping("/modifyRawMaterialsEmission")
	public String modifyRawMaterialsEmission(@RequestParam(value= "raw_materials_co2_code") String raw_materials_co2_code, Model model) {
		
		
		List<RawMaterialsEmission> modifyRawMaterialsEmission = emissionService.getRawMaterialsCO2Code(raw_materials_co2_code);
		model.addAttribute("title", "기부받은 의류 CO2 기준 수정");
		model.addAttribute("modifyRawMaterialsEmission", modifyRawMaterialsEmission);

		log.info("modifyRawMaterialsEmission: {}" ,modifyRawMaterialsEmission);
		return "admin/emission/emissionModifyRawMaterials";
	}
	
	/**
	 * 기부받은 의류 CO2 기준 수정 처리
	 * @param rawMaterialsEmission
	 * @return redirect:/admin/listRawMaterialsEmission
	 */
	@PostMapping("/modifyRawMaterialsEmission")
	public String modifyRawMaterialsEmission(RawMaterialsEmission rawMaterialsEmission) {
		
		emissionService.modifyRawMaterialsEmission(rawMaterialsEmission);
		
		return "redirect:/admin/listRawMaterialsEmission";
	}

	
	/**
	 * 기부받은 의류 CO2 기준 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/listRawMaterialsEmission")
	public String listRawMaterialsEmission(Model model) {
		
		List<RawMaterialsEmission> rawMaterialsEmissionList = emissionService.getRawMaterialsEmissionList();

		model.addAttribute("rawMaterialsEmissionList", rawMaterialsEmissionList);
		model.addAttribute("title", "기부받은 의류 CO2 기준 리스트");
		return "admin/emission/emissionListRawMaterials";
	}
	
	
	/**
	 * 기부받은 의류 CO2 기준 삭제
	 * @param param
	 * @return redirect:/admin/listRawMaterialsEmission
	 */
	@ResponseBody
	@RequestMapping(value = "deleteRawMaterialsEmission", method = {RequestMethod.POST})
	public HashMap<String, String> deleteRawMaterialsEmission(@RequestParam Map<String, Object> param, RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		
		String raw_materials_co2_code = (String) param.get("raw_materials_co2_code");
		
		int result = emissionService.deleteRawMaterialsEmission(raw_materials_co2_code);
		if(result == 0) {
			reResult.put("result", "실패");
		}else {
			reResult.put("result", "성공");
		}
			reResult.put("raw_materials_co2_code", raw_materials_co2_code);
			reResult.put("redirect", "/admin/listRawMaterialsEmission");
			
		return reResult;
	}
	
	
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "admin/emission/emissionListRawMaterialsGroupStatistics";
	}
	
/**
 * 	
 * ************************* 여기서부터 원단별 CO2 ***********************************************************
 *
 */
	
	/**
	 * 원단별 탄소 배출량 기준 등록 화면
	 * @param model
	 * @return admin/emission/AddGoodsEmission
	 */
	@GetMapping("/addGoodsEmission")
	public String addGoodsEmission(Model model) {
		
		List<GoodsEmission> listGoodsEmission = emissionService.getGoodsEmissionList();
		log.info("원단별 탄소 배출량 기준 : {}", listGoodsEmission);
		model.addAttribute("title", "원단별 탄소 배출량 기준 등록");
		model.addAttribute("listGoodsEmission" , listGoodsEmission);
		
		return "admin/emission/emissionGoodsAdd";
	}
	
	
	/**
	 * 원단별 탄소배출량 기준 등록 처리
	 * @param GoodsEmission
	 * @return redirect:/admin/listGoodsEmission
	 */
	@PostMapping("/addGoodsEmission")
	public String addGoodsEmission(GoodsEmission goodsEmission) {
		
		log.info("원단별 탄소배출량 기준 입력 정보 : {}", goodsEmission);
		emissionService.addGoodsEmission(goodsEmission);
		
		return "redirect:/admin/listGoodsEmission";
	}
	
	
	/**
	 * 원단별 탄소배출량 기준 수정 화면
	 * @param goodsEmission model
	 * @return admin/goodsEmissionModify
	 */
	@GetMapping("/modifyGoodsEmission")
	public String modifyGoodsEmission(@RequestParam(value="fabric") String fabric, Model model) {
		
		List<GoodsEmission> modifyGoodsEmission = emissionService.getGoodsEmissionFabric(fabric);
		model.addAttribute("title", "원단별 탄소배출량 기준 수정");
		model.addAttribute("modifyGoodsEmission", modifyGoodsEmission);
		
		log.info("modifyGoodsEmission: {}", modifyGoodsEmission);
		return "admin/emission/emissionGoodsModify";
	}
	
	/**
	 * 원단별 탄소배출량 기준 수정 처리
	 * @param goodsEmission
	 * @return redirect:/admin/listGoodsEmission
	 */
	@PostMapping("/modifyGoodsEmisison")
	public String modifyGoodsEmission(GoodsEmission goodsEmission) {
		
		emissionService.modifyGoodsEmission(goodsEmission);
		
		return "redirect:/admin/listGoodsEmission";
	}
	
	/**
	 * 원단별 탄소 배출량 기준 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/listGoodsEmission")
	public String listGoodsEmission(Model model) {
		
		List<GoodsEmission> goodsEmissionList = emissionService.getGoodsEmissionList();
		log.info("goodsEmissionList: {}", goodsEmissionList);
		model.addAttribute("goodsEmissionList", goodsEmissionList);
		model.addAttribute("title", "원단별 탄소 배출량 기준 리스트");
		return "admin/emission/emissionGoodsList";
	}
	
	
	/**
	 * 원단별 탄소 배출량 기준 삭제
	 * @param param
	 * @return redirect:/admin/listGoodsEmission
	 */
	@ResponseBody
	@RequestMapping(value="deleteGoodsEmission", method= {RequestMethod.POST})
	public HashMap<String, String> deleteGoodsEmission(@RequestParam Map<String, Object> param, RedirectAttributes reAttr){
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		
		String fabric = (String) param.get("fabric");
		
		int result = emissionService.deleteGoodsEmission(fabric);
		if(result == 0) {
			reResult.put("result", "실패");
		}else {
			reResult.put("result", "성공");
		}
			reResult.put("fabric", fabric);
			reResult.put("redirect", "/admin/listGoodsEmission");
			
		return reResult;
	}
	
	
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "admin/emission/emissionListCO2Total";
	}
	

}

