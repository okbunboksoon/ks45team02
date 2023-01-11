package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsExchange;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsExchangeMapper {

    public int addGoodsExchange(GoodsExchange goodsExchange);
}
