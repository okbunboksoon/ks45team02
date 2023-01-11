package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.GoodsExchange;
import ks45team02.ire.admin.mapper.GoodsExchangeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsExchangeService {
    private final GoodsExchangeMapper goodsExchangeMapper;

    public GoodsExchangeService(GoodsExchangeMapper goodsExchangeMapper) {
        this.goodsExchangeMapper = goodsExchangeMapper;
    }

    public int addGoodsExchange(GoodsExchange goodsExchange){
        return goodsExchangeMapper.addGoodsExchange(goodsExchange);
    }
}
