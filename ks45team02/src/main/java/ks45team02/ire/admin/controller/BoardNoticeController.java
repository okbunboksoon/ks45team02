package ks45team02.ire.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.service.BoardNoticeService;

@Controller
@RequestMapping("/admin")
public class BoardNoticeController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeController.class);

	
	private final BoardNoticeService boardNoticeService;
	
	public BoardNoticeController(BoardNoticeService boardNoticeService) {
		
		this.boardNoticeService = boardNoticeService;
		
	}
	
	/**
	 * 공지사항 등록 화면
	 * @return admin/board/boardAddNotice
	 */
	@GetMapping("/addBoardNotice")
	public String addBoardNotice(Model model) {
		
		model.addAttribute("title", "공지사항 등록");
		
		return "admin/board/boardAddNotice";
	}
	
	/**
	 * 공지사항 등록
	 * @param boardNotice
	 * @return
	 */
	@PostMapping("/addBoardNotice")
	public String addBoardNotice(BoardNotice boardNotice) {
		
		log.info("공지사항등록 정보 :{}", boardNotice);
		
		boardNoticeService.addNotice(boardNotice);
		
		return "redirect:/admin/listBoardNotice";
	}
	
	@GetMapping("/deleteBoardNotice")
	public String deleteBoardNotice(@RequestParam(value = "noticeCode") String noticeCode, Model model) {
		
		log.info("deleteBoardNotice noticeCode : {}", noticeCode);
		
		List<BoardNotice> deleteNotice = boardNoticeService.detailsNotice(noticeCode);
		model.addAttribute("deleteNotice", deleteNotice);
		
		log.info("deleteNotice : {}", deleteNotice);
		
		return "admin/board/boardDeleteNotice";
	}
	
	/**
	 * 삭제 처리
	 * @param boardNotice
	 * @return
	 */
	@PostMapping("/deleteBoardNotice")
	public String deleteBoardNotice(BoardNotice boardNotice) {
		
		log.info("공지사항삭제 정보 :{}", boardNotice);
		
		boardNoticeService.deleteBoardNotice(boardNotice);
		
		return "redirect:/admin/listBoardNotice";
	}
	
	/**
	 * 공시사항 목록
	 * @param model
	 * @return admin/board/boardListNotice
	 */
	@GetMapping("/listBoardNotice")
	public String listBoardNotice(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> paramNoticeMap = boardNoticeService.getNoticeList(currentPage);
		List<BoardNotice> noticeList = (List<BoardNotice>) paramNoticeMap.get("noticeList");
		int startPageNum = (int) paramNoticeMap.get("startPageNum");
		int endPageNum = (int) paramNoticeMap.get("endPageNum");
		int lastPage = (int) paramNoticeMap.get("lastPage");
		
		model.addAttribute("title", "공지사항목록");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("lastPage", lastPage);
		
		log.info("noticeList : {}", noticeList);

		return "admin/board/boardListNotice";
	}
	
	/**
	 * 상세페이지 만들기
	 * @param noticeCode model
	 * @return admin/board/boardDetailsNotice
	 */
	@GetMapping("/detailsNotice")
	public String detailsNotice(@RequestParam(value = "noticeCode") String noticeCode, Model model) {

		log.info("noticeCode : {}", noticeCode);
		List<BoardNotice> detailsNotice = boardNoticeService.detailsNotice(noticeCode);
		model.addAttribute("title", "공지사항 상세페이지");
		model.addAttribute("detailsNotice", detailsNotice);
		model.addAttribute("pageTitle", "상세페이지");
		log.info("detailsNotice : {}", detailsNotice);
		
		return "admin/board/boardDetailsNotice";
	}
	
	/**
	 * 공지사항 수정화면
	 * @param noticeCode model
	 * @return admin/board/boardModifyNotice
	 */
	@GetMapping("/modifyBoardNotice")
	public String modifyBoardNotice(@RequestParam(value = "noticeCode") String noticeCode, Model model) {
		
		List<BoardNotice> modifyNotice = boardNoticeService.detailsNotice(noticeCode);
		
		model.addAttribute("modifyNotice", modifyNotice);
		log.info("modifyNotice : {}", modifyNotice);
		
		return "admin/board/boardModifyNotice";
	}
	
	/**
	 * 공지사항 수정처리
	 * @param boardNotice
	 * @return redirect:/admin/listBoardNotice
	 */
	@PostMapping("/modifyBoardNotice")
	public String modifyBoardNotice(BoardNotice boardNotice) {
		
		log.info("공지사항수정 정보 :{}", boardNotice);
		
		boardNoticeService.modifyBoardNotice(boardNotice);
		
		return "redirect:/admin/listBoardNotice";
	}

}

