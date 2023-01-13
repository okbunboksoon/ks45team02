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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.DeliveryInfo;
import ks45team02.ire.admin.service.DeliveryInfoService;

@Controller
@RequestMapping("/admin")
public class DeliveryInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(DeliveryInfoController.class);

	private final DeliveryInfoService deliveryInfoService;
	
	public DeliveryInfoController(DeliveryInfoService deliveryInfoService) {
		
		this.deliveryInfoService = deliveryInfoService;
	}
	
	/**
	 * 배송정보 전체 조회
	 * @param model, msg
	 * @return listDeliveryInfo
	 */
	@GetMapping("/listDeliveryInfo")
	public String listDeliveryInfo(Model model,
							  @RequestParam(value="msg", required=false) String msg) {
		
		List<DeliveryInfo> listDeliveryInfo = deliveryInfoService.getListDeliveryInfo();
		model.addAttribute("title", "배송정보 목록");
		model.addAttribute("pageTitle", "배송정보 목록");
		model.addAttribute("listDeliveryInfo", listDeliveryInfo);
		log.info("listDeliveryInfo : {} ", listDeliveryInfo);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/deliveryInfo/deliveryInfoList";
	}
	
	/**
	 * 배송 정보 등록 화면
	 * @param model
	 */
	@GetMapping("/addDeliveryInfo")
	public String addDeliveryInfo(Model model) {
		
		model.addAttribute("title", "배송정보 등록");
		model.addAttribute("pageTitle", "배송정보 등록");
		
		return "admin/deliveryInfo/deliveryInfoAdd";
	}
	
	@PostMapping("/addDeliveryInfo")
	public String addDeliveryInfo(DeliveryInfo deliveryInfo
								 ,RedirectAttributes reAttr) {
		
		log.info("deliveryInfo :{}", deliveryInfo);
		
		int result = deliveryInfoService.addDeliveryInfo(deliveryInfo);
		
		log.info("등록 후 컨트롤러 반환 :{}", result);
		
		
		return "redirect:/admin/listDeliveryInfo";
	}
	@GetMapping("/modifyDeliveryInfo")
	public String modifyDeliveryInfo() {
		
		return "admin/deliveryInfo/deliveryInfoModify";
	}

}

