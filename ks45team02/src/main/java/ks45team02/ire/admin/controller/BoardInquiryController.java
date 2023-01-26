package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.BoardInquiry;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BoardInquiryMapper;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.admin.service.BoardInquiryService;
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
public class BoardInquiryController {
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeController.class);
	private final BoardInquiryService boardInquiryService;
	private final BoardInquiryMapper boardInquiryMapper;
	private final UserMapper userMapper;

	public BoardInquiryController(BoardInquiryService boardInquiryService, BoardInquiryMapper boardInquiryMapper, UserMapper userMapper) {
		this.boardInquiryService = boardInquiryService;
		this.boardInquiryMapper = boardInquiryMapper;
		this.userMapper = userMapper;
	}

	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model) {
		// 1:1문의 등록
		model.addAttribute("pageTitle","1:1문의 등록");
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		return "admin/board/boardAddInquiry";
	}
	@PostMapping("/addBoardInquiry")
	//1:1문의 등록처리
	public String addBoardInquiry(BoardInquiry boardInquiry){
		boardInquiryService.addInquiry(boardInquiry);
		return "redirect:/admin/listBoardInquiry";
	}
	
	@GetMapping("/answerBoardInquiry")
	public String answerBoardInquiry(Model model,
									 @RequestParam(value = "inquiryCode",required = false)String inquiryCode) {
		//1:1문의 답변
		model.addAttribute("pageTitle","1:1문의 답변");
		List<User> userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		BoardInquiry getInquiryRe= boardInquiryMapper.getInquiryInfo(inquiryCode);
		model.addAttribute("getInquiryRe",getInquiryRe);
		return "admin/board/boardInquiryAnswer";
	}
	@PostMapping("/answerBoardInquiry")
	public String answerBoardInquiry(BoardInquiry boardInquiry){
		//1:1문의 답변 처리
		boardInquiryService.answer(boardInquiry);
		return "redirect:/admin/listBoardInquiry";
	}
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry(Model model) {
		//1:1문의 조회
		List<BoardInquiry>boardInquiryList= boardInquiryService.boardInquiryList();
		model.addAttribute("pageTitle","1:1문의 조회");
		model.addAttribute("boardInquiryList",boardInquiryList);
		return "admin/board/boardListInquiry";
	}
	@GetMapping("/ContentsInquiry")
	public String ContentsNotice(@RequestParam(value = "inquiryCode") String inquiryCode
								, Model model) {
		//1:1문의 상세
		List<BoardInquiry> contentsInquiry =boardInquiryService.ContentInquiry(inquiryCode);
		model.addAttribute("title", "1:1문의 상세페이지");
		model.addAttribute("pageTitle", "상세페이지");
		model.addAttribute("contentsInquiry",contentsInquiry);
		return "admin/board/boardContentsInquiry";
	}

	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry(Model model) {
		//1:1문의 답변 조회
		List<BoardInquiry>answerList=boardInquiryMapper.answerAdminList();
		model.addAttribute("pageTitle","1:1문의 답변 페이지");
		model.addAttribute("answerList",answerList);
		return "admin/board/boardListInquiryAnswer";
	}

	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry(Model model,
									 @RequestParam(value = "inquiryCode",required = false)String InquiryCode) {
		//1:1문의 수정
		model.addAttribute("title","modifyBoardInquiry");
		model.addAttribute("pageTitle","1:1문의 수정");
		BoardInquiry InquiryInfo= boardInquiryMapper.getInquiryInfo(InquiryCode);
		model.addAttribute("InquiryInfo",InquiryInfo);
		return "admin/board/boardModifyInquiry";
	}
	@PostMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry(BoardInquiry boardInquiry){
		//1:1문의 수정처리
		boardInquiryService.modifyInquiry(boardInquiry);
		return "redirect:/admin/listBoardInquiry";
	}

}

