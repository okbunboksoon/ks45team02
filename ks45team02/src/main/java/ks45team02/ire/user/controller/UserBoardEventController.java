package ks45team02.ire.user.controller;

import ks45team02.ire.admin.dto.BoardEvent;
import ks45team02.ire.admin.mapper.BoardEventMapper;
import ks45team02.ire.admin.service.BoardEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserBoardEventController {

	private final BoardEventService boardEventService;
	private final BoardEventMapper boardEventMapper;

	public UserBoardEventController(BoardEventService boardEventService, BoardEventMapper boardEventMapper) {
		this.boardEventService = boardEventService;
		this.boardEventMapper = boardEventMapper;
	}


	@GetMapping("/listBoardEvent")
	public String listBoardEvent(Model model) {

		List<BoardEvent> boardEventList = boardEventService.getBoardEventList();

		model.addAttribute("title", "이벤트 목록");
		model.addAttribute("boardEventList", boardEventList);
		
		return "user/board/boardListEvent";
	}
	@GetMapping("/viewBoardEvent")
	public String viewBoardEvent(@RequestParam(value = "eventTitle", required = false)String eventTitle,
								 @RequestParam(value = "eventFileIdx", required = false) String eventFileIdx, Model model) {
		//이벤트 조회

		BoardEvent boardEventContents = boardEventService.viewBoardEvent(eventTitle);

		model.addAttribute("title", "이벤트 내용");
		model.addAttribute("boardEventContents", boardEventContents);
		return "user/board/boardContentsEvent";
	}

}
