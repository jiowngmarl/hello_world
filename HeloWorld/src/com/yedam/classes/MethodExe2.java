package com.yedam.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MethodExe2 {
	
	//필드
	private List<Product> store;
	
	//생성자
	public MethodExe2() {
		init();
	}
	
	void init1() {
		store = new ArrayList<Product>(); // new Product[10];
		try {
			Scanner scanner = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while(true) {
				String msg = scanner.nextLine();
				
				String[] msgAry = msg.split(" ");
				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			
		}
		// 초기화 작업의 끝
	}
	
	void init() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			store = (List<Product>) ois.readObject(); // Object는 최상위 클래스이므로 다운캐스팅으로 타입을 맞춰준다
			for(Product prod : store) {
				System.out.println(prod.showList());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
	
	// 종료 시점에 store 정보를 message.txt에 저장
	void save1() {
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			for(Product prod : store) {
				String msg = prod.getProductCode() + " " + prod.getProductName() + " " + prod.getPrice();
				writer.write(msg + "\n");
				writer.flush();
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(store);
			oos.flush();
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//메서드
	public boolean add(Product prd) {
		boolean result = store.add(prd);
		return result;
	}
	
	public List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(prd.getProductName().equals("ALL") || store.get(i).getProductName().equals(prd.getProductName())) {
				if(store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));	
				} 
			}
		}
		return list;
	}
	
	public boolean remove(String code) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(Product prod) {
		
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prod.getProductCode())) {
				if(prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				if(prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}
}
