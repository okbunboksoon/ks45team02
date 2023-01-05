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
}