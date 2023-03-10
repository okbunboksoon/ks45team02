package ks45team02.ire.admin.service;

import ks45team02.ire.admin.controller.EmissionController;
import ks45team02.ire.admin.controller.EmissionStatisticsController;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.dto.RawMaterialsOutgoing;
import ks45team02.ire.admin.mapper.DonationMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RawMaterialsService {

	private final RawMaterialsMapper rawmaterialsMapper ;
	private final DonationMapper donationMapper ;
	private final PointMapper pointMapper ;
	private final EmissionStatisticsService emissionStatisticsService;
	private final EmissionStatisticsController emissionStatisticsController;
	
	public int result;
	public RawMaterialsService(RawMaterialsMapper rawmaterialsMapper, DonationMapper donationMapper, PointMapper pointMapper, EmissionStatisticsService emissionStatisticsService, EmissionStatisticsController emissionStatisticsController) {
		this.rawmaterialsMapper = rawmaterialsMapper;
		this.donationMapper = donationMapper;
		this.pointMapper = pointMapper;
		this.emissionStatisticsService = emissionStatisticsService;
		this.emissionStatisticsController = emissionStatisticsController;
	}
	
	
	/**
	 * 원자재 입고 삭제
	 * @param rawMaterialsCode
	 * @return int
	 */
	public int deleteIncomingRawMatrials(String rawMaterialsCode) {
		
		int result = 0;
		
		result += rawmaterialsMapper.deleteRawMaterialsByRawMaterialsCode(rawMaterialsCode);
		result += rawmaterialsMapper.deleteRawMaterialsOutgoingByRawMaterialsCode(rawMaterialsCode);
		result += rawmaterialsMapper.deleteRawMaterialsIncomingByRawMaterialsCode(rawMaterialsCode);
		
		return result;
	}
	
	/**
	 * 원자재 입고 수정
	 * @param rawMaterialsIncoming
	 * @return int
	 */
	public int modifyIncomingRawMatrials(RawMaterialsIncoming rawMaterialsIncoming) {
		
		int result = 0;
		String donationCode = rawMaterialsIncoming.getDonationCode();
		String rawMaterialsStatus = rawMaterialsIncoming.getRawMaterialsStatus();
		
		int checkDonationCode = donationMapper.checkDonationCode(donationCode);
		if(checkDonationCode == 0) {
			return result;
		}
		
		switch(rawMaterialsStatus) {
		case "정상" 
			: 	PointSaveStandard pointSaveStandardInfo = pointMapper.getPointSaveStandardInfo("point_save_standard_004");
				int pointSave = pointSaveStandardInfo.getPointSave();
				rawMaterialsIncoming.setDonationPointSave(pointSave);
			break;
		case "폐기" 
			: rawMaterialsIncoming.setDonationPointSave(0);
			  rawMaterialsIncoming.setDonationPointGroup(null);
			break;
		}
		
		result = rawmaterialsMapper.modifyIncomingRawMatrials(rawMaterialsIncoming);
		
		return result;
	}
	
	/**
	 * 원자재 입고 등록
	 * @param rawMaterialsIncoming
	 * @return int
	 */
	public int addIncomingRawmaterials(RawMaterialsIncoming rawMaterialsIncoming) {
		
		int result = 0;
		String donationCode = rawMaterialsIncoming.getDonationCode();
		int rawMaterialsIncomingAmount = rawMaterialsIncoming.getRawMaterialsIncomingAmount();
		String rawMaterialsStatus = rawMaterialsIncoming.getRawMaterialsStatus();
		
		int checkDonationCode = donationMapper.checkDonationCode(donationCode);
		if(checkDonationCode == 0) {
			return result;
		}
		
		switch(rawMaterialsStatus) {
		case "정상" 
			: 	PointSaveStandard pointSaveStandardInfo = pointMapper.getPointSaveStandardInfo("point_save_standard_004");
				int pointSave = pointSaveStandardInfo.getPointSave();
				rawMaterialsIncoming.setDonationPointSave(pointSave);
			break;
		case "폐기" 
			: rawMaterialsIncoming.setDonationPointSave(0);
			break;
		}
		
		for(int i = 0; i < rawMaterialsIncomingAmount; i++) {
			result += rawmaterialsMapper.addIncomingRawmaterials(rawMaterialsIncoming);
		}
		
		emissionStatisticsController.addRawMaterialsEmissionStatisticsDay(rawMaterialsIncoming);
		
		
		return result;
	}
	
	/**
	 * 원자재 입고 조회
	 * @return List<RawMaterialsIncoming>
	 */
	public List<RawMaterialsIncoming> getRawMaterialsIncomingList(){
		
		List<RawMaterialsIncoming> rawMaterialsIncomingList = rawmaterialsMapper.getRawMaterialsIncomingList();
		
		return rawMaterialsIncomingList;

	}

	public List<RawMaterials> rawmaterialsList() {
		
		List<RawMaterials> rawmaterialsList =rawmaterialsMapper.rawmaterialsList();
		System.out.println(rawmaterialsList);
		return rawmaterialsList;
	}

    public int addoutgoingRawmaterials(RawMaterialsOutgoing rawMaterialsOutgoing) {

		int result = rawmaterialsMapper.addoutgoingRawmaterials(rawMaterialsOutgoing);
		return result;
    }

    public int modifyOutgoingRawMatrials(RawMaterialsOutgoing rawMaterialsOutgoing) {
		int result = rawmaterialsMapper.modifyOutgoingRawMatrials(rawMaterialsOutgoing);
		return result;
    }

    public int deleteoutgoingRawMatrials(String rawMaterialsOutgoingCode) {
		int result = rawmaterialsMapper.deleteoutgoingRawMatrials(rawMaterialsOutgoingCode);
		return result;
    }
}


