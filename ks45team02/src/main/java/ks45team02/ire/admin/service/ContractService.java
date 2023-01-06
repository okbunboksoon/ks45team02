package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Contract;
import ks45team02.ire.admin.mapper.ContractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final ContractMapper contractMapper;

    public ContractService(ContractMapper contractMapper) {
        this.contractMapper = contractMapper;
    }
    public List<Contract>listContract(){
        //계약 조회
        return contractMapper.listContract();
    }
    public int addContract(Contract contract){
        //계약 등록
        return contractMapper.addContract(contract);
    }
    public Contract getInfoByContract(String contractCode){
        //특정 계약 조회
        return contractMapper.getInfoByContract(contractCode);
    }
    public int modifyContract(Contract contract){
        //계약 수정
        return contractMapper.modifyContract(contract);
    }
}
