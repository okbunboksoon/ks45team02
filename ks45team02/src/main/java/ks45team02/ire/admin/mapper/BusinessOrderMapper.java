package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BusinessOrder;

@Mapper
public interface BusinessOrderMapper {
	
	/**
	 * 발주 목록 전체 조회
	 */
	public List<BusinessOrder> getListBusinessOrder();
	
	/**
	 * 발주 등록 처리
	 */
	public int addBusinessOrder(BusinessOrder businessOrder);
	
	/**
	 * 발주 삭제 처리
	 */
	public int deleteBusinessOrder(String businessOrderCode);
	
	/**
	 * 발주 목록 특정 코드 조회
	 */
	public List<BusinessOrder> getListBusinessOrderByCode(String businessOrderCode);
	
	public List<BusinessOrder> getListBusinessOrderRe();
	
	public int modifyBusinessOrder(BusinessOrder businessOrder);
}
