package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.CashReceipts;

@Mapper
public interface CashReceiptsMapper {

	//현금영수증 조회
	public List<CashReceipts> getCashReceiptsList();
	
}
