package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.mapper.BoardNoticeMapper;

@Service
@Transactional
public class BoardNoticeService {

	
	private static final Logger log = LoggerFactory.getLogger(BoardNoticeService.class);

	
	private final BoardNoticeMapper boardNoticeMapper;
	
	public BoardNoticeService(BoardNoticeMapper boardNoticeMapper) {
		
		this.boardNoticeMapper = boardNoticeMapper;
	}
	
	/**
	 * 공지사항 목록
	 * @param currentPage
	 * @return noticeList
	 */
	public List<BoardNotice> getNoticeList(){
		
		List<BoardNotice> noticeList = boardNoticeMapper.getNoticeList();
		
		return noticeList;
	}
	
	/**
	 * 공지사항 등록
	 * @param boardNotice
	 * @return result
	 */
	public int addNotice(BoardNotice boardNotice) {
		
		int result = 0;
		result = boardNoticeMapper.addNotice(boardNotice);
		
		return result;
	}
	
	/**
	 * 공지사항 상세페이지
	 * @param noticeCode
	 * @return detailsNotice
	 */
	public List<BoardNotice> ContentsNotice(String noticeCode){
		
		List<BoardNotice> contentsNotice = boardNoticeMapper.ContentsNotice(noticeCode);
		
		return contentsNotice;
	}
	
	/**
	 * 공지사항 수정처리
	 * @param boardNotice
	 * @return result
	 */
	public int modifyBoardNotice(BoardNotice boardNotice) {
		
		int result = 0;
		result = boardNoticeMapper.modifyBoardNotice(boardNotice);
		
		return result;
	}
	
	/**
	 * 공지사항 삭제처리
	 * @param noticeCode
	 * @return result
	 */
	public int deleteBoardNotice(String noticeCode) {
		
		int result = 0;
		result = boardNoticeMapper.deleteBoardNotice(noticeCode);
		
		return result;
	}
}

