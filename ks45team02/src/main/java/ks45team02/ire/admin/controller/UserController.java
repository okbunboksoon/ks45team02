package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserController {

	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		return "admin/user/userAdd";
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

