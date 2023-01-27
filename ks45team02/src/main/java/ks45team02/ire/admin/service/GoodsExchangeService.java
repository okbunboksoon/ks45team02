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
        //교환등록
        return goodsExchangeMapper.addGoodsExchange(goodsExchange);
    }
    public int modifyGoodsExchange(GoodsExchange goodsExchange){
        //교환수정
        return goodsExchangeMapper.modifyGoodsExchange(goodsExchange);
    }
}
