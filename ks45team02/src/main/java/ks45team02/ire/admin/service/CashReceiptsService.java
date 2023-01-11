package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.CashReceipts;
import ks45team02.ire.admin.mapper.CashReceiptsMapper;
import ks45team02.ire.admin.mapper.TypePaymentInfoMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
public class CashReceiptsService {
	
	private static final Logger log = LoggerFactory.getLogger(CashReceiptsService.class);
	
	private final CashReceiptsMapper cashReceiptsMapper;
	private final UserMapper userMapper;
	private final TypePaymentInfoMapper typePaymentInfoMapper;
	
	public CashReceiptsService(CashReceiptsMapper cashReceiptsMapper, UserMapper userMapper, TypePaymentInfoMapper typePaymentInfoMapper) {
		this.cashReceiptsMapper = cashReceiptsMapper;
		this.userMapper = userMapper;
		this.typePaymentInfoMapper = typePaymentInfoMapper;
	}
	
	/**
	 * 현금영수증 삭제
	 * @param cashCode
	 * @return int
	 */
	public int deleteCashReceipts(String cashCode) {
		
		int result = 0;
		
		result += cashReceiptsMapper.deleteCashReceipts(cashCode);
		
		return result;
	}
	
	/**
	 * 현금영수증 수정
	 * @param cashReceipts
	 * @return int
	 */
	public int modifyCashReceipts(CashReceipts cashReceipts) {
		
		int result = 0;
		
		int idCheck = userMapper.idCheck(cashReceipts.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		int checkIdWithPaymentType = typePaymentInfoMapper.checkIdWithPaymentType(cashReceipts.getUserId(), cashReceipts.getPaymentTypeCode());
		if(checkIdWithPaymentType == 0) {
			return 20;
		}
		
		result = cashReceiptsMapper.modifyCashReceipts(cashReceipts);
		
		return result;
	}
	
	/**
	 * 현금영수증 등록
	 * @param cashReceipts
	 * @return int
	 */
	public int addCashReceipts(CashReceipts cashReceipts) {
		
		int result = 0;
		
		int idCheck = userMapper.idCheck(cashReceipts.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		int checkIdWithPaymentType = typePaymentInfoMapper.checkIdWithPaymentType(cashReceipts.getUserId(), cashReceipts.getPaymentTypeCode());
		if(checkIdWithPaymentType == 0) {
			return 20;
		}
		
		result = cashReceiptsMapper.addCashReceipts(cashReceipts);
		
		return result;
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
