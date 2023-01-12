package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsRefund;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsRefundMapper {
    public List<GoodsRefund>listGoodsRefund();
    public int addGoodsRefund(GoodsRefund goodsRefund);

    public GoodsRefund getGoodsRefund(String goodsRefundCode);
    public int modifyRefund(GoodsRefund goodsRefund);
}
