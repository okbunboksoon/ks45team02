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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
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
	public String addBoardEvent(BoardEvent boardEvent, RedirectAttributes reAttr, MultipartFile eventImage) throws  IllegalStateException, IOException {

		log.info("이벤트 등록 쿼리파라미터: {}", boardEvent);
		log.info("파일 업로드: {}", eventImage.getOriginalFilename());

		int result = boardEventService.addBoardEvent(boardEvent, eventImage);

		return "redirect:/admin/listBoardEvent";
	}


	@GetMapping("/addBoardEvent")
	public String addBoardEvent(Model model) {

		List<BoardEvent> boardEventTitleList = boardEventMapper.getBoardEventTitleList();

		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("boardEventTitleList", boardEventTitleList);
		return "admin/board/boardAddEvent";
	}

	@PostMapping("/deleteBoardEvent")
	//이벤트 삭제
	public String deleteBoardEvent(@RequestParam(value = "eventCode")String eventCode,
								   RedirectAttributes reAttr){

		int result = boardEventService.deleteBoardEvent(eventCode);
		log.info("result: {}", result);
		reAttr.addAttribute("msg", "이벤트 삭제에 성공하였습니다.");

		return "redirect:/admin/listBoardEvent";
	}
	@GetMapping("/listBoardEvent")
	public String listBoardEvent(@RequestParam(value = "eventFileIdx", required = false) String eventFileIdx, Model model) {
		//이벤트 목록
		List<BoardEvent> boardEventList = boardEventService.getBoardEventList();
		log.info("이벤트 목록 조회: {}", boardEventList);


		model.addAttribute("title", "이벤트 목록");
		model.addAttribute("boardEventList", boardEventList);

		
		return "admin/board/boardListEvent";
	}

	@GetMapping("/viewBoardEvent")
	public String viewBoardEvent(Model model, @RequestParam(value = "eventTitle", required = false)String eventTitle
								  ){
		//이벤트 조회

		BoardEvent boardEventContents = boardEventService.viewBoardEvent(eventTitle);

		model.addAttribute("title", "이벤트 내용");
		model.addAttribute("boardEventContents", boardEventContents);
		return "admin/board/boardContentsEvent";
	}
	
	@GetMapping("/modifyBoardEvent")
	public String modifyBoardEvent(@RequestParam(value = "eventTitle", required = false)String eventTitle, Model model) {

		BoardEvent boardEventInfo = boardEventService.modifyBoardEvent(eventTitle);

		model.addAttribute("title", "이벤트 수정");
		model.addAttribute("boardEventInfo", boardEventInfo);
		return "admin/board/boardModifyEvent";
	}

	@PostMapping("/modifyBoardEvent")
	public String modifyBoardEvent(BoardEvent boardEvent){

		log.info("수정할 이벤트 정보: {}", boardEvent);
		boardEventService.modifyBoardEventInfo(boardEvent);
		return "redirect:/admin/listBoardEvent";
	}
}
