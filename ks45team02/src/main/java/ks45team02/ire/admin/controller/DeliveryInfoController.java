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
	 * 배송정보 등록 화면
	 * @param model
	 */
	@GetMapping("/addDeliveryInfo")
	public String addDeliveryInfo(Model model) {
		
		model.addAttribute("title", "배송정보 등록");
		model.addAttribute("pageTitle", "배송정보 등록");
		
		return "admin/deliveryInfo/deliveryInfoAdd";
	}
	
	/**
	 * 배송정보 등록
	 * @param deliveryInfo
	 * @param reAttr
	 * @return
	 */
	@PostMapping("/addDeliveryInfo")
	public String addDeliveryInfo(DeliveryInfo deliveryInfo
								 ,RedirectAttributes reAttr) {
		
		log.info("deliveryInfo :{}", deliveryInfo);
		
		int result = deliveryInfoService.addDeliveryInfo(deliveryInfo);
			
		return "redirect:/admin/listDeliveryInfo";
	}
	
	/**
	 * 배송정보 수정 화면
	 * @return
	 */
	@GetMapping("/modifyDeliveryInfo")
	public String modifyDeliveryInfo(@RequestParam(value = "delInfoCode")String delInfoCode
									,@RequestParam(value="msg", required = false) String msg, Model model) {
		log.info("delInfoCode :{}", delInfoCode);
		List<DeliveryInfo> deliveryInfo = deliveryInfoService.getDeliveryInfoByCode(delInfoCode);
		log.info("deliveryInfo :{}", deliveryInfo);
		model.addAttribute("title", "배송정보 수정");
		model.addAttribute("pageTitle", "배송정보 수정");
		model.addAttribute("deliveryInfo", deliveryInfo);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/deliveryInfo/deliveryInfoModify";
	}

	@PostMapping("/modifyDeliveryInfo")
	public String modifyDeliveryInfo(DeliveryInfo deliveryInfo
									,RedirectAttributes reAttr) {
		
		log.info("deliveryInfo :{}", deliveryInfo);
		int result = deliveryInfoService.modifyDeliveryInfo(deliveryInfo);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "배송정보 수정에 실패하였습니다.");
			return "redirect:/admin/addBusinessOrder";
		}else {
			reAttr.addAttribute("msg", "배송정보 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listDeliveryInfo";
	}
}

