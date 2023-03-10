package ks45team02.ire.admin.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.dto.UserDor;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	//	회원 가입
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("pageTitle","회원가입");
		return "admin/user/userAdd";
	}
	//	회원가입
	@PostMapping("/addUser")
	public String addUser(User user){
		log.info("회원가입 :{}",user);
		userService.addUser(user);

		return "redirect:/admin/listUser";
	}
	// 회원 중복 아이디 체크
	@GetMapping("/idCheck/{userId}")
	@ResponseBody
	public int idCheck(@PathVariable(value = "userId")String userId){

		return userService.idCheck(userId);
	}

	// 회원탈퇴
	@GetMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable (value = "userId")String userId,
							 @RequestParam(value = "msg",required = false)String msg,
							 Model model) {
		if(msg!=null)model.addAttribute("msg",msg);
		model.addAttribute("userId",userId);
		model.addAttribute("title","deleteUser");
		model.addAttribute("pageTitle","회원 탈퇴");


		return "admin/user/userDelete";
	}
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam(value = "userId")String userId,
							 @RequestParam(value = "userPw")String userPw,
							 RedirectAttributes reAttr){
		log.info("userId:{},userPw:{}",userId,userPw);
		Map<String,Object>checkResult=userService.checkPwByMemberId(userId,userPw);
		boolean isChecked= (boolean) checkResult.get("result");
		String redirectURI="redirect:/admin/listUser";
		if(!isChecked){
			redirectURI= "redirect:/admin/deleteUser/"+userId;
			reAttr.addAttribute("msg","입력하신 회원의 정보가 일치하지 않습니다.");
		}else {
			User user=(User) checkResult.get("userInfo");

			userService.deleteUser(user);
		}
		return  redirectURI;
	}

	
	@GetMapping("/findIdUser")
	public String findIdUser() {
		//미구현
		return "admin/user/userFindId";
	}
	
	@GetMapping("/findPwUser")
	public String findPwUser() {
		//미구현
		return "admin/user/userFindPw";
	}

	//회원 조회
	@GetMapping("/listUser")
	public String listUser(Model model) {
		List<User>listUser=userService.listUser();
		model.addAttribute("pageTitle","회원 조회");
		model.addAttribute("listUser",listUser);

		return "admin/user/userList";
	}

	// 휴면회원 조회
	@GetMapping("/listDormantUser")
	public String listDormant(Model model) {
		model.addAttribute("title","휴면회원 조회");
		model.addAttribute("pageTitle","휴면회원 조회");
		List<UserDor>userDorList=userService.userDorList();
		model.addAttribute("userDorList",userDorList);
		
		return "admin/user/userListDormant";
	}
	//탈퇴 회원 조회
	@GetMapping("/listDropUser")
	public String listDrop(Model model) {
		model.addAttribute("title","DropUser");
		model.addAttribute("pageTitle","탈퇴회원 조회");
		List<User>userDropList=userService.userDropList();
		model.addAttribute("userDropList",userDropList);
		return "admin/user/userListDrop";
	}
	// 로그인...
	@PostMapping("/loginUser")
	public String login(@RequestParam(name = "userId",required = false)String userId,
						@RequestParam(name = "userPw",required = false)String userPw,
						RedirectAttributes reAttr,
						HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response){
		log.info("userId:{},userPw:{}",userId,userPw);
		Map<String,Object>checkResult=userService.checkPwByMemberId(userId,userPw);
		boolean isChecked= (boolean) checkResult.get("result");

		String redirectURI="redirect:/admin";
		if(!isChecked){
			redirectURI= "redirect:/admin/loginUser";
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
		//로그인...
	@GetMapping("/loginUser")
	public String loginUser(Model model,
							@RequestParam(value = "msg",required = false)String msg){

		model.addAttribute("pageTitle","로그인");
		if(msg!=null) model.addAttribute("msg",msg);
		return "admin/user/userLogin";
	}
	@GetMapping("/loginHistory")
	public String getLoginHistory(Model model){
		List<User> loginHistory=userService.getLoginHistory();
		log.info("로그인 이력:{}",loginHistory);
		model.addAttribute("pageTitle","로그인 이력");
		model.addAttribute("loginHistory",loginHistory);

		return "admin/user/userLoginHistory";
	}
	// 회원 수정화면
	@GetMapping("/modifyUser")
	public String modifyUser(@RequestParam(value = "userId",required = false)String userId
							,Model model) {
		User userInfo= userService.getUserInfoById(userId);
		log.info("유저 인포:{}",userInfo);
		model.addAttribute("pageTitle","회원 수정");
		model.addAttribute("userInfo",userInfo);
		return "admin/user/userModify";
	}
	//회원 수정처리
	@PostMapping("/modifyUser")
	public String modifyUser(User user){
		log.info("회원 수정:{}",user);
		userService.modifyUser(user);
		return "redirect:/admin/listUser";
	}

	@GetMapping("/usePointSaveUser")
	public String usePointSaveUser() {
		
		return "admin/user/userPointSave";
	}


}

