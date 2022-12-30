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
}
