package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserBoardReviewController {

	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model) {
		
		return "user/board/boardAddReview";
	}
	
	@GetMapping("/deleteBoardReview")
	public String deleteBoardReview() {
		
		return "user/board/boardDeleteReview";
	}
	
	@GetMapping("/listBoardReview")
	public String listBoardReview() {
		
		return "user/board/boardListReview";
	}
		
	@GetMapping("/modifyBoardReview")
	public String modifyBoardReview() {
		
		return "user/board/boardModifyReview";
	}
	@GetMapping("/searchBoardReview")
	public String searchBoardReview() {
		
		return "user/board/boardSearchReview";
	}
}

