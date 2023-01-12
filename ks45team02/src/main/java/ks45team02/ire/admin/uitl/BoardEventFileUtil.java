package ks45team02.ire.admin.uitl;

import ks45team02.ire.admin.dto.BoardEventFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component

public class BoardEventFileUtil {
    public List<BoardEventFile> parseFileInfo(MultipartFile[] uploadfile, String fileRealPath) {

        // 파일이 존재하지 않은 경우
        if (ObjectUtils.isEmpty(uploadfile) || uploadfile[0].isEmpty()) {
            return null;
        }

        // 날짜 패턴
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 현재 날짜(디렉토리 명)
        ZonedDateTime current = ZonedDateTime.now();

        // 파일idx, 파일 타입, 헤더안의 콘텐츠의 실제 콘텐츠 유형, 파일 경로, 디렉토리 분류

        String boardeventFileIdx, originalFileExtension, contentType, path, directory;

        List<BoardEventFile> boardEventFileList = new ArrayList<>();

        for (MultipartFile multipartFile : uploadfile) {
            if (multipartFile.isEmpty() == false) {
                contentType = multipartFile.getContentType();

                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    if (contentType.indexOf("image/") > -1) {
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        }
                        directory = "images" + File.separator;
                    } else {
                        directory = "files" + File.separator;
                    }

                    //Paths 클래스를 통한 파일의 경로(주소의 / 경로와 실제 os의 경로 \의 차이)
                    path = Paths.get(fileRealPath + directory + current.format(format)).toString();

                    //파일 경로 셋
                    File file = new File(path);

                    //파일 디렉토리 없을 경우 디렉토리 생성
                    if (file.exists() == false) {
                        file.mkdirs();
                    }

                    //파일 명이 겹치지 않게 파일명 ㅅ ㅓㄹ정
                    String resultFileName = "";
                    String[] fileNameSplit = multipartFile.getOriginalFilename().split("\\.");

                    for (int i = 0; i < fileNameSplit.length; i++) {
                        if (i == (fileNameSplit.length - 1)) {
                            fileNameSplit[i] = "." + fileNameSplit[i];
                        } else {
                            fileNameSplit[i] = fileNameSplit[i].replaceAll("\\s", "") + Long.toString(System.nanoTime());
                        }
                        resultFileName += fileNameSplit[i];
                    }
                    byte[] bytes;
                    Path uploadPath = Paths.get(path + "/" + resultFileName);

                    try {
                        bytes = multipartFile.getBytes();

                        //파일 업로드
                        Files.write(uploadPath, bytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }

                    boardeventFileIdx = "file_" + current.format(format) + Long.toString(System.nanoTime());
                    BoardEventFile boardEventFile = new BoardEventFile();
                    boardEventFile.setEventFileIdx(boardeventFileIdx);
                    boardEventFile.setEventFileSize(multipartFile.getSize());
                    boardEventFile.setEventFileOriginalName(multipartFile.getOriginalFilename());
                    boardEventFile.setEventFileNewName(resultFileName);
                    boardEventFile.setEventFilePath(directory + current.format(format) + File.separator + resultFileName);
                    boardEventFileList.add(boardEventFile);
                }
            }
        }
        return boardEventFileList;
    }
}