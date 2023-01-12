package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.CashReceipts;

@Mapper
public interface CashReceiptsMapper {
	
	//현금영수증 삭제
	public int deleteCashReceipts(String cashCode);
	
	//현금영수증 수정
	public int modifyCashReceipts(CashReceipts cashReceipts);
	
	//현금영수증 코드로 현금영수증 조회
	public CashReceipts getCashReceiptsInfo(String cashCode);
	
	//현금영수증 등록
	public int addCashReceipts(CashReceipts cashReceipts);
	
	//현금영수증 조회
	public List<CashReceipts> getCashReceiptsList();
	
}
