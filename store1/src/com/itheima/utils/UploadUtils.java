package com.itheima.utils;

import java.util.UUID;

public class UploadUtils {
	
	public static String getUuidFileName(String uploadFileName) {
		int fileIndex=uploadFileName.indexOf(".");
		String str=uploadFileName.substring(fileIndex);
		
		return UUID.randomUUID().toString().replace("-", "")+str;
	}
	
	public static String getPath(String uuidFileName) {
		int code1=uuidFileName.hashCode();
		int d1=code1 & 0xf;
		//0,1Öµ£¬×ó±ßÓÒÒÆ4Î»
		int code2= code1 >>> 4;
		int d2=code2 & 0xf;
		return "/"+d1+"/"+d2+"/";
	}

	public static void main(String[] args) {
		
		System.out.println(getPath("asdfghj566.txt"));
	}
}
