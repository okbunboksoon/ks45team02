package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.mapper.BoardReviewMapper;
import ks45team02.ire.admin.service.BoardReviewService;

@Controller
@RequestMapping("/admin")
public class BoardReviewController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardReviewController.class);

	private final BoardReviewService boardReviewService;
	private final BoardReviewMapper boardReviewMapper;
	
	public BoardReviewController(BoardReviewService boardReviewService, BoardReviewMapper boardReviewMapper) {
		this.boardReviewService = boardReviewService;
		this.boardReviewMapper = boardReviewMapper;
	}

	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model) {
		
		return "admin/board/boardAddReview";
	}
	
	@GetMapping("/deleteBoardReview")
	public String deleteBoardReview() {
		
		return "admin/board/boardDeleteReview";
	}
	
	//리뷰 게시판 상세보기 페이지
	@GetMapping("/contentsBoardReview")
	public String contentsBoardReview(Model model
									 ,@RequestParam(value="reviewCode") String reviewCode
									 ,@RequestParam(value="msg", required = false) String msg) {
		
		BoardReview boardReviewInfo = boardReviewMapper.getBoardReviewInfo(reviewCode);
		
		model.addAttribute("title", "리뷰 글 상세보기");
		model.addAttribute("pageTitle", reviewCode);
		model.addAttribute("boardReviewInfo", boardReviewInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardContentsReview";
	}
	
	//리뷰 게시판 목록 페이지
	@GetMapping("/listBoardReview")
	public String listBoardReview(Model model
								,@RequestParam(value="msg", required = false) String msg) {
		
		List<BoardReview> boardReviewList = boardReviewService.getBoardReviewList();
		log.info("boardReviewList: {}", boardReviewList);
		model.addAttribute("title", "리뷰 게시판 목록");
		model.addAttribute("pageTitle", "리뷰 게시판 목록");
		model.addAttribute("boardReviewList", boardReviewList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardListReview";
	}
	
	
	@GetMapping("/modifyBoardReview")
	public String modifyBoardReview() {
		
		return "admin/board/boardModifyReview";
	}

}

