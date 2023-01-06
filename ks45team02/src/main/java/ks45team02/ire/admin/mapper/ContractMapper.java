package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    //계약조회
    public List<Contract> listContract();

    //계약 등록
    public int addContract(Contract contract);
    //특정 계약 조회
    public Contract getInfoByContract(String contractCode);
    //계약 수정
    public int modifyContract(Contract contract);
}
