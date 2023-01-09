package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	 * 공지사항 등록
	 * @param boardNotice
	 * @return
	 */
	@PostMapping("/addBoardNotice")
	public String addBoardNotice(BoardNotice boardNotice, RedirectAttributes reAttr) {

		int result = boardNoticeService.addNotice(boardNotice);
		log.info("result : {}", result);
		if(result == 0) {
			reAttr.addAttribute("msg", "공지사항이 등록에 실패하였습니다.");
			return "redirect:/admin/addBoardNotice";
		}else {
			reAttr.addAttribute("msg", "공지사항이 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardNotice";
	}
	
	/**
	 * 공지사항 등록 화면
	 * @return admin/board/boardAddNotice
	 */
	@GetMapping("/addBoardNotice")
	public String addBoardNotice(Model model
			,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "공지사항 등록");
		model.addAttribute("pageTitle", "공지사항 등록");
		log.info("result1111111111 : {}", msg);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardAddNotice";
	}

	/**
	 * 삭제 처리
	 * @param boardNotice
	 * @return
	 */
	@PostMapping("/deleteBoardNotice")
	public String deleteBoardNotice(@RequestParam(value = "noticeCode") String noticeCode
									,RedirectAttributes reAttr) {
		
		int result = boardNoticeService.deleteBoardNotice(noticeCode);
		log.info("result : {}", result);
		if(result == 0) {
			reAttr.addAttribute("msg", "공지사항이 삭제에 실패하였습니다.");
			return "redirect:/admin/addBoardNotice";
		}else {
			reAttr.addAttribute("msg", "공지사항이 삭제에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardNotice";
	}
	
	/**
	 * 공시사항 목록
	 * @param model
	 */
	@GetMapping("/listBoardNotice")
	public String listBoardNotice(Model model
								  ,@RequestParam(value="msg", required=false) String msg) {
		
		List<BoardNotice> noticeList = boardNoticeService.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("title", "공지사항목록");
		model.addAttribute("pageTitle", "공지사항목록");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardListNotice";
	}
	
	/**
	 * 상세페이지 만들기
	 * @param noticeCode model
	 * @return admin/board/boardDetailsNotice
	 */
	@GetMapping("/ContentsNotice")
	public String ContentsNotice(@RequestParam(value = "noticeCode") String noticeCode, Model model) {

		List<BoardNotice> contentsNotice = boardNoticeService.ContentsNotice(noticeCode);
		model.addAttribute("title", "공지사항 상세페이지");
		model.addAttribute("pageTitle", "상세페이지");
		model.addAttribute("contentsNotice", contentsNotice);
		
		return "admin/board/boardContentsNotice";
	}
	
	/**
	 * 공지사항 수정화면
	 * @param noticeCode model
	 * @return admin/board/boardModifyNotice
	 */
	@GetMapping("/modifyBoardNotice")
	public String modifyBoardNotice(@RequestParam(value = "noticeCode") String noticeCode
									,Model model) {
		
		List<BoardNotice> modifyNotice = boardNoticeService.ContentsNotice(noticeCode);
		
		model.addAttribute("modifyNotice", modifyNotice);
		model.addAttribute("pageTitle", "공지사항 수정");
		
		return "admin/board/boardModifyNotice";
	}
	
	/**
	 * 공지사항 수정처리
	 * @param boardNotice
	 * @return redirect:/admin/listBoardNotice
	 */
	@PostMapping("/modifyBoardNotice")
	public String modifyBoardNotice(BoardNotice boardNotice, RedirectAttributes reAttr) {
		
		int result = boardNoticeService.modifyBoardNotice(boardNotice);

		log.info("result : {}", result);
		if(result == 0) {
			reAttr.addAttribute("msg", "공지사항이 수정에 실패하였습니다.");
			return "redirect:/admin/addBoardNotice";
		}else {
			reAttr.addAttribute("msg", "공지사항이 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardNotice";
	}

}

