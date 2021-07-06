package com.vuejs.content.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

@Component
public class FileService {
	
	@Value("${file.realPath}")
	private String uploadPath;
	
	@Autowired
	private FileDao dao;
	
	public String fileUpload(HttpServletRequest request,String category,String fileInputName)  {
		//    fileService.fileUpload(request,"bestPlace","image");
		
		String user_id = request.getParameter("user_id");
		String result = null;
		
		List<MultipartFile> files = ((MultipartRequest) request).getFiles(fileInputName);
        FileOutputStream fos = null;
        
        if(files.size() > 0) {
        	String savePath = "/"+category+"/"+ user_id +"/"+new Date().getTime()+"/";
        	String fullPath = uploadPath + savePath;
        	File file = new File(fullPath);
        	
        	if(file.exists() == false) {
        		file.mkdirs();
        	}
        	
        	for(MultipartFile f : files) {
        		Map<String,Object> param =  new HashMap<String,Object>();
        		
        		String originalFileName = f.getOriginalFilename();  //파일이름
        		String originalFileExtension = f.getOriginalFilename().substring(originalFileName.lastIndexOf("."));  // 확장자
        		String storedFileName =  originalFileName;
        		
        		System.out.println("저장이름:  "+storedFileName);
        		
        		
        		result =  savePath + storedFileName;
        		
        		file = new File(fullPath + storedFileName);
        		System.out.println(file.getAbsolutePath());
        		
        		try {
        			 byte[] fileBytes = f.getBytes();
                     fos = new FileOutputStream(file);
                     fos.write(fileBytes);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					 try {
						 fos.close();
						 param.put("user_id", user_id);
			        	 param.put("file", result);
						 dao.insertFile(param);
						 
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
        	}
        	
        }
       
		return result;
	}

}
