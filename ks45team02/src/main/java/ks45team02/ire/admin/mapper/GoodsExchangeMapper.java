package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsExchange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsExchangeMapper {

    public int addGoodsExchange(GoodsExchange goodsExchange);
    public List<GoodsExchange>listGoodsExchange();
    public GoodsExchange getGoodsExchange(String goodsExchangeCode);
    public int modifyGoodsExchange(GoodsExchange goodsExchange);
}
