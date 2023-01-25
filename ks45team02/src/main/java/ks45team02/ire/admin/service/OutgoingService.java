package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Outgoing;
import ks45team02.ire.admin.mapper.OutgoingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OutgoingService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final OutgoingMapper outgoingMapper;

    public OutgoingService(OutgoingMapper outgoingMapper) {
        this.outgoingMapper = outgoingMapper;
    }

    public int addOutgoing(Outgoing outgoing){
        //상품출고 등록
        return outgoingMapper.addOutgoing(outgoing);
    }
}
