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
	
	@GetMapping("/listBoardReview")
	public String listBoardReview() {
		
		return "user/board/boardListReview";
	}
	
}
