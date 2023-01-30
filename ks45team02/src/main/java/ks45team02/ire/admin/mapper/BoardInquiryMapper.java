package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.BoardInquiry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardInquiryMapper {
    // 1:1문의 조회
    public List<BoardInquiry> listInquiryList();

    //1:1문의 추가
    public int addInquiry(BoardInquiry boardInquiry);
    //1:1문의 상세페이지
    public List<BoardInquiry>contentsInquiry(String inquiryCode);
    //1:1특정 문의 조회
    public BoardInquiry getInquiryInfo(String inquiryCode);
    //1:1문의 수정
    public int modifyInquiry(BoardInquiry boardInquiry);
    //1:1문의 답변
    public int answer(BoardInquiry boardInquiry);
    //1:1문의 유저별 조회
    public List<BoardInquiry> userInquiryList(String inquiryCode);
    //1:1문의 답변 조회
    public List<BoardInquiry>answerAdminList();
}
