package ks45team02.ire.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardNotice;

@Mapper
public interface BoardNoticeMapper {
	
	/**
	 * 공지사항 전체 목록
	 */
	public List<BoardNotice> getNoticeList(Map<String, Object> paramNoticeMap); 

	/**
	 * 공지사항 전체 페이지갯수
	 */
	public int getNoticeListCnt();
	
	/**
	 * 공지사항 등록
	 */
	public int addNotice(BoardNotice boardNotice);
	
	/**
	 * 공지사항 상세페이지
	 */
	public List<BoardNotice> detailsNotice(String noticeNum);
	
	/**
	 * 공지사항 수정처리
	 */
	public int modifyBoardNotice(BoardNotice boardNotice);
}