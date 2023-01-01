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
	 * 공지사항 등록
	 */
	public int addFAQ(BoardFAQ boardFAQ) {
		
		return boardFAQMapper.addFAQ(boardFAQ);
	}
	
}
