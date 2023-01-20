package ks45team02.ire.user.controller;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.user.service.UserBoardReviewService;

@Controller
@RequestMapping("/")
public class UserBoardReviewController {

	private final UserBoardReviewService userBoardReviewService;
	
	public UserBoardReviewController(UserBoardReviewService userBoardReviewService) {
		this.userBoardReviewService = userBoardReviewService;
	}
	
	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model) {
		
		return "user/board/boardAddReview";
	}
	
	//특정 상품 리뷰 조회
	@ResponseBody
	@GetMapping("/listBoardReview")
	public Map<String, Object> listBoardReview(@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
								 ,@RequestParam(value="goodsCode") String goodsCode
								 ,Model model) {
		
		Map<String, Object> pageMap = userBoardReviewService.getReviewForGoods(goodsCode, currentPage);
		
		int lastPage = (int) pageMap.get("lastPage");
		@SuppressWarnings("unchecked")
		List<BoardReview> reviewForGoods = (List<BoardReview>) pageMap.get("reviewForGoods");
		int startPageNum = (int) pageMap.get("startPageNum");
		int endPageNum = (int) pageMap.get("endPageNum");
		
		model.addAttribute("title", "주문 내역");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("reviewForGoods", reviewForGoods);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return pageMap;
	}
	
}
