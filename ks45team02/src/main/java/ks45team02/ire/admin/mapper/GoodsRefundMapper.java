package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsRefund;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsRefundMapper {
    //환불조회
    public List<GoodsRefund>listGoodsRefund();
    //환불등록
    public int addGoodsRefund(GoodsRefund goodsRefund);
    //특정환불조회
    public GoodsRefund getGoodsRefund(String goodsRefundCode);
    //환불수정
    public int modifyRefund(GoodsRefund goodsRefund);
}
