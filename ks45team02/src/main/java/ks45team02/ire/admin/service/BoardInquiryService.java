package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.BoardInquiry;
import ks45team02.ire.admin.mapper.BoardInquiryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardInquiryService {
    private static final Logger log = LoggerFactory.getLogger(BoardNoticeService.class);
    private final BoardInquiryMapper boardInquiryMapper ;

    public BoardInquiryService(BoardInquiryMapper boardInquiryMapper) {
        this.boardInquiryMapper = boardInquiryMapper;
    }

    public List<BoardInquiry>boardInquiryList(){
        // 1:1문의 전체 조회
        List<BoardInquiry> boardInquiryList=boardInquiryMapper.listInquiryList();
        return boardInquiryList;
    }
    public int addInquiry(BoardInquiry boardInquiry){
        // 1:1문의 등록 하다멈춤...ㅎㅁㅎ
        return boardInquiryMapper.addInquiry(boardInquiry);
    }


}
