package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.Vat;
import ks45team02.ire.admin.service.VatService;

@Controller
@RequestMapping("/admin")
public class VatController {
	
	
	private static final Logger log = LoggerFactory.getLogger(VatController.class);

	private VatService vatService;
	
	public VatController(VatService vatService) {
		this.vatService = vatService;
	}

	@GetMapping("/listVat")
	public String listVat(Model model) {
		
		List<Vat> vatList = vatService.getListVat();
		
		model.addAttribute("vatList", vatList);
		
		log.info("vatList:{} ", vatList);
		return "admin/vat/vatList";
	}


}

