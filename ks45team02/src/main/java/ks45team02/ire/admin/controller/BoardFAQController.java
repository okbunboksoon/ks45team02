
package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BoardFAQController {

	@GetMapping("/addBoardFAQ")
	public String addBoardFAQ(Model model) {
		
		return "admin/board/boardAddFAQ";
	}
	
	@GetMapping("/deleteBoardFAQ")
	public String deleteBoardFAQ() {
		
		return "admin/board/boardDeleteFAQ";
	}
	
	@GetMapping("/listBoardFAQ")
	public String listBoardFAQ() {
		
		return "admin/board/boardListFAQ";
	}
	
	
	@GetMapping("/modifyBoardFAQ")
	public String modifyBoardFAQ() {
		
		return "admin/board/boardModifyFAQ";
	}

}

