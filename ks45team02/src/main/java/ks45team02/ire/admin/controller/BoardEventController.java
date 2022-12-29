package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardEventController {

	@GetMapping("/addBoardEvent")
	public String addBoardEvent(Model model) {
		
		return "admin/board/boardAddEvent";
	}

	@GetMapping("/deleteBoardEvent")
	public String deleteBoardEvent() {
		
		return "admin/board/boardDeleteEvent";
	}
	
	@GetMapping("/listBoardEvent")
	public String listBoardEvent() {
		
		return "admin/board/boardListEvent";
	}
	
	@GetMapping("/modifyBoardEvent")
	public String modifyBoardEvent() {
		
		return "admin/board/boardModifyEvent";
	}


}