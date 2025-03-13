package com.yedam.classes;

public class MethodExe1 {
	
	// 메서드 생성시 리턴타입, 메소드, 필요시 매개변수 순으로 생성한다
	
	public void printString(int times, String str) {
		for(int i = 0; i  < times; i++) {
			System.out.println(str);	
		}
	} 
	
	public int sum(int n1, int n2) {
		int result = 0;
		result = n1 + n2;
		return result;	
	}
	
	public double sum(double n1, double n2) {
		return (n1 + n2);
	}
	
	public int sum(int[] ary) {
		int result = 0;
		for(int i = 0;  i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}
	
	public double sum(double[] ary) {
		double result = 0;
		for(int i = 0; i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}
}
