package ks45team02.ire.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardReview;

@Mapper
public interface UserBoardReviewMapper {

	//리뷰 데이터 개수 조회
	public int getReviewCnt(String goodsCode);
	
	//특정 상품 리뷰 조회
	public List<BoardReview> getReviewForGoods(Map<String, Object> pageMap);
}
