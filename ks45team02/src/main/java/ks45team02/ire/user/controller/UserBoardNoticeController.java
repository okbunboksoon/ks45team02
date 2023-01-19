package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.service.BoardNoticeService;

@Controller
@RequestMapping("/")
public class UserBoardNoticeController {

	private final BoardNoticeService boardNoticeService;
	
	public UserBoardNoticeController(BoardNoticeService boardNoticeService) {
		
		this.boardNoticeService = boardNoticeService;
		
	}
	
	/**
	 * 공시사항 목록
	 * @param model
	 */
	@GetMapping("/listBoardNotice")
	public String listBoardNotice(Model model) {
		
		List<BoardNotice> noticeList = boardNoticeService.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("title", "공지사항목록");
		
		return "user/board/boardListNotice";
	}
	
	/** 
	 * 상세페이지
	 * @param noticeCode model
	 * @return user/board/boardContentsNotice
	 */
	@GetMapping("/ContentsNotice")
	public String ContentsUserGuide (@RequestParam(value = "noticeCode") String noticeCode, Model model) throws Exception {
		
		List<BoardNotice> contentsNotice = boardNoticeService.ContentsNotice(noticeCode);
		model.addAttribute("title", "공지사항 상세페이지");
		model.addAttribute("contentsNotice", contentsNotice);
		return "user/board/boardContentsNotice";
	}
}

