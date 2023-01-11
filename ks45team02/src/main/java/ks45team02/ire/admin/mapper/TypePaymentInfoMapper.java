package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.TypePaymentInfo;

@Mapper
public interface TypePaymentInfoMapper {

	//구매자별 결제 종류 수정
	public int modifyTypePaymentInfo(TypePaymentInfo typePaymentInfo);
	
	//결제 종류 코드로 구매자별 결제 종류 조회
	public TypePaymentInfo getTypePaymentInfoByPaymentTypeCode(String paymentTypeCode);
	
	//구매자별 결제 종류 등록
	public int addTypePaymentInfo(TypePaymentInfo typePaymentInfo);
	
	//구매자별 결제 종류 조회
	public List<TypePaymentInfo> getTypePaymentInfoList();
	
	//회원 아이디와 결제종류가 일치하는지 확인 
	public int checkIdWithPaymentType(String userId, String paymentTypeCode);
}
