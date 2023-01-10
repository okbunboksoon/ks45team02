package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.ExchangeStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExchangeStandardMapper {
    public List<ExchangeStandard>listExchangeStandard();
    public int addExchangeStandard(ExchangeStandard exchangeStandard);

}
