package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserBoardInquiryController {

	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model) {
		
		return "user/board/boardAddInquiry";
	}
	
	@GetMapping("/deleteBoardInquiry")
	public String deleteBoardInquiry() {
		
		return "user/board/boardDeleteInquiry";
	}
	
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry() {
		
		return "user/board/boardListInquery";
	}

	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry() {
		
		return "user/board/boardListInqueryAnswer";
	}

	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry() {
		
		return "user/board/boardModifyInquiry";
	}

}

