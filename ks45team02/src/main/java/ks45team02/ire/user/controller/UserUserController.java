package ks45team02.ire.user.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.controller.UserController;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserUserController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserUserController(UserService userService) {
		this.userService = userService;
	}

	//로그아웃처리
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response, @CookieValue(value = "loginKeepId", required = false) Cookie cookie){
		session.invalidate();
		if(cookie != null) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		userService.logoutHistory(session.getId());
		return "redirect:/";
	}
	//마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
		return "user/user/myPage";
	}

	//회원등록
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("pageTitle","회원 등록");
		return "user/user/userAdd";
	}
	//회원등록처리
	@PostMapping("/addUser")
	public String addUser(User user){
		log.info("회원가입 :{}",user);
		userService.addUser(user);

		return "redirect:/";
	}
	//회원 삭제
	@GetMapping("/deleteUser")
	public String deleteUser(Model model,HttpSession httpSession) {
		model.addAttribute("pageTitle","회원탈퇴");
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");
		model.addAttribute("loginInfo",loginInfo);
		return "user/user/userDelete";
	}
	//회원 삭제후 세션 삭제처리
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam(value = "userId")String userId,
							 @RequestParam(value = "userPw")String userPw,
							 RedirectAttributes reAttr,
							 HttpSession httpSession){
		log.info("userId:{},userPw:{}",userId,userPw);
		Map<String,Object>checkResult=userService.checkPwByMemberId(userId,userPw);
		boolean isChecked= (boolean) checkResult.get("result");
		String redirectURI="redirect:/";
		if(!isChecked){
			redirectURI= "redirect:/deleteUser/"+userId;
			reAttr.addAttribute("msg","입력하신 회원의 정보가 일치하지 않습니다.");
		}else {
			User user=(User) checkResult.get("userInfo");
			userService.deleteUser(user);
			httpSession.invalidate();
		}
		return  redirectURI;
	}



	@GetMapping("/deliveryUser")
	public String deliveryUser() {
		//배송 어떻게 하는지 알려주시면 할게여 ㅎㅎ
		return "user/user/userDelivery";
	}

	@GetMapping("/findIdUser")
	public String findIdUser() {
		//할지 말지 고민중...
		return "user/user/userFindId";
	}

	@GetMapping("/findPwUser")
	public String findPwUser() {
		//할지 말지 고민중...
		return "user/user/userFindPw";
	}
	//회원로그인
	@GetMapping("/loginUser")
	public String loginUser(Model model,
							@RequestParam(value = "msg",required = false)String msg,
							HttpSession httpSession) {
		//로그인 세션으로 구분 하기
		model.addAttribute("pageTitle","Sign In");
		if (msg!=null)model.addAttribute("msg",msg);
		String redirectURI="user/user/userLogin";
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");

		if(loginInfo!=null){
			redirectURI="redirect:/myPage";
		}
		return redirectURI;
	}
	//회원로그인 처리
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam(name = "userId",required = false)String userId,
							@RequestParam(name = "userPw",required = false)String userPw,
							RedirectAttributes reAttr,
							HttpSession session,
							HttpServletRequest request,
							HttpServletResponse response){
		log.info("userId:{},userPw:{}",userId,userPw);
		Map<String,Object> checkResult=userService.checkPwByMemberId(userId,userPw);
		boolean isChecked= (boolean) checkResult.get("result");

		String redirectURI="redirect:/";
		if(!isChecked){
			redirectURI= "redirect:/loginUser";
			reAttr.addAttribute("msg","입력하신 회원의 정보가 일치하지 않습니다.");
		}else {
			User user=(User) checkResult.get("userInfo");
			if(user.getUserDropState().equals("Y")){
				try {
					response.setContentType("text/html;charset=utf-8;");
					PrintWriter writer = response.getWriter();
					writer.write("<script>alert('탈퇴한 회원입니다');" +
							"location.href='/loginUser';</script>");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}else {
				LoginInfo loginInfo=new LoginInfo(userId,user.getUserName());
				System.out.println(loginInfo);
				session.setAttribute("S_MEMBER_INFO",loginInfo);
				userService.updateLoginHistory(userId);
				Cookie cookie=new Cookie("loginKeepId",userId);
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
				if(loginInfo.getLoginName().equals("관리자")){
					redirectURI="redirect:/admin";
				}
			}
		}
		return redirectURI;
	}
	@GetMapping("/modifyUser")
	public String modifyUser(Model model,
							 HttpSession httpSession) {
		//회원 수정처리
		model.addAttribute("pageTitle","회원정보 수정");
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");
		User userInfo=userService.getUserInfoById(loginInfo.getLoginId());
		model.addAttribute("userInfo",userInfo);
		return "user/user/userModify";
	}
	@PostMapping("/modifyUser")
	public String modifyUser(User user){
		//회원 수정처리
		userService.modifyUser(user);
		return "redirect:/myPage";
	}
	@GetMapping("/usePointSaveUser")
	public String usePointSaveUser() {
		//이건 내가 해야하는건가요>???
		return "user/user/userPointSave";
	}


}

