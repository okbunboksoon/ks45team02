package ks45team02.ire.admin.mapper;


import ks45team02.ire.admin.dto.BoardEventFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardEventFileMapper {
    void addFile(List<BoardEventFile> boardEventFileList);

    List<BoardEventFile> getBoardEventFileList();

    List<BoardEventFile> getBoardEventFileInfoByIdx(String eventFileIdx);
}
