
package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserBoardFAQController {


	@GetMapping("/listBoardFAQ")
	public String listBoardFAQ() {
		
		return "user/board/boardListFAQ";
	}
	


}

