package ks45team02.ire.user.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.BoardInquiry;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.mapper.BoardInquiryMapper;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.admin.service.BoardInquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserBoardInquiryController {
	private final UserMapper userMapper;
	private final BoardInquiryMapper boardInquiryMapper;
	private final BoardInquiryService boardInquiryService;

	public UserBoardInquiryController(UserMapper userMapper, BoardInquiryMapper boardInquiryMapper, BoardInquiryService boardInquiryService) {
		this.userMapper = userMapper;
		this.boardInquiryMapper = boardInquiryMapper;
		this.boardInquiryService = boardInquiryService;
	}

	//1:1문의 등록
	@GetMapping("/addBoardInquiry")
	public String addBoardInquiry(Model model,HttpSession httpSession) {
		model.addAttribute("pageTitle","1:1문의 등록");
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");
		model.addAttribute("loginInfo",loginInfo);
		return "user/board/boardAddInquiry";
	}
	@PostMapping("/addBoardInquiry")
	public String addBoardInquiry(BoardInquiry boardInquiry){
		boardInquiryService.addInquiry(boardInquiry);
		return "redirect:/listBoardInquiry";
	}

	//1:1문의 삭제
	@GetMapping("/deleteBoardInquiry")
	public String deleteBoardInquiry() {
		
		return "user/board/boardDeleteInquiry";
	}
	//1:1문의 조회
	@GetMapping("/listBoardInquiry")
	public String listBoardInquiry(Model model,
								   HttpSession session, HttpServletResponse response) {
		model.addAttribute("pageTitle","1:1문의 조회");
		LoginInfo loginInfo= (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		System.out.println(loginInfo+"<-----------------");
		String redirectURI="user/board/boardListInquiry";
		if( loginInfo == null){
			try {
				response.setContentType("text/html;charset=utf-8;");
				PrintWriter writer = response.getWriter();
				writer.write("<script>alert('로그인하고 이용하세요'); location.href='/';</script>");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}else{
			List<BoardInquiry> boardInquiryList=  boardInquiryMapper.userInquiryList(loginInfo.getLoginId());
			model.addAttribute("boardInquiryList",boardInquiryList);
		}
		return redirectURI;
	}

	//1:1문의 답변조회
	@GetMapping("/listAnswerBoardInquiry")
	public String listAnswerBoardInquiry(Model model) {
		model.addAttribute("pageTitle","1:1문의 답변조회");
		List<BoardInquiry>boardInquiryList=boardInquiryMapper.answerAdminList();
		model.addAttribute("boardInquiryList",boardInquiryList);
		return "user/board/boardListInquiryAnswer";
	}

	//1:1문의 수정
	@GetMapping("/modifyBoardInquiry")
	public String modifyBoardInquiry() {
		
		return "user/board/boardModifyInquiry";
	}
	//1:1 상세 페이지
	@GetMapping("/ContentsInquiry")
	public String ContentsInquiry(Model model,
								  @RequestParam(value = "inquiryCode",required = false)String InquiryCode){
		List<BoardInquiry>contentsInquiry=boardInquiryMapper.contentsInquiry(InquiryCode);
		model.addAttribute("pageTitle","1:1문의 상세페이지");
		model.addAttribute("contentsInquiry",contentsInquiry);
		return "user/board/boardContentsInquiry";
	}

}

