package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yedam.classes.Product;

public class ObjectStreamExe {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Product> list = (List<Product>) ois.readObject(); // Object는 최상위 클래스이므로 다운캐스팅으로 타입을 맞춰준다
			for(Product prod : list) {
				System.out.println(prod.showList());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
		
	
	static void write() {
		
		// 객체를 바이트타입으로 변환 : 직렬화
				// 바이트타입을 객체로 변환 : 역직렬화
				// Serializable (인터페이스)를 implements 하여 구연하는 클래스만 직렬화, 역직렬화를 처리해줌
				// Product 클래스에 Serializable을 상속하여 직렬화, 역직렬화가 가능해졌다 (Product 클래스를 가서 확인하기)
				
				List< Product> list = new ArrayList<Product>();
				list.add(new Product("A001", "연필", 1000));
				list.add(new Product("B001", "지우개", 500));
				
				try {
					FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(list);
					oos.flush();
					oos.close();
					fos.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
