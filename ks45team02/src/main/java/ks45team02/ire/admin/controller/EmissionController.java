package ks45team02.ire.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.GoodsEmission;
import ks45team02.ire.admin.dto.RawMaterialsEmission;
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
	@PostMapping("addRawMaterialsEmission")
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
	

	@GetMapping("/deleteRawMaterialsEmission")
	public String deleteRawMaterialsEmission() {
		
		return "admin/emission/emissionDeleteRawMaterials";
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
	 * @return
	 */
	@GetMapping("/addGoodsEmission")
	public String addGoodsEmission(Model model) {
		
		return "admin/emission/emissionGoodsAdd";
	}
	
	/**
	 * 원단별 탄소배출량 기준 등록 처리
	 * @return
	 */
//	@PostMapping("")
	
	
	/**
	 * 원단별 탄소배출량 기준 수정 
	 * @return
	 */
	@GetMapping("/modifyGoodsEmission")
	public String modifyGoodsEmission() {
		
		return "admin/emission/emissionGoodsModify";
	}
	
	
	/**
	 * 원단별 탄소 배출량 기준 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/listGoodsEmission")
	public String listGoodsEmission(Model model) {
		
		List<GoodsEmission> goodsEmissionList = emissionService.getGoodsEmissionList();
		log.info("goodsEmissionList1111111111: {}", goodsEmissionList);
		model.addAttribute("goodsEmissionList", goodsEmissionList);
		model.addAttribute("title", "원단별 탄소 배출량 기준 리스트");
		
		return "admin/emission/emissionGoodsList";
	}
		
	
	@GetMapping("/deleteGoodsEmission")
	public String deleteGoodsEmission() {
		
		return "admin/emission/emissionGoodsDelete";
	}
	
	
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "admin/emission/emissionListCO2Total";
	}
	

}

