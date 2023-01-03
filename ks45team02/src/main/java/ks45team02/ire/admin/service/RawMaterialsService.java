package ks45team02.ire.admin.service;

import java.util.List;
import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.mapper.DonationMapper;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RawMaterialsService {

	private final RawMaterialsMapper rawmaterialsMapper ;
	private final DonationMapper donationMapper ;
	public int result;
	public RawMaterialsService(RawMaterialsMapper rawmaterialsMapper, DonationMapper donationMapper) {
		this.rawmaterialsMapper = rawmaterialsMapper;
		this.donationMapper = donationMapper;
	
	}
	
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
			: rawMaterialsIncoming.setDonationPointSave(500);
			break;
		case "폐기" 
			: rawMaterialsIncoming.setDonationPointSave(0);
			break;
		}
		
		
		for(int i = 0; i < rawMaterialsIncomingAmount; i++) {
			result += rawmaterialsMapper.addIncomingRawmaterials(rawMaterialsIncoming);
		}
		
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
	
	}


