package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardNoticeController {

	@GetMapping("/addBoardNotice")
	public String addBoardNotice(Model model) {
		
		return "admin/board/boardAddNotice";
	}
	
	@GetMapping("/deleteBoardNotice")
	public String deleteBoardNotice() {
		
		return "admin/board/boardDeleteNotice";
	}
	
	@GetMapping("/listBoardNotice")
	public String listBoardNotice() {
		
		return "admin/board/boardListNotice";
	}
	
	
	@GetMapping("/modifyBoardNotice")
	public String modifyBoardNotice() {
		
		return "admin/board/boardModifyNotice";
	}

}

