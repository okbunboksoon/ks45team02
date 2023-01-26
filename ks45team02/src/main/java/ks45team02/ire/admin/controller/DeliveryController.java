package ks45team02.ire.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	/**
	 * 배송목록 조회
	 * @param model, msg
	 * @return listDelivey
	 */
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
	
	/**
	 * 배송 상태변경
	 * @param param, reAttr
	 * @return reResult
	 */
	@ResponseBody
	@RequestMapping(value="updateDelivery", method = {RequestMethod.POST})
	public HashMap<String, String> updateDelivery(@RequestParam Map<String, Object> param
			  					 ,RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		String deliveryCode = (String) param.get("deliveryCode");	
		log.info("deliveryCode : {}", deliveryCode);
		int result = 0;
		reResult.put("redirect", "/admin/listDelivery");	
		result = deliveryService.getDeliveryStateByCode(deliveryCode);
		log.info("result : {}", result);
		if(result == 1) {
			reResult.put("result", "성공");	
		}else {
			reResult.put("result", "실패");	
		}
		return reResult;
	}

}

