package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@GetMapping("/addCategory")
	public String addCategory(Model model) {
		
		return "admin/category/categoryAdd";
	}
	
	@GetMapping("/deleteCategory")
	public String deleteCategory() {
		
		return "admin/category/categoryDelete";
	}
	
	@GetMapping("/listCategory")
	public String listCategory() {
		
		return "admin/category/categoryList";
	}
	
	
	@GetMapping("/modifyCategory")
	public String modifyCategory() {
		
		return "admin/category/categoryModify";
	}

}

