package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.BoardEvent;
import ks45team02.ire.admin.mapper.BoardEventMapper;
import ks45team02.ire.admin.service.BoardEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BoardEventController {

	private static final Logger log = LoggerFactory.getLogger(BoardEventController.class);

	private final BoardEventService boardEventService;
	private final BoardEventMapper boardEventMapper;

	public BoardEventController(BoardEventService boardEventService, BoardEventMapper boardEventMapper) {
		this.boardEventService = boardEventService;
		this.boardEventMapper = boardEventMapper;
	}

	@PostMapping("/addBoardEvent")
	public String addBoardEvent(BoardEvent boardEvent){
		log.info("이벤트 등록 쿼리파라미터: {}", boardEvent);
		boardEventService.addBoardEvent(boardEvent);

		return "redirect:/admin/listBoardEvent";
	}


	@GetMapping("/addBoardEvent")
	public String addBoardEvent(Model model) {

		List<BoardEvent> boardEventTitleList = boardEventMapper.getBoardEventTitleList();

		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("boardEventTitleList", boardEventTitleList );
		return "admin/board/boardAddEvent";
	}

	@GetMapping("/deleteBoardEvent")
	public String deleteBoardEvent() {
		
		return "admin/board/boardDeleteEvent";
	}
	
	@GetMapping("/listBoardEvent")
	public String listBoardEvent(Model model) {
		List<BoardEvent> boardEventList = boardEventService.getBoardEventList();
		log.info("이벤트 목록 조회: {}", boardEventList);

		model.addAttribute("title", "이벤트 목록");
		model.addAttribute("boardEventList", boardEventList);
		
		return "admin/board/boardListEvent";
	}

	@GetMapping("/viewBoardEvent")
	public String viewBoardEvent(@RequestParam(value = "eventTitle", required = false)String eventTitle, Model model){
		List<BoardEvent> boardEventContents = boardEventService.viewBoardEvent(eventTitle);

		model.addAttribute("title", "이벤트 내용");
		model.addAttribute("boardEventContents", boardEventContents);
		return "admin/board/boardViewEvent";
	}
	
	@GetMapping("/modifyBoardEvent")
	public String modifyBoardEvent() {
		
		return "admin/board/boardModifyEvent";
	}


}
