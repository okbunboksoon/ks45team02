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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/")
public class UserUserController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserUserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/myPage")
	public String myPage(Model model) {
		
		return "user/user/myPage";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("pageTitle","회원 등록");
		return "user/user/userAdd";
	}
	@PostMapping("/addUser")
	public String addUser(User user){
		log.info("회원가입 :{}",user);
		userService.addUser(user);

		return "redirect:/";
	}
	@GetMapping("/deleteUser")
	public String deleteUser() {
		
		return "user/user/userDelete";
	}
	
	
	@GetMapping("/deliveryUser")
	public String deliveryUser() {
		
		return "user/user/userDelivery";
	}
	
	@GetMapping("/findIdUser")
	public String findIdUser() {
		
		return "user/user/userFindId";
	}
	
	@GetMapping("/findPwUser")
	public String findPwUser() {
		
		return "user/user/userFindPw";
	}

	
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
			LoginInfo loginInfo=new LoginInfo(userId,user.getUserName());
			session.setAttribute("S_MEMBER_INFO",loginInfo);
			userService.updateLoginHistory(userId);
			Cookie cookie=new Cookie("loginKeepId",userId);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		}
		return redirectURI;
	}
	@GetMapping("/modifyUser")
	public String modifyUser(Model model,
							 HttpSession httpSession) {
		model.addAttribute("pageTitle","회원정보 수정");
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");
		User userInfo=userService.getUserInfoById(loginInfo.getLoginId());
		model.addAttribute("userInfo",userInfo);
		log.info("userInfo:{}",userInfo);
		return "user/user/userModify";
	}
	@PostMapping("/modifyUser")
	public String modifyUser(User user){
		userService.modifyUser(user);
		return "redirect:/myPage";
	}
	@GetMapping("/usePointSaveUser")
	public String usePointSaveUser() {
		
		return "user/user/userPointSave";
	}


}

