package ks45team02.ire.admin.service;

import ks45team02.ire.admin.controller.UserController;
import ks45team02.ire.admin.dto.RefundStandard;
import ks45team02.ire.admin.mapper.RefundStandardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RefundStandardService {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    private final RefundStandardMapper refundStandardMapper;

    public RefundStandardService(RefundStandardMapper refundStandardMapper) {
        this.refundStandardMapper = refundStandardMapper;
    }


    public int addRefundStandard(RefundStandard refundStandard){
        //환불기준 등록
        return refundStandardMapper.addRefundStandard(refundStandard);
    }
}
