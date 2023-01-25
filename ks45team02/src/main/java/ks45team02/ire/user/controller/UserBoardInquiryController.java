package ks45team02.ire.user.controller;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.BoardInquiry;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.mapper.BoardInquiryMapper;
import ks45team02.ire.admin.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserBoardInquiryController {
	private final UserMapper userMapper;
	private final BoardInquiryMapper boardInquiryMapper;

	public UserBoardInquiryController(UserMapper userMapper, BoardInquiryMapper boardInquiryMapper) {
		this.userMapper = userMapper;
		this.boardInquiryMapper = boardInquiryMapper;
	}

	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model) {
		
		return "user/board/boardAddInquiry";
	}
	
	@GetMapping("/deleteBoardInquiry")
	public String deleteBoardInquiry() {
		
		return "user/board/boardDeleteInquiry";
	}
	
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry(Model model, HttpSession session) {
		model.addAttribute("pageTitle","1:1문의 조회");
		LoginInfo loginInfo= (LoginInfo) session.getAttribute("S_MEMBER_INFO");

		List<BoardInquiry> boardInquiryList=  boardInquiryMapper.userInquiryList(loginInfo.getLoginId());
		model.addAttribute("boardInquiryList",boardInquiryList);
		return "user/board/boardListInquiry";
	}

	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry() {
		
		return "user/board/boardListInquiryAnswer";
	}

	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry() {
		
		return "user/board/boardModifyInquiry";
	}
	@GetMapping("/ContentsInquiry")
	public String ContentsInquiry(Model model,
								  @RequestParam(value = "inquiryCode",required = false)String InquiryCode){
		List<BoardInquiry>contentsInquiry=boardInquiryMapper.contentsInquiry(InquiryCode);
		model.addAttribute("pageTitle","1:1문의 상세페이지");
		model.addAttribute("contentsInquiry",contentsInquiry);
		return "user/board/boardContentsInquiry";
	}

}

