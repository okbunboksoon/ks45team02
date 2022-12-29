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
	
	@GetMapping("/listStandardPoint")
	public String listStandardPoint() {
		
		return "admin/point/pointListStandard";
	}
	
	@GetMapping("/modifyStandardPoint")
	public String modifyStandardPoint() {
		
		return "admin/point/pointModifyStandard";
	}
	
	@GetMapping("/deleteStandardPoint")
	public String deleteStandardPoint() {
		
		return "admin/point/pointDeleteStandard";
	}
	
	@GetMapping("/listPoint")
	public String listPoint() {
		
		return "admin/point/pointList";
	}
	@GetMapping("/addSavePoint")
	public String addSavePoint() {
		
		return "admin/point/pointSaveAdd";
	}
	@GetMapping("/addMinusPoint")
	public String addMinusPoint() {
		
		return "admin/point/pointMinusAdd";
	}
	@GetMapping("/modifySavePoint")
	public String modifySavePoint() {
		
		return "admin/point/pointSaveModify";
	}
	@GetMapping("/modifyMinusPoint")
	public String modifyMinusPoint() {
		
		return "admin/point/pointMinusModify";
	}
	@GetMapping("/deletePoint")
	public String deletePoint() {
		
		return "admin/point/pointDelete";
	}
	
}

