package com.yedam.ref;

import java.util.Iterator;

public class ArrayExe4 {
	
	public static void main(String[] args) {
		int[] intAry = { 8, 7, 2, 3, 4};
		
		//위치변경
		int temp = 0;
		for(int i = 0; i < intAry.length - 1; i++ ) {
			for(int j = 0; j < intAry.length - 1; j++) {
				if(intAry[j] < intAry[j+1]) {
					temp = intAry[j+1];
					intAry[j+1] = intAry [j];
					intAry[j] = temp;
				}
			}
		}
		for(int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			System.out.println("수정");
		}
	}
}
