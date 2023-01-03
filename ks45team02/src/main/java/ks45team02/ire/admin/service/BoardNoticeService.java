package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.mapper.BoardNoticeMapper;

@Service
public class BoardNoticeService {

	
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeService.class);

	
	private final BoardNoticeMapper boardNoticeMapper;
	
	public BoardNoticeService(BoardNoticeMapper boardNoticeMapper) {
		
		this.boardNoticeMapper = boardNoticeMapper;
	}
	
	/**
	 * 공지사항 목록, 페이징
	 * @param currentPage
	 * @return paramNoticeMap
	 */
	public List<BoardNotice> getNoticeList(){
		
		List<BoardNotice> noticeList = boardNoticeMapper.getNoticeList();
		
		return noticeList;
	}
	
	/**
	 * 공지사항 등록
	 * @param boardNotice
	 * @return boardNoticeMapper.insertNotice(boardNotice)
	 */
	public int addNotice(BoardNotice boardNotice) {
		
		return boardNoticeMapper.addNotice(boardNotice);
	}
	
	/**
	 * 공지사항 상세페이지
	 * @param noticeCode
	 * @return detailsNotice
	 */
	public List<BoardNotice> detailsNotice(String noticeCode){
		
		List<BoardNotice> detailsNotice = boardNoticeMapper.detailsNotice(noticeCode);
		
		return detailsNotice;
	}
	
	/**
	 * 공지사항 수정처리
	 * @param boardNotice
	 * @return boardNoticeMapper.modifyBoardNotice(boardNotice)
	 */
	public int modifyBoardNotice(BoardNotice boardNotice) {
		
		return boardNoticeMapper.modifyBoardNotice(boardNotice);
	}
	
	public int deleteBoardNotice(String noticeCode) {
		
		return boardNoticeMapper.deleteBoardNotice(noticeCode);
	}
}

