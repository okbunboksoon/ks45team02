package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.Contract;
import ks45team02.ire.admin.service.BusinessService;
import ks45team02.ire.admin.service.ContractService;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ContractController {
	private static final Logger log= LoggerFactory.getLogger(UserService.class);
	private final ContractService contractService;
	private final BusinessService businessService;
	private final UserService userService;

	public ContractController(ContractService contractService, BusinessService businessService, UserService userService) {
		this.contractService = contractService;
		this.businessService = businessService;
		this.userService = userService;
	}

	@GetMapping("/addContract")
	public String addContract(Model model) {
		model.addAttribute("title","addContract");
		model.addAttribute("pageTitle","계약추가");
		List<Business>listBusiness=businessService.businessList();
		model.addAttribute("listBusiness",listBusiness);
		return "admin/contract/contractAdd";
	}
	@PostMapping("/addContract")
	public String addContract(Contract contract){
		contractService.addContract(contract);
		return "redirect:/admin/listContract";
	}
	
	@GetMapping("/deleteContract")
	public String deleteContract() {
		
		return "admin/contract/contractDelete";
	}
	
	@GetMapping("/listContract")
	public String listContract(Model model) {
		// 계약조회
		model.addAttribute("title","contractList");
		model.addAttribute("pageTitle","계약조회");
		List<Contract>contractList=contractService.listContract();
		model.addAttribute("contractList",contractList);
		return "admin/contract/contractList";
	}
	
	
	@GetMapping("/modifyContract")
	public String modifyContract(Model model,
								 @RequestParam(value = "contractCode",required = false)String contractCode) {
		model.addAttribute("title","modifyContract");
		model.addAttribute("pageTitle","계약수정");
		Contract contractInfo=contractService.getInfoByContract(contractCode);
		model.addAttribute("contractInfo",contractInfo);
		return "admin/contract/contractModify";
	}
	@PostMapping("/modifyContract")
	public String modifyContract(Contract contract){
		contractService.modifyContract(contract);
		return "redirect:/admin/listContract";
	}

}

