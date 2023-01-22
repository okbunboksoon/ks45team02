package ks45team02.ire.user.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.service.UserBoardReviewService;

@Controller
@RequestMapping("/")
public class UserBoardReviewController {

	private static final Logger log = LoggerFactory.getLogger(UserBoardReviewController.class);

	private final UserBoardReviewService userBoardReviewService;
	
	public UserBoardReviewController(UserBoardReviewService userBoardReviewService) {
		this.userBoardReviewService = userBoardReviewService;
	}
	
	//리뷰 작성 처리
	@PostMapping("/addBoardReview")
	public String addBoardReview(BoardReview boardReview, MultipartFile reviewImage, HttpSession session, RedirectAttributes reAttr
								,@RequestParam(value="orderCode") String orderCode) throws IllegalStateException, IOException {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		boardReview.setUserId(loginId);
		
		int result = userBoardReviewService.addBoardReview(boardReview, reviewImage, orderCode);

		if(result == 1) {
			reAttr.addAttribute("msg", "리뷰 등록에 성공하였습니다.");
		}else {
			reAttr.addAttribute("msg", "리뷰 등록에 실패하였습니다.");
			return "redirect:/addBoardReview";
		}
		
		return "redirect:/listOrder";
	}
	
	//리뷰 작성
	@GetMapping("/addBoardReview")
	public String addBoardReview(Model model
								,@RequestParam(value="orderCode") String orderCode, HttpSession session
								,@RequestParam(value="msg", required = false) String msg) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		
		List<UserGoods> noReviewGoods = userBoardReviewService.getNoReviewGoods(orderCode);
		
		model.addAttribute("title", "리뷰 작성");
		model.addAttribute("noReviewGoods", noReviewGoods);
		model.addAttribute("orderCode", orderCode);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
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
