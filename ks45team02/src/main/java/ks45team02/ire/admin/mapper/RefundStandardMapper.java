package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.RefundStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefundStandardMapper {
    //환불기준조회
    public List<RefundStandard>listRefundStandard();
    //환불기준등록
    public int addRefundStandard(RefundStandard refundStandard);
}
