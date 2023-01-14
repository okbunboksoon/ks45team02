package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.BoardUserGuide;
import ks45team02.ire.admin.mapper.BoardUserGuideMapper;

@Service
@Transactional
public class BoardUserGuideService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardUserGuideService.class);

	private final BoardUserGuideMapper boardUserGuideMapper;
	
	public BoardUserGuideService(BoardUserGuideMapper boardUserGuideMapper) {
		this.boardUserGuideMapper = boardUserGuideMapper;
	}
	
	/**
	 * 이용가이드 목록
	 * @param currentPage
	 * @return userGuideList
	 */
	public List<BoardUserGuide> getUserGuideList(){
		
		List<BoardUserGuide> userGuideList = boardUserGuideMapper.getUserGuideList();
		
		return userGuideList;
	}
	
	/**
	 * 이용가이드 상세페이지
	 * @param guide_code
	 * @return contentsUserGuide
	 */
	public List<BoardUserGuide> ContentsUserGuide(String guide_code){
		
		List<BoardUserGuide> contentsUserGuide = boardUserGuideMapper.ContentsUserGuide(guide_code);
		
		return contentsUserGuide;
	}
	
	/**
	 * 이용가이드 등록
	 * @param boardUserGuide
	 * @return result
	 */
	public int addUserGuide (BoardUserGuide boardUserGuide) {
		
		int result = 0;
		result = boardUserGuideMapper.addUserGuide(boardUserGuide);
		
		return result;
	}
	
	/**
	 * 이용가이드 수정처리
	 * @param boardUserGuide
	 * @return result
	 */
	public int modifyBoardUserGuide (BoardUserGuide boardUserGuide) {
		
		int result = 0;
		result = boardUserGuideMapper.modifyBoardUserGuide(boardUserGuide);
		
		return result;
	}
	
	/**
	 * 이용가이드 삭제처리
	 * @param guide_code
	 * @return result
	 */
	public int deleteBoardUserGuide (String guide_code) {
		
		int result = 0;
		result = boardUserGuideMapper.deleteBoardUserGuide(guide_code);
		
		return result;
	}
	
	/**
	 * 이용가이드 조회수 올리기
	 */
	public int updateViewsCnt(String guide_code) throws Exception{
		
		return boardUserGuideMapper.updateViewsCnt(guide_code);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
