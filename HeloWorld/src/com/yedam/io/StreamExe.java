package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {

	public static void main(String[] args) {
		
		// 입력과 출력 스트림을 이용하여 파일을 복사하는 과정
		// 1바이트를 읽고 1바이트를 쓰고를 반복
		
		try {
			InputStream is = new FileInputStream("c:/temp/image.PNG");
			OutputStream os = new FileOutputStream("c:/temp/image3.PNG");
			
			byte[] buf = new byte[100]; // 한번에 100바이트씩 읽기 위해서 선언
			
			while(true) {
				int data = is.read(buf); // 100바이트씩 읽음
				if(data == -1) {
					break;
				}
				os.write(buf); // 100바이트씩 반환
				os.flush();
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
		

	
	static void write() {
		
		// 바이트 기반 출력 스트림
		try {
			OutputStream os = new FileOutputStream("c:/temp/data.bin");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush(); //사용한 버퍼를 비워주는 작업
			os.close(); //출력스트림을 닫음
			
		} catch (IOException e) { // filenotfound 오류보다 IO 오류가 상위 오류로 IO를 오류 예외로 넣어주면 자동으로 filenotfound 오류도 처리
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
	
	static void read() {
		
		// 바이트 기반 입력 스트림
		try {
			InputStream is = new FileInputStream("c:/temp/data.bin");
			while(true) {
				int data = is.read(); // 끝까지 읽고 나면 -1값을 반환한다
				if(data == -1) {
					break;
				}
				System.out.println(data);	
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
	

}
