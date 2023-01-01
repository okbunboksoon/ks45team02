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
	public Map<String, Object> getNoticeList(int currentPage){
		
		int rowPerPage = 10;
		
		int startRowNum = (currentPage - 1) * rowPerPage;
		
		double rowCnt = boardNoticeMapper.getNoticeListCnt();
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
		
		int startPageNum = 1;
		int endPageNum = 10;
		
		if(currentPage >6 && lastPage > 9) {
			startPageNum = currentPage - 5;
		   	endPageNum = currentPage + 4;
            if(endPageNum >= lastPage){
            	startPageNum = lastPage - 9;
            	endPageNum = lastPage;
            }
        }
		if(lastPage < 10) {
			endPageNum = lastPage;
		}
		
		Map<String, Object> paramNoticeMap = new HashMap<String, Object>();
		paramNoticeMap.put("startRowNum", startRowNum);
		paramNoticeMap.put("rowPerPage", rowPerPage);
		
		List<BoardNotice> noticeList = boardNoticeMapper.getNoticeList();
		paramNoticeMap.clear();
		paramNoticeMap.put("noticeList", noticeList);
		paramNoticeMap.put("lastPage", lastPage);
		paramNoticeMap.put("startPageNum", startPageNum);
		paramNoticeMap.put("endPageNum", endPageNum);
		
		return paramNoticeMap;
	}
	
	/**
	 * 공지사항 등록
	 * @param boardNotice
	 * @return boardNoticeMapper.insertNotice(boardNotice)
	 */
	public int addNotice(BoardNotice boardNotice) {
		
		return boardNoticeMapper.addNotice(boardNotice);
	}
	
	public List<BoardNotice> detailsNotice(String noticeNum){
		
		List<BoardNotice> detailsNotice = boardNoticeMapper.detailsNotice(noticeNum);
		
		return detailsNotice;
	}
}
