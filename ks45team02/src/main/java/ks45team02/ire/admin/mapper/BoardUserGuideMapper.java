package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardUserGuide;

@Mapper
public interface BoardUserGuideMapper {

	/**
	 * 이용가이드 전체 목록
	 */
	public List<BoardUserGuide> getUserGuideList();
	
	/**
	 * 이용가이드 상세페이지
	 */
	public List<BoardUserGuide> ContentsUserGuide(String guide_code);
	
	/**
	 * 이용가이드 등록
	 */
	public int addUserGuide (BoardUserGuide boardUserGuide);
	
	/**
	 * 이용가이드 수정처리
	 */
	public int modifyBoardUserGuide(BoardUserGuide boardUserGuide);
	
	/**
	 * 이용가이드 삭제처리
	 */
	public int deleteBoardUserGuide (String guide_code);
	
	/**
	 * 이용가이드 조회수 올리기
	 */
	 public int updateViewsCnt(String guide_code);
	 
}
