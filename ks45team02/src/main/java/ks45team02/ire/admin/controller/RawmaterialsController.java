package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.dto.RawMaterialsOutgoing;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import ks45team02.ire.admin.service.RawMaterialsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RawmaterialsController {

	private static final Logger log =
			LoggerFactory.getLogger(RawmaterialsController.class);

	private final RawMaterialsMapper rawmaterialsMapper;
	private final RawMaterialsService rawmaterialsService;

	public RawmaterialsController(RawMaterialsService rawmaterialsService, RawMaterialsMapper rawmaterialsMapper) {
		this.rawmaterialsMapper = rawmaterialsMapper;
		this.rawmaterialsService = rawmaterialsService;

	}

	//원자재 입고 등록 처리
	@PostMapping("/addIncomingRawmaterials")
	public String addIncomingRawmaterials(RawMaterialsIncoming rawMaterialsIncoming, RedirectAttributes reAttr) {

		int result = rawmaterialsService.addIncomingRawmaterials(rawMaterialsIncoming);

		if (result == 0) {
			reAttr.addAttribute("msg", "등록에 실패하였습니다.");
			return "redirect:/admin/addIncomingRawmaterials";
		} else {
			reAttr.addAttribute("msg", result + "개의 데이터가 등록되었습니다.");
		}

		return "redirect:/admin/listIncomingRawmaterials";
	}

	//원자재 입고 등록 페이지
	@GetMapping("/addIncomingRawmaterials")
	public String addIncomingRawMatrials(Model model
			, @RequestParam(value = "msg", required = false) String msg) {

		List<String> donationCodeNotIncoming = rawmaterialsMapper.getDonationCodeNotIncoming();

		model.addAttribute("title", "원자재 입고 등록");
		model.addAttribute("pageTitle", "원자재 입고 등록");
		model.addAttribute("donationCodeNotIncoming", donationCodeNotIncoming);
		if (msg != null) {
			model.addAttribute("msg", msg);
		}


		return "admin/rawmaterials/rawmaterialsAddIncoming";
	}

	@GetMapping("/addoutgoingRawmaterials")
	public String addoutgoingRawMatrials(Model model, @RequestParam(value = "msg", required = false) String msg) {

		List<RawMaterialsOutgoing> addoutgoingRawmaterialsInfo = rawmaterialsMapper.addoutgoingRawmaterialsInfo();


		model.addAttribute("title", "원자재 출고 등록");
		model.addAttribute("pageTitle", "원자재 출고 등록");
		model.addAttribute("addoutgoingRawmaterialsInfo", addoutgoingRawmaterialsInfo);

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/rawmaterials/rawmaterialsAddOutgoing";
	}
	@PostMapping("/addoutgoingRawmaterials")
	public String addoutgoingRawmaterials(RawMaterialsOutgoing rawMaterialsOutgoing){
		int result = rawmaterialsService.addoutgoingRawmaterials(rawMaterialsOutgoing);
		return "redirect:/admin/listOutgoingRawmaterials";
	}

	//원자재 입고 삭제 처리
	@PostMapping("/deleteIncomingRawmaterials")
	public String deleteIncomingRawMatrials(@RequestParam(value = "rawMaterialsCode") String rawMaterialsCode
			, RedirectAttributes reAttr) {

		int result = rawmaterialsService.deleteIncomingRawMatrials(rawMaterialsCode);
		if (result == 0) {
			reAttr.addAttribute("rawMaterialsCode", rawMaterialsCode);
			reAttr.addAttribute("msg", "원자재 입고 삭제에 실패하였습니다.");
			return "redirect:/admin/deleteIncomingRawmaterials";
		} else {
			reAttr.addAttribute("msg", result + "개의 데이터가 삭제되었습니다.");
		}
		return "redirect:/admin/listIncomingRawmaterials";
	}


	//원자재 입고 삭제 페이지
	@GetMapping("/deleteIncomingRawmaterials")
	public String deleteIncomingRawMatrials(Model model
			, @RequestParam(value = "rawMaterialsCode") String rawMaterialsCode
			, @RequestParam(value = "msg", required = false) String msg) {

		RawMaterialsIncoming rawMaterialsIncomingInfo = rawmaterialsMapper.getRawMaterialsIncomingInfo(rawMaterialsCode);

		model.addAttribute("title", "원자재 입고 삭제");
		model.addAttribute("pageTitle", "원자재 입고 삭제");
		model.addAttribute("rawMaterialsIncomingInfo", rawMaterialsIncomingInfo);
		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/rawmaterials/rawmaterialsDeleteIncoming";
	}

	@GetMapping("/deleteoutgoingRawmaterials")
	//원자재 출고 삭제 화면
	public String deleteoutgoingRawMatrials(Model model, @RequestParam(value = "rawMaterialsOutgoingCode") String rawMaterialsOutgoingCode) {

		RawMaterialsOutgoing rawMaterialsOutgoingDeleteInfo = rawmaterialsMapper.rawMaterialsOutgoingDeleteInfo(rawMaterialsOutgoingCode);
		model.addAttribute("title", "원자재 출고 삭제");
		model.addAttribute("pageTitle", "원자재 출고 삭제");
		model.addAttribute("rawMaterialsOutgoingDeleteInfo", rawMaterialsOutgoingDeleteInfo);

		return "admin/rawmaterials/rawmaterialsDeleteOutgoing";
	}
	@PostMapping("/deleteoutgoingRawmaterials")
	public String deleteoutgoingRawMatrials(@RequestParam(value = "rawMaterialsOutgoingCode") String rawMaterialsOutgoingCode){
		int result = rawmaterialsService.deleteoutgoingRawMatrials(rawMaterialsOutgoingCode);
		return "redirect:/admin/listOutgoingRawmaterials";
	}

	//원자재 입고 리스트 페이지
	@GetMapping("/listIncomingRawmaterials")
	public String listIncomingRawMatrials(Model model
			, @RequestParam(value = "msg", required = false) String msg) {

		List<RawMaterialsIncoming> rawMaterialsIncomingList = rawmaterialsMapper.getRawMaterialsIncomingList();

		model.addAttribute("title", "원자재 입고 조회");
		model.addAttribute("rawMaterialsIncomingList", rawMaterialsIncomingList);
		model.addAttribute("subTitle", "원자재 입고 조회");

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/rawmaterials/rawmaterialsListIncoming";
	}


	@GetMapping("/listNowRawmaterials")
	public String listNow() {

		return "admin/rawmaterials/rawmaterialsListNow";
	}

	// 원자재 출고 리스트
	@GetMapping("/listOutgoingRawmaterials")
	public String listOutgoingRawMatrials(Model model) {
		List<RawMaterialsOutgoing> rawMaterialsOutgoingList = rawmaterialsMapper.rawMaterialsOutgoingList();

		model.addAttribute("title", "원자재 출고 리스트");
		model.addAttribute("rawMaterialsOutgoingList", rawMaterialsOutgoingList);


		return "admin/rawmaterials/rawmaterialsListOutgoing";
	}

	//원자재 입고 수정 처리
	@PostMapping("/modifyIncomingRawmaterials")
	public String modifyIncomingRawMatrials(RawMaterialsIncoming rawMaterialsIncoming
			, RedirectAttributes reAttr) {

		int result = rawmaterialsService.modifyIncomingRawMatrials(rawMaterialsIncoming);

		if (result == 0) {
			reAttr.addAttribute("msg", "원자재 입고 수정에 실패하였습니다.");
			reAttr.addAttribute("rawMaterialsCode", rawMaterialsIncoming.getRawMaterialsCode());
			return "redirect:/admin/modifyIncomingRawmaterials";
		} else {
			reAttr.addAttribute("msg", "원자재 입고 수정에 성공하였습니다.");
		}
		return "redirect:/admin/listIncomingRawmaterials";
	}

	//원자재 입고 수정 페이지
	@GetMapping("/modifyIncomingRawmaterials")
	public String modifyIncomingRawMatrials(Model model
			, @RequestParam(value = "rawMaterialsCode") String rawMaterialsCode
			, @RequestParam(value = "msg", required = false) String msg) {

		RawMaterialsIncoming rawMaterialsIncomingInfo = rawmaterialsMapper.getRawMaterialsIncomingInfo(rawMaterialsCode);

		model.addAttribute("title", "원자재 입고 수정");
		model.addAttribute("pageTitle", "원자재 입고 수정");
		model.addAttribute("rawMaterialsIncomingInfo", rawMaterialsIncomingInfo);
		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/rawmaterials/rawmaterialsModifyIncoming";
	}

	@GetMapping("/modifyOutgoingRawmaterials")
	public String modifyOutgoingRawMatrials(Model model, @RequestParam(value = "rawMaterialsOutgoingCode") String rawMaterialsOutgoingCode
															, @RequestParam(value = "msg", required = false) String msg) {

		RawMaterialsOutgoing modifyOutgoingRawmaterialsInfo = rawmaterialsMapper.modifyOutgoingRawmaterialsInfo(rawMaterialsOutgoingCode);
		model.addAttribute("title", "원자재 출고 수정");
		model.addAttribute("pageTitle", "원자재 출고 수정");
		model.addAttribute("modifyOutgoingRawmaterialsInfo", modifyOutgoingRawmaterialsInfo);

		if (msg != null) {
			model.addAttribute("msg", msg);
		}


		return "admin/rawmaterials/rawmaterialsModifyOutgoing";
	}
	@PostMapping("/modifyOutgoingRawmaterials")
	public String modifyOutgoingRawMatrials(RawMaterialsOutgoing rawMaterialsOutgoing){
		rawmaterialsService.modifyOutgoingRawMatrials(rawMaterialsOutgoing);
		return "redirect:/admin/listOutgoingRawmaterials";
	}
	@GetMapping("/checkRawMaterialCode")
	@ResponseBody
	public int checkRawMaterialCode(@RequestParam(value = "rawMaterialsCode", required = false) String rawMaterialsCode){
		int isChecked = 0;

		isChecked = rawmaterialsMapper.checkRawMaterialCode(rawMaterialsCode);
		return isChecked;
	}

	@GetMapping("/totalRawmaterialsInOut")
	public String totalRawMatrialsInOut(Model model) {
		List<RawMaterials> rawmaterialsList = rawmaterialsService.rawmaterialsList();

		model.addAttribute("title", "원자재리스트");
		model.addAttribute("rawmaterialsList", rawmaterialsList);
		log.info("찍히나?");

		return "admin/rawmaterials/rawmaterialsTotalInOut";
	}
}



