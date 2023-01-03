
package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.BoardFAQ;
import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.service.BoardFAQService;
import ks45team02.ire.admin.service.BoardNoticeService;

@Controller
@RequestMapping("/admin")
public class BoardFAQController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeController.class);

	
	private final BoardFAQService boardFAQService;
	
	public BoardFAQController(BoardFAQService boardFAQService) {
		
		this.boardFAQService = boardFAQService;
		
	}
	
	/**
	 * FAQ 등록 화면
	 * @return admin/board/boardAddNotice
	 */
	@GetMapping("/addBoardFAQ")
	public String addBoardFAQ(Model model) {
		
		model.addAttribute("title", "FAQ 등록");
		
		return "admin/board/boardAddFAQ";
	}
	
	/**
	 * FAQ 등록
	 * @param boardFAQ
	 * @return
	 */
	
	@PostMapping("/addBoardFAQ")
	public String addBoardFAQ(BoardFAQ boardFAQ) {
		
		log.info("FAQ 정보 :{}", boardFAQ);
		
		boardFAQService.addFAQ(boardFAQ);
		
		return "redirect:/admin/listBoardFAQ";
	}
	
	@GetMapping("/deleteBoardFAQ")
	public String deleteBoardFAQ() {
		
		return "admin/board/boardDeleteFAQ";
	}
	
	/**
	 * FAQ 리스트
	 * @param model
	 */
	@GetMapping("/listBoardFAQ")
	public String listBoardFAQ(Model model) {
		
		List<BoardFAQ> FAQList = boardFAQService.getFAQList();
		
		model.addAttribute("FAQList", FAQList);
		model.addAttribute("title", "FAQ 리스트");
		model.addAttribute("subTitle", "FAQ 리스트");
		log.info("FAQList : {}" , FAQList);
		
		return "admin/board/boardListFAQ";
	}
	
	
	@GetMapping("/modifyBoardFAQ")
	public String modifyBoardFAQ() {
		
		return "admin/board/boardModifyFAQ";
	}

}

