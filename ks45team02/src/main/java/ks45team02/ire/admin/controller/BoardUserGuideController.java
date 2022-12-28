package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardUserGuideController {

	@GetMapping("/addBoardUserGuide")
	public String addBoardUserGuide(Model model) {
		
		return "/admin/board/boardAddUserGuide";
	}
	
	@GetMapping("/deleteBoardUserGuide")
	public String deleteBoardUserGuide() {
		
		return "/admin/board/boardDeleteUserGuide";
	}
	
	@GetMapping("/listBoardUserGuide")
	public String listBoardUserGuide() {
		
		return "/admin/board/boardListUserGuide";
	}
	
	
	@GetMapping("/modifyBoardUserGuide")
	public String modifyBoardUserGuide() {
		
		return "/admin/board/boardModifyUserGuide";
	}

}

