package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	
	public static void main(String[] args) {
		
		File file = new File("c:/temp/new.txt"); // new.txt 파일의 정보를 읽어오는것
		File file1 = new File("c:/temp/images/img1/new"); // 디렉토리의 정보를 읽어오는것
			try {
				if(!file.exists()) {
					file.createNewFile(); // 파일이 없다면 파일을 생성해주는 것
					System.out.println("파일을 생성");
				}
				if(!file1.exists()) {
					file1.mkdirs();
					System.out.println("폴더를 생성");
				}
				FileWriter fw = new FileWriter(file); // 입출력스트림의 매개값
				fw.write("Hello\n");
				fw.write("World\n");
				fw.flush();
				fw.close();
				if(file.exists()) {
					file.delete();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		System.out.println("end of prog");
	}
}
