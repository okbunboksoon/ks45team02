package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	//	회원 가입1 -김재범
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("title","회원가입");
		return "admin/user/userAdd";
	}
	//	회원가입2 -김재범
	@PostMapping("/addUser")
	public String addUser(User user){
		log.info("회원가입 :{}",user);
		userService.addUser(user);

		return "redirect:/admin";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser() {
		
		return "admin/user/userDelete";
	}
	
	
	@GetMapping("/deliveryUser")
	public String deliveryUser() {
		
		return "admin/user/userDelivery";
	}
	
	@GetMapping("/findIdUser")
	public String findIdUser() {
		
		return "admin/user/userFindId";
	}
	
	@GetMapping("/findPwUser")
	public String findPwUser() {
		
		return "admin/user/userFindPw";
	}
	
	@GetMapping("/listUser")
	public String listUser() {
		
		return "admin/user/userList";
	}
	@GetMapping("/listDormantUser")
	public String listDormant() {
		
		return "admin/user/userListDormant";
	}
	@GetMapping("/listDropUser")
	public String listDrop() {
		
		return "admin/user/userListDrop";
	}
	@GetMapping("/loginUser")
	public String loginUser() {
		
		return "admin/user/userLogin";
	}
	@GetMapping("/modifyUser")
	public String modifyUser() {
		
		return "admin/user/userModify";
	}
	@GetMapping("/usePointSaveUser")
	public String usePointSaveUser() {
		
		return "admin/user/userPointSave";
	}


}

