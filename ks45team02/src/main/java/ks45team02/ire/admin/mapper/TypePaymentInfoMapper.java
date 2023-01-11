package ks45team02.ire.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypePaymentInfoMapper {

	//회원 아이디와 결제종류가 일치하는지 확인 
	public int checkIdWithPaymentType(String userId, String paymentTypeCode);
}
