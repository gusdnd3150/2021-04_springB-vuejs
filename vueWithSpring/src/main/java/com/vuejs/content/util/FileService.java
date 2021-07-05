package com.vuejs.content.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileService {
	
	public String fileUpload(MultipartHttpServletRequest request,String category) {
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		
		List<MultipartFile> file = request.getFiles("image");
		System.out.println(file.size());
		
		for(int i = 0;  i < file.size(); i++) {
			file.get(i).getOriginalFilename();
		}
		
		return "";
	}

}
