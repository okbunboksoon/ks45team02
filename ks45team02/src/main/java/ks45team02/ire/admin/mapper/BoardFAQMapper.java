package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.BoardFAQ;

@Mapper
public interface BoardFAQMapper {
	
	/* FAQ 등록 */
	public int addFAQ(BoardFAQ boardFAQ);
	
	/* FAQ 리스트 */
	public List<BoardFAQ> getFAQList();
	
	/* FAQ 수정처리 */
	public int modifyBoardFAQ (BoardFAQ boardFAQ);
	
	/* FAQ! 상세페이지*/
	public List<BoardFAQ> contentsFAQ(String FAQ_Code);
	
	/* FAQ 삭제처리*/
	public int deleteBoardFAQ(String FAQ_code);
}
