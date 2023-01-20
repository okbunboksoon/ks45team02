package ks45team02.ire.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import ks45team02.ire.admin.dto.BoardEvent;
import ks45team02.ire.admin.dto.BoardEventFile;
import ks45team02.ire.admin.mapper.BoardEventMapper;
import ks45team02.ire.admin.service.BoardEventService;
import ks45team02.ire.admin.service.BoardEventfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BoardEventController {

	private static final Logger log = LoggerFactory.getLogger(BoardEventController.class);

	private final BoardEventService boardEventService;
	private final BoardEventMapper boardEventMapper;
	private final BoardEventfileService boardEventfileService;

	public BoardEventController(BoardEventService boardEventService, BoardEventMapper boardEventMapper, BoardEventfileService boardEventfileService) {
		this.boardEventService = boardEventService;
		this.boardEventMapper = boardEventMapper;
		this.boardEventfileService = boardEventfileService;
	}

	@PostMapping("/addBoardEvent")
	public String addBoardEvent(BoardEvent boardEvent, @RequestPart(value = "eventImage", required = false)
								MultipartFile[] eventImage, Model model, HttpServletRequest request){

		log.info("이벤트 등록 쿼리파라미터: {}", boardEvent);
		log.info("파일 업로드: {}", eventImage[0].getOriginalFilename());

		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)){
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
		} else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		boardEventfileService.fileUpload(eventImage, fileRealPath);

		boardEventService.addBoardEvent(boardEvent);

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
	public String viewBoardEvent(@RequestParam(value = "eventTitle", required = false)String eventTitle,
								 @RequestParam(value = "eventFileIdx", required = false) String eventFileIdx, Model model){
		//이벤트 조회

		List<BoardEvent> boardEventContents = boardEventService.viewBoardEvent(eventTitle);
		List<BoardEventFile> boardEventFile = boardEventfileService.getBoardEventFileInfoByIdx(eventFileIdx);
		model.addAttribute("boardEventFile", boardEventFile);

		model.addAttribute("title", "이벤트 내용");
		model.addAttribute("boardEventContents", boardEventContents);
		return "admin/board/boardContentsEvent";
	}
	
	@GetMapping("/modifyBoardEvent")
	public String modifyBoardEvent(@RequestParam(value = "eventTitle", required = false)String eventTitle, Model model) {

		List<BoardEvent> boardEventInfo = boardEventService.modifyBoardEvent(eventTitle);

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
