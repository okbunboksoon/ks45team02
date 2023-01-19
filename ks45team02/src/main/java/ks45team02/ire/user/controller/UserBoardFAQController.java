
package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.BoardFAQ;
import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.service.BoardFAQService;

@Controller
@RequestMapping("/")
public class UserBoardFAQController {

	private final BoardFAQService boardFAQService;
	
	public UserBoardFAQController(BoardFAQService boardFAQService) {
		
		this.boardFAQService = boardFAQService;
		
	}
	
	/**
	 * FAQ 목록
	 * @param model
	 */
	@GetMapping("/listBoardFAQ")
	public String listBoardFAQ(Model model) {
		
		List<BoardFAQ> FAQList = boardFAQService.getFAQList();
		
		model.addAttribute("title", "FAQ 리스트");
		model.addAttribute("FAQList", FAQList);
		
		return "user/board/boardListFAQ";
	}
	
	/** 
	 * 상세페이지
	 * @param FAQ_code model
	 * @return user/board/boardContentsFAQ
	 */
	@GetMapping("/ContentsFAQ")
	public String ContentsUserGuide (@RequestParam(value = "FAQ_code") String FAQ_code, Model model) throws Exception {
		
		List<BoardFAQ> contentsFAQ = boardFAQService.contentsFAQ(FAQ_code);
		model.addAttribute("title", "공지사항 상세페이지");
		model.addAttribute("contentsFAQ", contentsFAQ);
		
		return "user/board/boardContentsFAQ";
	}
}

