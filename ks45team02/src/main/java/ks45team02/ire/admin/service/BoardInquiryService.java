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
        //1:1문의 등록
        return boardInquiryMapper.addInquiry(boardInquiry);
    }
    public List<BoardInquiry>ContentInquiry(String inquiryCode){
        //1:1문의 상세 페이지
        List<BoardInquiry>contentsInquiry=boardInquiryMapper.contentsInquiry(inquiryCode);
        return contentsInquiry;
    }
    public int modifyInquiry(BoardInquiry boardInquiry){
        //1:1문의 수정
        return boardInquiryMapper.modifyInquiry(boardInquiry);
    }
    public int answer(BoardInquiry boardInquiry){
        //1:1문의 답변
        return boardInquiryMapper.answer(boardInquiry);
    }

}
