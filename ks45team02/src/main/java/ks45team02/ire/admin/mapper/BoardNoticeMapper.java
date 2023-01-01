package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardNotice;

@Mapper
public interface BoardNoticeMapper {
	
	/**
	 * 공지사항 전체 목록
	 */
	public List<BoardNotice> getNoticeList(); 

	/**
	 * 공지사항 전체 페이지갯수
	 */
	public int getNoticeListCnt();
	
	/**
	 * 공지사항 등록
	 */
	public int addNotice(BoardNotice boardNotice);
	
	public List<BoardNotice> detailsNotice(String noticeNum);
}
