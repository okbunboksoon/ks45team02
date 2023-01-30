package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Incoming;
import ks45team02.ire.admin.mapper.IncomingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IncomingService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final IncomingMapper incomingMapper;


    public IncomingService(IncomingMapper incomingMapper) {
        this.incomingMapper = incomingMapper;
    }


    public List<Incoming>incomingList(){
        //상품 입고 조회
        return incomingMapper.listIncoming();
    }
    public int addIncoming(Incoming incoming){
        //상품 입고 추가
        return incomingMapper.addIncoming(incoming);
    }
    public int modifyIncoming(Incoming incoming){
        //상품입고 수정
        return incomingMapper.modifyIncoming(incoming);
    }
}
