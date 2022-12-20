package com.toy.runeah.simpleWebServlet.misc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath,String originalName,Part filePart) throws Exception {
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		
		// 입력 스트림
		InputStream fis = filePart.getInputStream();
		
		// 파일 출력 스트림 (저장)
		FileOutputStream fos = new FileOutputStream(target);
		
		// 1024byte 씩 버퍼에 담아 읽어오는 과정
		// write(buffer, offset, length); 를 통해 읽어온 만큼만 쓰는 방법
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);
		fos.close();
		fis.close();
		
		String uploadedFileName = makeUploadedFileName(uploadPath, savedPath, savedName);
		
		return uploadedFileName;
	}
	
	private static String makeUploadedFileName(String uploadPath, String path, String fileName) throws Exception {
		String uploadedFileName = uploadPath + path + File.separator + fileName;
		
		return uploadedFileName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths) { ///가변인자, 사실상 String 배열을 취급하는것과 비슷함
		if(new File(paths[paths.length-1]).exists()) {
			return;
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
}
