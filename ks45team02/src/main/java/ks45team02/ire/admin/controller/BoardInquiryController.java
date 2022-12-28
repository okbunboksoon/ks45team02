package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardInquiryController {

	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model) {
		
		return "/admin/board/boardAddInquiry";
	}
	
	@GetMapping("/deleteBoardInquiry")
	public String deleteBoardInquiry() {
		
		return "/admin/board/boardDeleteInquiry";
	}
	@GetMapping("/answerBoardInquiry")
	public String answerBoardInquiry() {
		
		return "/admin/board/boardInqueryAnswer";
	}
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry() {
		
		return "/admin/board/boardListInquery";
	}

	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry() {
		
		return "/admin/board/boardListInqueryAnswer";
	}

	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry() {
		
		return "/admin/board/boardModifyInquiry";
	}

}

