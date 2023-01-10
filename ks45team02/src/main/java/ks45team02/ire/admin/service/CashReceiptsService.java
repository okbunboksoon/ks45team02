package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.CashReceipts;
import ks45team02.ire.admin.mapper.CashReceiptsMapper;

@Service
public class CashReceiptsService {
	
	private static final Logger log = LoggerFactory.getLogger(CashReceiptsService.class);
	
	private final CashReceiptsMapper cashReceiptsMapper;
	
	public CashReceiptsService(CashReceiptsMapper cashReceiptsMapper) {
		this.cashReceiptsMapper = cashReceiptsMapper;
	}

	/**
	 * 현금영수증 조회
	 * @return List<CashReceipts>
	 */
	public List<CashReceipts> getCashReceiptsList(){
		
		List<CashReceipts> cashReceiptsList = cashReceiptsMapper.getCashReceiptsList();
		
		return cashReceiptsList;
	}
	
}
