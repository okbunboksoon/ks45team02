package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserUserController {

	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		return "/user/user/userAdd";
	}
	
	@GetMapping("/basketUser")
	public String basketUser() {
		
		return "/user/user/userBasket";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser() {
		
		return "/user/user/userDelete";
	}
	
	
	@GetMapping("/deliveryUser")
	public String deliveryUser() {
		
		return "/user/user/userDelivery";
	}
	
	@GetMapping("/findIdUser")
	public String findIdUser() {
		
		return "/user/user/userFindId";
	}
	
	@GetMapping("/findPwUser")
	public String findPwUser() {
		
		return "/user/user/userFindPw";
	}
	
	@GetMapping("/listUser")
	public String listUser() {
		
		return "/user/user/userList";
	}
	
	@GetMapping("/loginUser")
	public String loginUser() {
		
		return "/user/user/userLogin";
	}
	@GetMapping("/modifyUser")
	public String modifyUser() {
		
		return "/user/user/userModify";
	}
	@GetMapping("/usePointSaveUser")
	public String usePointSaveUser() {
		
		return "/user/user/userPointSave";
	}


}

