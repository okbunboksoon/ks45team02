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

import ks45team02.ire.admin.dto.BoardUserGuide;
import ks45team02.ire.admin.service.BoardUserGuideService;

@Controller
@RequestMapping("/admin")
public class BoardUserGuideController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BoardUserGuideController.class);

	private final BoardUserGuideService boardUserGuideService;
	
	public BoardUserGuideController(BoardUserGuideService boardUserGuideService) {
		this.boardUserGuideService = boardUserGuideService;
	}

	
	/**
	 * 이용가이드 목록
	 * @param model
	 */
	@GetMapping("/listBoardUserGuide")
	public String listBoardUserGuide(Model model
			  ,@RequestParam(value="msg", required=false) String msg) {
		
		List<BoardUserGuide> userGuideList = boardUserGuideService.getUserGuideList();
		
		model.addAttribute("userGuideList", userGuideList);
		model.addAttribute("title" , "이용가이드목록");
		model.addAttribute("pageTitle", "이용가이드목록");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/board/boardListUserGuide";
	}
	
	/**
	 * 상세페이지 만들기
	 * @param guide_code model
	 * @return admin/board/boardContentsUserGuide
	 */
	@GetMapping("/ContentsUserGuide")
	public String ContentsUserGuide (@RequestParam(value = "guide_code") String guide_code, Model model) {
		
		List<BoardUserGuide> contentsUserGuide = boardUserGuideService.ContentsUserGuide(guide_code);
		model.addAttribute("title", "이용가이드 상세페이지");
		model.addAttribute("pageTitle", "이용가이드 상세페이지");
		model.addAttribute("contentsUserGuide", contentsUserGuide);
		
		return "admin/board/boardContentsUserGuide";
		
	}
	
	/**
	 * 이용가이드 등록 화면
	 * @return admin/board/boardAddUserGuide
	 */
	@GetMapping("/addBoardUserGuide")
	public String addBoardUserGuide(Model model
			,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "이용가이드 등록");
		model.addAttribute("pageTitle" , "이용가이드 등록");
		
		log.info("result: {} " ,msg);
		if(msg != null) {
			model.addAttribute("msg" , msg);
		}
		return "admin/board/boardAddUserGuide";
	}
	
	/**
	 * 이용가이드 등록
	 * @param boardUserGuide
	 * @return
	 */
	@PostMapping("/addBoardUserGuide")
	public String addBoardUserGuide(BoardUserGuide boardUserGuide, RedirectAttributes reAttr ) {
		
		int result = boardUserGuideService.addUserGuide(boardUserGuide);
		log.info("result: {}", result);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "이용가이드 등록에 실패하였습니다.");
			return "redirect:/admin/addBoardUserGuide";
		}else {
			reAttr.addAttribute("msg", "이용가이드 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardUserGuide";
	}
	
	/**
	 * 이용가이드 수정화면
	 * @param guide_code model
	 * @return admin/board/boardModifyUserGuide
	 */
	@GetMapping("/modifyBoardUserGuide")
	public String modifyBoardUserGuide(@RequestParam(value = "guide_code") String guide_code
										,Model model) {
		
		List<BoardUserGuide> modifyUserGuide = boardUserGuideService.ContentsUserGuide(guide_code);
		
		model.addAttribute("modifyUserGuide", modifyUserGuide);
		model.addAttribute("pageTitle", "이용가이드 수정");
		
		return "admin/board/boardModifyUserGuide";
	}
	
	/**
	 * 이용가이드 수정처리
	 * @param boardUserGuide
	 * @return redirect:/admin/listBoardUserGuide
	 */
	@PostMapping("/modifyBoardUserGuide")
	public String modifyBoardUserGuide(BoardUserGuide boardUserGuide, RedirectAttributes reAttr ) {
		
		int result = boardUserGuideService.modifyBoardUserGuide(boardUserGuide);
		
		log.info("result: {}", result);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "공지사항이 수정에 실패하였습니다.");
			return "redirect:/admin/modifyBoardUserGuide";
		}else {
			reAttr.addAttribute("msg", "공지사항이 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardUserGuide";
	}
	
	/**
	 * 이용가이드 삭제처리
	 * @param boardUserGuide
	 * @return
	 */
	@PostMapping("/deleteBoardUserGuide")
	public String deleteBoardUserGuide(@RequestParam(value = "guide_code") String guide_code
									,RedirectAttributes reAttr) {
		
		int result = boardUserGuideService.deleteBoardUserGuide(guide_code);
		log.info("result: {}", result);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "이용가이드 삭제에 실패하였습니다.");
			return "redirect:/admin/addBoardUserGuide";
		}else {
			reAttr.addAttribute("msg", "이용가이드 삭제에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBoardUserGuide";
	}
	
	

}

