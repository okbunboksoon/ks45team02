package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Incoming;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IncomingMapper {
    //상품입고 조회
    public List<Incoming>listIncoming();
    //상품 입고 등록
    public int addIncoming(Incoming incoming);
    //특정 상품입고 조회
    public Incoming getInfoByIncoming(String incomingCode);
    //상품재고조회
    public List<Map<String,Object>> getStockAmount();

}
