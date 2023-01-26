package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.ExchangeStandard;
import ks45team02.ire.admin.mapper.ExchangeStandardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExchangeStandardService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final ExchangeStandardMapper exchangeStandardMapper;

    public ExchangeStandardService(ExchangeStandardMapper exchangeStandardMapper) {
        this.exchangeStandardMapper = exchangeStandardMapper;
    }

    public int addExchangeStandard(ExchangeStandard exchangeStandard){
        //교환기준등록
        return exchangeStandardMapper.addExchangeStandard(exchangeStandard);
    }
}
