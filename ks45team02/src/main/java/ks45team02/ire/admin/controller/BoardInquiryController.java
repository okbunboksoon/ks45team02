package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.BoardInquiry;
import ks45team02.ire.admin.service.BoardInquiryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BoardInquiryController {
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeController.class);
	private final BoardInquiryService boardInquiryService;

	public BoardInquiryController(BoardInquiryService boardInquiryService) {
		this.boardInquiryService = boardInquiryService;
	}

	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model) {
		// 1:1문의 등록
		model.addAttribute("pageTitle","1:1문의 등록");
		return "admin/board/boardAddInquiry";
	}
	@PostMapping("/addBoardInquiry")
	public String addBoardInquiry(BoardInquiry boardInquiry){
		boardInquiryService.addInquiry(boardInquiry);
		return "redirect:/admin";
	}
	
	@GetMapping("/deleteBoardInquiry")
	public String deleteBoardInquiry() {
		
		return "admin/board/boardDeleteInquiry";
	}
	@GetMapping("/answerBoardInquiry")
	public String answerBoardInquiry() {
		
		return "admin/board/boardInquiryAnswer";
	}
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry(Model model) {
		List<BoardInquiry>boardInquiryList= boardInquiryService.boardInquiryList();
		model.addAttribute("pageTitle","1:1문의 조회");
		model.addAttribute("boardInquiryList",boardInquiryList);
		log.info("1:1문의조회:{}",boardInquiryList);

		return "admin/board/boardListInquiry";
	}

	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry() {
		
		return "admin/board/boardListInquiryAnswer";
	}

	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry() {
		
		return "admin/board/boardModifyInquiry";
	}

}

