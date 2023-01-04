package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.BoardFAQ;
import ks45team02.ire.admin.dto.BoardNotice;
import ks45team02.ire.admin.mapper.BoardFAQMapper;
import ks45team02.ire.admin.mapper.BoardNoticeMapper;

@Service
public class BoardFAQService {

	
	private static final Logger log = LoggerFactory.getLogger(BoardFAQService.class);

	
	private final BoardFAQMapper boardFAQMapper;
	
	public BoardFAQService(BoardFAQMapper boardFAQMapper) {
		
		this.boardFAQMapper = boardFAQMapper;
	}
	
	/**
	 * FAQ 등록
	 * @param boardNotice
	 * @return boardNoticeMapper.insertNotice(boardNotice)
	 */
	public int addFAQ(BoardFAQ boardFAQ) {
		
		return boardFAQMapper.addFAQ(boardFAQ);
	}
	
	
	/**
	 * FAQ 리스트
	 * @param currentPage
	 * @return paramNoticeMap
	 */
	public List<BoardFAQ> getFAQList(){
		List<BoardFAQ> FAQList = boardFAQMapper.getFAQList();
		return FAQList;
		
	}
	
	/**
	 * FAQ 수정처리
	 * @param boardFAQ
	 * @return boardFAQMapper.modifyBoardFAQ(boardFAQ)
	 */
	public int modifyBoardFAQ(BoardFAQ boardFAQ) {
		return boardFAQMapper.modifyBoardFAQ(boardFAQ);
	}
	
	/**
	 * FAQ 상세페이지
	 * @param FAQ_code
	 * @return contentsFAQ
	 */
	public List<BoardFAQ> contentsFAQ (String FAQ_code){
		List<BoardFAQ> contentsFAQ = boardFAQMapper.contentsFAQ(FAQ_code);
		return contentsFAQ;
	}
	
	/**
	 * FAQ 삭제처리
	 */
	public int deleteBoardFAQ(String FAQ_code) {
		return boardFAQMapper.deleteBoardFAQ(FAQ_code);
	}
	
}
