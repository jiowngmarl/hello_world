package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class characterExe {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("c:/temp/message.txt")); // message.txt를 읽는다
			
			while(true) {
				String msg = scanner.nextLine(); // 한줄씩 값을 읽음
				String[] msgAry = msg.split(" "); // split : 나누는 기능 -> 공백을 기준으로 나누어 문자열 배열에 넣겠다
				System.out.println("상품코드 : " + msgAry[0] + ", 이름 : " + msgAry[1] + ", 가격 : " + msgAry[2]); // 읽은 값을 출력
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (NoSuchElementException e) { // 더이상 읽어드릴 값이 없으면 발생하는 오류 NoSuchElementException
			
		}
		scanner.close();
		System.out.println("end of prog");
	}
	
	static void write() {
		
		// 문자 입력 스트림
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('a');
			writer.write('b');
			writer.write('c');
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void write2() {
		Scanner scanner = new Scanner(System.in);
		// 입력값을 파일출력
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while(true) {
				System.out.print("입력 : ");
				String msg = scanner.nextLine();
				if(msg.equals("quit"))
					break;
				writer.write(msg + "\n");
				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void read() {
		try {
			Reader reader = new FileReader("d:/Dev/git/hello_world/HeloWorld/src/com/yedam/io/StreamExe.java");
			while(true) {
				int data = reader.read();
				if(data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
		}catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
