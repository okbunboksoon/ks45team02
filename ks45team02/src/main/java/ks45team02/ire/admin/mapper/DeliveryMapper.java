package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Delivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    public List<Delivery>listDelivery();
}
