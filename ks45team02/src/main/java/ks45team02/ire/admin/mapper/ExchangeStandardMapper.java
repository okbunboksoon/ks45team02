package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.ExchangeStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExchangeStandardMapper {
    //교환기준조회
    public List<ExchangeStandard>listExchangeStandard();
    //교환기준등록
    public int addExchangeStandard(ExchangeStandard exchangeStandard);

}
