package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardReview;

@Mapper
public interface BoardReviewMapper {

	//리뷰 게시판 상세 보기
	public BoardReview getBoardReviewInfo(String reviewCode);
	
	//리뷰 게시판 목록 조회
	public List<BoardReview> getBoardReviewList();
}
