package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Outgoing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutgoingMapper {
    public List<Outgoing>getOutgoingAmount();
    //상품출고 조회
    public List<Outgoing>listOutgoing();
    //상품출고 등록
    public int addOutgoing(Outgoing outgoing);
}
