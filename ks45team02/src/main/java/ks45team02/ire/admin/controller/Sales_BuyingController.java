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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.dto.GoodsBuyingPayment;
import ks45team02.ire.admin.service.BusinessOrderService;
import ks45team02.ire.admin.service.GoodsBuyingPaymentService;
import ks45team02.ire.admin.service.Sales_BuyingService;

@Controller
@RequestMapping("/admin")
public class Sales_BuyingController {

	private static final Logger log = LoggerFactory.getLogger(Sales_BuyingController.class);

	private Sales_BuyingService sales_BuyingService;
	private BusinessOrderService businessOrderService;
	private final GoodsBuyingPaymentService goodsBuyingPaymentService;

	public Sales_BuyingController(Sales_BuyingService sales_BuyingService, BusinessOrderService businessOrderService
								 ,GoodsBuyingPaymentService goodsBuyingPaymentService) {
		
		this.sales_BuyingService = sales_BuyingService;
		this.businessOrderService = businessOrderService;
		this.goodsBuyingPaymentService = goodsBuyingPaymentService;
	}

	/**
	 * 상품 매입 조회
	 * 
	 * @param model
	 * @return GoodsBuyingList
	 */
	@GetMapping("/listGoodsBuying")
	public String listGoodsBuying(Model model, @RequestParam(value = "gb", required = false) String gb) {

		List<GoodsBuying> goodsBuyingList = sales_BuyingService.getListGoodsBuying();
		model.addAttribute("title", "상품 매입 목록");
		model.addAttribute("pageTitle", "상품 매입 목록");
		model.addAttribute("goodsBuyingList", goodsBuyingList);

		log.info("goodsBuyingList: {}", goodsBuyingList);

		return "admin/sales_buying/GoodsBuyingList";
	}
	
	/**
	 * 상품 매입 결제 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/listGoodsBuyingPaymentList")
	public String listGoodsBuyingPayment(Model model) {
		
		List<GoodsBuyingPayment> goodsbuyingList = goodsBuyingPaymentService.getGoodsBuyingPaymentList();
		log.info("goodsbuyingList: {}", goodsbuyingList);
		model.addAttribute("title", "상품 매입 결제");
		model.addAttribute("pageTitle", "상품 매입 결제");
		model.addAttribute("goodsbuyingList", goodsbuyingList);
		
		return "admin/sales_buying/GoodsBuyingPaymentList";
	}
	
	/**
	 * 상품매입결제 업데이트
	 * @return
	 */
	@GetMapping("/modifyGoodsBuyingPayment")
	public String modifyGoodsBuyingPayment(@RequestParam(value = "goods_buy_payment_code")String goods_buy_payment_code,Model model) {
		log.info("goods_buy_payment_code: {}", goods_buy_payment_code);
		
		GoodsBuyingPayment GoodsBuyingPayment = sales_BuyingService.getGoodsBuyingPaymentByCode(goods_buy_payment_code);
		log.info("GoodsBuyingPayment: {}", GoodsBuyingPayment);
		
		model.addAttribute("title", "상품 매입 결제");
		model.addAttribute("pageTitle", "상품 매입 결제");
		model.addAttribute("GoodsBuyingPayment", GoodsBuyingPayment);
		
		return"admin/sales_buying/GoodsBuyingPaymentModify";
	}
	
	@PostMapping("/modifyGoodsBuyingPayment")
	public String modifyGoodsBuyingPayment(GoodsBuyingPayment GoodsBuyingPayment) {
		log.info("GoodsBuyingPayment: {}", GoodsBuyingPayment);
		sales_BuyingService.modifyGoodsBuyingPayment(GoodsBuyingPayment);
		return "redirect:/admin/listGoodsBuyingPaymentList";
	}
	/**
	 * 결제금액 계산
	 * @param paymentValue, goodsBuyPaymentCodeValue
	 * @return result
	 */
	@GetMapping("/modifyPaymentCheck")
	@ResponseBody
	public int modifyPayment(@RequestParam(value = "paymentValue")int paymentValue,
							 @RequestParam(value = "goodsBuyPaymentCodeValue")String goodsBuyPaymentCodeValue) {

		int result = sales_BuyingService.getPayment(paymentValue, goodsBuyPaymentCodeValue);
		log.info("result: {}", result);	
		
		return result;
	}
	
	@GetMapping("/listGoodsSales")
	public String listGoodsSales() {

		return "admin/sales_buying/GoodsSalesList";
	}

	@GetMapping("/goodsSalesBuyingGroup")
	public String goodsSalesBuyingGroup() {

		return "admin/sales_buying/GoodsSalesBuyingGroup";
	}

	@GetMapping("/goodsSalesTotalSearch")
	public String goodsSalesTotalSearch() {

		return "admin/sales_buying/GoodsSalesTotalSearch";
	}

}
