package ks45team02.ire.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveAndMinus;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.service.PointService;

@Controller
@RequestMapping("/admin")
public class PointController {
	
	private final PointService pointService;
	private final PointMapper pointMapper;
	
	public PointController(PointService pointService, PointMapper pointMapper) {
		this.pointService = pointService;
		this.pointMapper = pointMapper;
	}
	
	//포인트 적립 기준 등록 처리
	@PostMapping("/addStandardPoint")
	public String addStandardPoint(PointSaveStandard pointSaveStandard, RedirectAttributes reAttr) {
		
		int result = pointService.addPointSaveStandard(pointSaveStandard);
		if(result == 0) {
			reAttr.addAttribute("msg", "포인트 적립 기준 등록에 실패하였습니다.");
			return "redirect:/admin/addStandardPoint";
		}
		reAttr.addAttribute("msg", "포인트 적립 기준 등록에 성공하였습니다.");
		return "redirect:/admin/listStandardPoint";
	}
	
	//포인트 지급 기준 등록 페이지
	@GetMapping("/addStandardPoint")
	public String addStandardPoint(Model model,
								  @RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "포인트 지급 기준 등록");
		model.addAttribute("pageTitle", "포인트 지급 기준 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/point/pointAddStandard";
	}
	
	//포인트 지급 기준 조회 페이지
	@GetMapping("/listStandardPoint")
	public String listStandardPoint(Model model
								  ,@RequestParam(value="msg", required = false) String msg) {
		
		List<PointSaveStandard> pointSaveStandardList = pointService.getPointSaveStandardList();
		
		model.addAttribute("title", "포인트 지급 기준 조회");
		model.addAttribute("pageTitle", "포인트 지급 기준 조회");
		model.addAttribute("pointSaveStandardList", pointSaveStandardList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/point/pointListStandard";
	}
	
	//포인트 지급 기준 수정 처리
	@PostMapping("/modifyStandardPoint")
	public String modifyStandardPoint(PointSaveStandard pointSaveStandard, RedirectAttributes reAttr) {
		
		int result = pointService.modifyPointSaveStandard(pointSaveStandard);
		if(result == 0) {
			reAttr.addAttribute("msg", "포인트 적립 기준 수정에 실패하였습니다.");
			return "redirect:/admin/modifyStandardPoint";
		}
		reAttr.addAttribute("msg", "포인트 적립 기준 수정에 성공하였습니다.");
		
		return "redirect:/admin/listStandardPoint";
	}
	
	//포인트 지급 기준 수정 페이지
	@GetMapping("/modifyStandardPoint")
	public String modifyStandardPoint(Model model
									,@RequestParam(value="pointSaveStandardCode") String pointSaveStandardCode
									,@RequestParam(value="msg", required = false) String msg) {
		
		PointSaveStandard PointSaveStandardInfo = pointMapper.getPointSaveStandardInfo(pointSaveStandardCode);
		
		model.addAttribute("title", "포인트 지급 기준 수정");		
		model.addAttribute("pageTitle", "포인트 지급 기준 수정");		
		model.addAttribute("PointSaveStandardInfo", PointSaveStandardInfo);		
		if(msg != null) {
			model.addAttribute("msg", msg);	
		}
		
		return "admin/point/pointModifyStandard";
	}
	
	//포인트 지급 기준 삭제 처리
	@PostMapping("/deleteStandardPoint")
	public String deleteStandardPoint(@RequestParam(value="pointSaveStandardCode") String pointSaveStandardCode
									 ,RedirectAttributes reAttr) {
		
		int result = pointService.deletePointSaveStandard(pointSaveStandardCode);
		if(result == 0) {
			reAttr.addAttribute("msg", "포인트 적립 기준 삭제에 실패하였습니다.");
			return "redirect:/admin/deleteStandardPoint";
		}
		reAttr.addAttribute("msg", result + "개의 데이터가 삭제되었습니다.");
		
		return "redirect:/admin/listStandardPoint";
	}
	
	//포인트 지급 기준 삭제 페이지
	@GetMapping("/deleteStandardPoint")
	public String deleteStandardPoint(Model model
									,@RequestParam(value="pointSaveStandardCode") String pointSaveStandardCode
									,@RequestParam(value="msg", required = false) String msg) {
		
		PointSaveStandard PointSaveStandardInfo = pointMapper.getPointSaveStandardInfo(pointSaveStandardCode);
		
		model.addAttribute("title", "포인트 지급 기준 삭제");
		model.addAttribute("pageTitle", "포인트 지급 기준 삭제");
		model.addAttribute("PointSaveStandardInfo", PointSaveStandardInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/point/pointDeleteStandard";
	}
	
	//포인트 지급 등록 처리
	@PostMapping("/addSavePoint")
	public String addSavePoint(PointSave pointSave, RedirectAttributes reAttr) {
		
		int result = pointService.addPointSave(pointSave);
		if(result == 0) {
			reAttr.addAttribute("msg", "포인트 지급 등록에 실패하였습니다.");
			return "redirect:/admin/addSavePoint";
		}
		reAttr.addAttribute("msg", "포인트 지급 등록에 성공하였습니다.");
		
		return "redirect:/admin/listPoint";
	}
	
	//포인트 지급 등록 페이지
	@GetMapping("/addSavePoint")
	public String addSavePoint(Model model
							  ,@RequestParam(value="msg", required = false) String msg) {
		
		List<String> pointStandardSaveAmountList = pointMapper.getPointStandardSaveAmountList();
		
		model.addAttribute("title", "포인트 지급 등록");
		model.addAttribute("pageTitle", "포인트 지급 등록");
		model.addAttribute("pointStandardSaveAmountList", pointStandardSaveAmountList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/point/pointAddSave";
	}
	@GetMapping("/addMinusPoint")
	public String addMinusPoint() {
		
		return "admin/point/pointAddMinus";
	}
	
	//포인트 지급/차감 총 조회 페이지
	@GetMapping("/listPoint")
	public String listPoint(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		List<PointSaveAndMinus> pointSaveAndMinusList = pointMapper.getPointSaveAndMinusList();
		
		model.addAttribute("title", "포인트 내역 조회");
		model.addAttribute("pageTitle", "포인트 내역 조회");
		model.addAttribute("pointSaveAndMinusList", pointSaveAndMinusList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/point/pointList";
	}
	@GetMapping("/modifySavePoint")
	public String modifySavePoint() {
		
		return "admin/point/pointModifySave";
	}
	@GetMapping("/modifyMinusPoint")
	public String modifyMinusPoint() {
		
		return "admin/point/pointModifyMinus";
	}
	@GetMapping("/deletePoint")
	public String deletePoint() {
		
		return "admin/point/pointDelete";
	}
	
}

