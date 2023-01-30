package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.mapper.BusinessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusinessService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final BusinessMapper businessMapper;

    public BusinessService(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    public List<Business> businessList(){
        // 거래처 조회
        return businessMapper.listBusiness();
    }
    public int addBusiness(Business business){
        // 거래처 추가
        return businessMapper.addBusiness(business);
    }
    public int modifyBusiness(Business business){
        // 거래처 수정
        return businessMapper.modifyBusiness(business);
    }
    public Business getInfoByBusiness(String businessCode){
        //특정 거래처 조회
        return businessMapper.getInfoByBusiness(businessCode);
    }
}
