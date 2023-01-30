package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.BoardEvent;
import ks45team02.ire.admin.mapper.BoardEventMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class BoardEventService {

    private final BoardEventMapper boardEventMapper;

    public BoardEventService(BoardEventMapper boardEventMapper) {
        this.boardEventMapper = boardEventMapper;
    }

    public List<BoardEvent> getBoardEventList() {
        List<BoardEvent> boardEventList = boardEventMapper.getBoardEventList();

        return boardEventList;

    }

    public int addBoardEvent(BoardEvent boardEvent, MultipartFile eventImage) throws IllegalStateException, IOException {

        if(!eventImage.isEmpty()){
            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/eventImages";

            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" +eventImage.getOriginalFilename();

            File saveFile = new File(projectPath, fileName);

            eventImage.transferTo(saveFile);

            boardEvent.setEventImageName(fileName);
            boardEvent.setEventImagePath("/eventImages/" + fileName);


        }
        int result = boardEventMapper.addBoardEvent(boardEvent);
        return result;

    }

    public BoardEvent viewBoardEvent(String eventTitle) {
        BoardEvent boardEventContents = boardEventMapper.viewBoardEvent(eventTitle);

        return boardEventContents;
    }

    public int modifyBoardEventInfo(BoardEvent boardEvent) {
        int result = boardEventMapper.modifyBoardEventInfo(boardEvent);
        return result;
    }

    public BoardEvent modifyBoardEvent(String eventTitle){
        BoardEvent boardEventInfo = boardEventMapper.viewBoardEvent(eventTitle);
        return boardEventInfo;
    }

    public int deleteBoardEvent(String eventCode) {
        int result = boardEventMapper.deleteBoardEvent(eventCode);
        return result;
    }
}
