package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.BoardEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardEventMapper {

    List<BoardEvent> getBoardEventList();

    public void addBoardEvent(BoardEvent boardEvent);

    List<BoardEvent> getBoardEventTitleList();
}
