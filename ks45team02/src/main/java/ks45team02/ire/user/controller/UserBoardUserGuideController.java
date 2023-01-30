package ks45team02.ire.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.BoardUserGuide;
import ks45team02.ire.admin.service.BoardUserGuideService;
import ks45team02.ire.user.service.UserBoardUserGuideService;

@Controller
@RequestMapping("/")
public class UserBoardUserGuideController {

	private static final Logger log = LoggerFactory.getLogger(UserBoardUserGuideController.class);

	private final UserBoardUserGuideService userBoardUserGuideService;

	public UserBoardUserGuideController(UserBoardUserGuideService userBoardUserGuideService) {
		this.userBoardUserGuideService = userBoardUserGuideService;
	}

	/**
	 * 이용가이드 목록
	 * 
	 * @param model
	 */
	
	  @GetMapping("/listBoardUserGuide")
	  
	  public String listBoardUserGuide(Model model)  {
	  
	  List <BoardUserGuide> userGuideList = userBoardUserGuideService.getUserGuideList();
	  
	  model.addAttribute("title", "Ire 이용가이드"); 
	  model.addAttribute("userGuideList",userGuideList); 

	  
	  return "user/board/boardListUserGuide"; }
	 

		
		/**
			 * 상세페이지
			 * 
			 * @param guide_code model
			 * @return user/board/boardContentsUserGuide
			 */
	  @GetMapping("/ContentsUserGuide") 
	  public String ContentsUserGuide (@RequestParam(value = "guide_code") String guide_code, Model model) throws
	  Exception {
	  
	  userBoardUserGuideService.updateViewsCnt(guide_code);
	  
	  List<BoardUserGuide> contentsUserGuide =
	  userBoardUserGuideService.ContentsUserGuide(guide_code);
	  model.addAttribute("title", "이용가이드 상세페이지"); model.addAttribute("pageTitle",
	  "이용가이드 상세페이지"); model.addAttribute("contentsUserGuide", contentsUserGuide);
	  
	  return "user/board/boardContentsUserGuide";
	  
	  }
				 

}
