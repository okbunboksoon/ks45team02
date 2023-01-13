package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.Delivery;
import ks45team02.ire.admin.service.DeliveryService;

@Controller
@RequestMapping("/admin")
public class DeliveryController {
	
	private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);

	private final DeliveryService deliveryService;
	
	public DeliveryController(DeliveryService deliveryService) {
		
		this.deliveryService = deliveryService;
	}
	
	@GetMapping("/listDelivery")
	public String listDelivery(Model model,
							  @RequestParam(value="msg", required=false) String msg) {
		
		List<Delivery> listDelivey =  deliveryService.getlistDelivery();
		model.addAttribute("title", "배송목록");
		model.addAttribute("pageTitle", "배송목록");
		model.addAttribute("listDelivey", listDelivey);		

		log.info("listDelivey :{}", listDelivey);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/delivery/deliveryList";
	}
	
	@GetMapping("/deleteDelivery")
	public String deleteDelivery() {
		
		return "admin/delivery/deliveryDelete";
	}
	
	
	@PostMapping("/addDelivery")
	public String addDelivery() {

		return "admin/delivery/deliveryAdd";
	}
	
	
	@GetMapping("/modifyDelivery")
	public String modifyDelivery() {
		
		return "admin/delivery/deliveryModify";
	}
	
	@GetMapping("/updateDelivery")
	public String updateDelivery() {
		
		return "admin/delivery/deliveryUpdate";
	}

}

