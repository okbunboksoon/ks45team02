package ks45team02.ire.admin.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//리뷰 글 등록 처리
	@PostMapping("/addBoardReview")
	public String addBoardReview(BoardReview boardReview, RedirectAttributes reAttr
								,MultipartFile reviewImage) throws IllegalStateException, IOException {
		
		int result = boardReviewService.addBoardReview(boardReview, reviewImage);

		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			return "redirect:/admin/addBoardReview";
		}else if(result == 1) {
			reAttr.addAttribute("msg", "리뷰 등록에 성공하였습니다.");
		}else {
			reAttr.addAttribute("msg", "리뷰 등록에 실패하였습니다.");
			return "redirect:/admin/addBoardReview";
		}
		
		return "redirect:/admin/listBoardReview";
	}
	
	//리뷰 글 등록 페이지
	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model
							   ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "리뷰 글 등록");
		model.addAttribute("pageTitle", "리뷰 글 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardAddReview";
	}
	
	@GetMapping("/deleteBoardReview")
	public String deleteBoardReview() {
		
		return "admin/board/boardDeleteReview";
	}
	
	//리뷰 글 상세보기 페이지
	@GetMapping("/contentsBoardReview")
	public String contentsBoardReview(Model model
									 ,@RequestParam(value="reviewCode") String reviewCode
									 ,@RequestParam(value="msg", required = false) String msg) {
		
		BoardReview boardReviewInfo = boardReviewService.getBoardReviewInfo(reviewCode);
		
		model.addAttribute("title", "리뷰 글 상세보기");
		model.addAttribute("pageTitle", reviewCode);
		model.addAttribute("boardReviewInfo", boardReviewInfo);
		model.addAttribute("reviewCode", reviewCode);
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
		
		model.addAttribute("title", "리뷰 게시판 목록");
		model.addAttribute("pageTitle", "리뷰 게시판 목록");
		model.addAttribute("boardReviewList", boardReviewList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardListReview";
	}
	
	//리뷰 글 수정 처리
	@PostMapping("/modifyBoardReview")
	public String modifyBoardReview(BoardReview boardReview, RedirectAttributes reAttr, MultipartFile reviewImage) throws IllegalStateException, IOException {
		
		int result = boardReviewService.modifyBoardReview(boardReview, reviewImage);
		
		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			reAttr.addAttribute("reviewCode", boardReview.getReviewCode());
			return "redirect:/admin/modifyBoardReview";
		}else if(result == 1) {
			reAttr.addAttribute("msg", "리뷰 글 수정에 성공하였습니다..");
		}else {
			reAttr.addAttribute("msg", "리뷰 글 수정에 실패하였습니다.");
			reAttr.addAttribute("reviewCode", boardReview.getReviewCode());
			return "redirect:/admin/modifyBoardReview";
		}
		
		return "redirect:/admin/listBoardReview";
	}
	
	//리뷰 글 수정 페이지
	@GetMapping("/modifyBoardReview")
	public String modifyBoardReview(Model model
								   ,@RequestParam(value="reviewCode") String reviewCode
								   ,@RequestParam(value="msg", required = false) String msg) {
		
		BoardReview boardReviewInfo = boardReviewService.getBoardReviewInfo(reviewCode);
		
		model.addAttribute("title", "리뷰 글 수정");
		model.addAttribute("pageTitle", "리뷰 글 수정");
		model.addAttribute("boardReviewInfo", boardReviewInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardModifyReview";
	}

}

