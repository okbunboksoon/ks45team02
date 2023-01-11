package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks45team02.ire.admin.dto.FileDto;
import ks45team02.ire.admin.mapper.FileMapper;
import ks45team02.ire.admin.uitl.FileUtil;

@Service
@Transactional
public class FileService {
	
	private FileUtil fileUtil;
	private FileMapper fileMapper;	
	
	public FileService(FileUtil fileUtil, FileMapper fileMapper) {
		
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}

	public void fileUpload(MultipartFile[] uploadfile, String fileRealPath) {
		
		List<FileDto> fileList= fileUtil.parseFileInfo(uploadfile, fileRealPath);
		
		System.out.println(fileList);
		
		if(fileList != null) fileMapper.addFile(fileList);
		
	}
	
	public List<FileDto> getFileList(){
		return fileMapper.getFileList();
	}
	
	public FileDto getFileInfoByIdx(String fileIdx) {
		return fileMapper.getFileInfoByIdx(fileIdx);
	}
}