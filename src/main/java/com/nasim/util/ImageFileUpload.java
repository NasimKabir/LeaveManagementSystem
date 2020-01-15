package com.nasim.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class ImageFileUpload {
	private static Path path = null;

	public static String saveImageName(MultipartFile file, String fileName, HttpServletRequest request) {
		String picName = "";
//		 String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//         path = Paths.get(rootDirectory + "/LeaveManagement/src/main/resources/static/profilePic" + fileName + ".jpg");
		path = Paths.get("/LeaveManagement/src/main/resources/static/profilePic" + fileName + ".jpg");
		System.out.println(path);
		if (!file.isEmpty()) {
			try {
				file.transferTo(new File(path.toString()));
				picName = fileName + ".jpg";
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return picName;
	}
}
