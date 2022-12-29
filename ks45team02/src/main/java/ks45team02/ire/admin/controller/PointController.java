package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PointController {

	@GetMapping("/addStandardPoint")
	public String addStandardPoint(Model model) {
		
		return "admin/point/pointAddStandard";
	}
	
	@GetMapping("/listPoint")
	public String listPoint() {
		
		return "admin/point/pointList";
	}
	@GetMapping("/listStandardPoint")
	public String listStandardPoint() {
		
		return "admin/point/pointListStandard";
	}
	@GetMapping("/MinusPoint")
	public String MinusPoint() {
		
		return "admin/point/pointMinus";
	}
	@GetMapping("/modifyStandardPoint")
	public String modifyStandardPoint() {
		
		return "admin/point/pointModifyStandard";
	}
	@GetMapping("/savePoint")
	public String savePoint() {
		
		return "admin/point/pointSave";
	}
	
	
	@GetMapping("/usePoint")
	public String usePoint() {
		
		return "admin/point/pointUse";
	}

}

