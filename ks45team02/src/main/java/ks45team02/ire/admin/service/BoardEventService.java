package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.BoardEvent;
import ks45team02.ire.admin.mapper.BoardEventMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardEventService {

    private final BoardEventMapper boardEventMapper;

    public BoardEventService(BoardEventMapper boardEventMapper) {
        this.boardEventMapper = boardEventMapper;
    }

    public List<BoardEvent> getBoardEventList() {
        List<BoardEvent> boardEventList = boardEventMapper.getBoardEventList();

        return boardEventList;

    }

    public void addBoardEvent(BoardEvent boardEvent){

        boardEventMapper.addBoardEvent(boardEvent);
    }

    public List<BoardEvent> viewBoardEvent(String eventTitle) {
        List<BoardEvent> boardEventContents = boardEventMapper.viewBoardEvent(eventTitle);

        return boardEventContents;
    }

    public int modifyBoardEventInfo(BoardEvent boardEvent) {
        int result = boardEventMapper.modifyBoardEventInfo(boardEvent);
        return result;
    }

    public BoardEvent modifyBoardEvent(String eventNum){
        BoardEvent boardEventInfo = boardEventMapper.modifyBoardEvent(eventNum);
        return boardEventInfo;
    }
}
