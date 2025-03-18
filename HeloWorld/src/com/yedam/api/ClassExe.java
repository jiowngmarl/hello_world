package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExe {

	public static void main(String[] args) {

		
		try {
			Class cls =  Class.forName("com.yedam.bookApp.Book");   // ClassNotFoundException
			Method[] methods = cls.getDeclaredMethods();
			
			for(int i = 0; i < methods.length; i++) {
//				System.out.println(methods[i].getName());
			}
			
			
			Constructor[] cons = cls.getConstructors();
			for(int i = 0; i < methods.length; i++) {
				System.out.println(cons[i].getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
