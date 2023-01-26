package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.GoodsRefund;
import ks45team02.ire.admin.mapper.GoodsRefundMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsRefundService {
    private final GoodsRefundMapper goodsRefundMapper;

    public GoodsRefundService(GoodsRefundMapper goodsRefundMapper) {
        this.goodsRefundMapper = goodsRefundMapper;
    }
    public int addGoodsRefund(GoodsRefund goodsRefund){
        //환불등록
        return goodsRefundMapper.addGoodsRefund(goodsRefund);
    }
    public int modifyRefund(GoodsRefund goodsRefund){
        //환불수정
        return goodsRefundMapper.modifyRefund(goodsRefund);
    }
}
