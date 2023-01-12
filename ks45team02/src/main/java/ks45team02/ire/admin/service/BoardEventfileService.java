package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.BoardEventFile;
import ks45team02.ire.admin.mapper.BoardEventFileMapper;
import ks45team02.ire.admin.uitl.BoardEventFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional

public class BoardEventfileService {

    private final BoardEventFileUtil boardEventFileUtil;
    private final BoardEventFileMapper boardEventFileMapper;

    public BoardEventfileService(BoardEventFileUtil boardEventFileUtil, BoardEventFileMapper boardEventFileMapper) {
        this.boardEventFileUtil = boardEventFileUtil;
        this.boardEventFileMapper = boardEventFileMapper;
    }


    public void fileUpload(MultipartFile[] uploadfile, String fileRealPath){
        List<BoardEventFile> boardEventFileList = boardEventFileUtil.parseFileInfo(uploadfile, fileRealPath);

        System.out.println(boardEventFileList);

        if(boardEventFileList != null) boardEventFileMapper.addFile(boardEventFileList);
    }

    public List<BoardEventFile> getFilelist(){
        return boardEventFileMapper.getBoardEventFileList();
    }

    public List<BoardEventFile> getBoardEventFileInfoByIdx(String eventFileIdx){
        return boardEventFileMapper.getBoardEventFileInfoByIdx(eventFileIdx);
    }
}
