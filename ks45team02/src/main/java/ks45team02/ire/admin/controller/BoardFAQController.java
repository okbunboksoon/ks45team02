
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

import ks45team02.ire.admin.dto.BoardFAQ;
import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.service.BoardFAQService;
import ks45team02.ire.admin.service.BoardNoticeService;

@Controller
@RequestMapping("/admin")
public class BoardFAQController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeController.class);

	
	private final BoardFAQService boardFAQService;
	
	public BoardFAQController(BoardFAQService boardFAQService) {
		
		this.boardFAQService = boardFAQService;
		
	}
	
	/**
	 * FAQ 등록 화면
	 * @return admin/board/boardAddNotice
	 */
	@GetMapping("/addBoardFAQ")
	public String addBoardFAQ(Model model) {
		
		model.addAttribute("title", "FAQ 등록");
		
		return "admin/board/boardAddFAQ";
	}
	
	/**
	 * FAQ 등록
	 * @param boardFAQ
	 * @return
	 */
	
	@PostMapping("/addBoardFAQ")
	public String addBoardFAQ(BoardFAQ boardFAQ) {
		
		log.info("FAQ 정보 :{}", boardFAQ);
		
		boardFAQService.addFAQ(boardFAQ);
		
		return "redirect:/admin/listBoardFAQ";
	}
	
	
	/**
	 * FAQ 리스트
	 * @param model
	 */
	@GetMapping("/listBoardFAQ")
	public String listBoardFAQ(Model model) {
		
		List<BoardFAQ> FAQList = boardFAQService.getFAQList();
		
		model.addAttribute("FAQList", FAQList);
		model.addAttribute("title", "FAQ 리스트");
		model.addAttribute("subTitle", "FAQ 리스트");
		log.info("FAQList : {}" , FAQList);
		
		return "admin/board/boardListFAQ";
	}
	
	/**
	 * 상세페이지 만들기
	 * @param FAQ_code model
	 * @return admin/board/boardContentsFAQ
	 *
	 */
	@GetMapping("/contentsFAQ")
	public String contentsFAQ(@RequestParam(value = "FAQ_code") String FAQ_code, Model model) throws Exception{
		
		log.info("FAQ_code : {}" , FAQ_code);
		
		boardFAQService.updateFAQViewsCnt(FAQ_code);
		List<BoardFAQ> contentsFAQ = boardFAQService.contentsFAQ(FAQ_code);
		model.addAttribute("title", "FAQ 상세페이지");
		model.addAttribute("contentsFAQ", contentsFAQ);
		model.addAttribute("subTitle", "상세페이지");
		log.info("contentsFAQ : {}", contentsFAQ);
		
		return "admin/board/boardContentsFAQ";
		
	}
	
	/**
	 * FAQ 수정화면
	 * @param FAQ_code model
	 * @return admin/board/boardModifyFAQ
	 */
	
	@GetMapping("/modifyBoardFAQ")
	public String modifyBoardFAQ(@RequestParam(value ="FAQ_code") String FAQ_code, Model model) {
		
		List<BoardFAQ> modifyFAQ = boardFAQService.contentsFAQ(FAQ_code);
		
		model.addAttribute("modifyFAQ", modifyFAQ);
		log.info("modifyFAQ: {}", modifyFAQ);
		
		return "admin/board/boardModifyFAQ";
	}
	
	/**
	 * FAQ 수정처리
	 * @param boardFAQ
	 * @return redirect:/admin/listBoardFAQ
	 */
	@PostMapping("/modifyBoardFAQ")
	public String modifyBoardFAQ(BoardFAQ boardFAQ) {
		
		log.info("FAQ수정 정보: {}", boardFAQ);
		boardFAQService.modifyBoardFAQ(boardFAQ);
		
		return "redirect:/admin/listBoardFAQ";
	}
	

	
	
	
	/**
	 * FAQ 삭제처리
	 * @param boardFAQ
	 * @return
	 */
	@PostMapping(("/deleteBoardFAQ"))
	public String deleteBoardFAQ (@RequestParam(value="FAQ_code") String FAQ_code){
		
		log.info("FAQ 삭제 정보: {}", FAQ_code);
		
		boardFAQService.deleteBoardFAQ(FAQ_code);
		
		return "redirect:/admin/listBoardFAQ";
	}

}

