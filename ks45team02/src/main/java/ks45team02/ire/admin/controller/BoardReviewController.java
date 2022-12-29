package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardReviewController {

	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model) {
		
		return "admin/board/boardAddReview";
	}
	
	@GetMapping("/deleteBoardReview")
	public String deleteBoardReview() {
		
		return "admin/board/boardDeleteReview";
	}
	
	@GetMapping("/listBoardReview")
	public String listBoardReview() {
		
		return "admin/board/boardListReview";
	}
	
	
	@GetMapping("/modifyBoardReview")
	public String modifyBoardReview() {
		
		return "admin/board/boardModifyReview";
	}
	@GetMapping("/searchBoardReview")
	public String searchBoardReview() {
		
		return "admin/board/boardSearchReview";
	}

}

