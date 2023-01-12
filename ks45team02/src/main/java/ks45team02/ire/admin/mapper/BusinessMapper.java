package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.Goods;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {
    //거래처 검색
	public List<Business> searchBusinessContract(String searchKey, String searchValue);
	//거래처 조회
    public List<Business>listBusiness();
    //거래처 추가
    public int addBusiness(Business business);
    //거래처 수정
    public int modifyBusiness(Business business);
    //특정 거래처 조회
    public Business getInfoByBusiness(String businessCode);


}
