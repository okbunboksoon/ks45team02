package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.RefundStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefundStandardMapper {
    public List<RefundStandard>listRefundStandard();
}
