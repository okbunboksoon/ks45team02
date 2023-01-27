package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsExchange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsExchangeMapper {
    //교환등록
    public int addGoodsExchange(GoodsExchange goodsExchange);
    //교환조회
    public List<GoodsExchange>listGoodsExchange();
    //특정교환조회
    public GoodsExchange getGoodsExchange(String goodsExchangeCode);
    //교환수정
    public int modifyGoodsExchange(GoodsExchange goodsExchange);
}
