package com.yedam.classes;

public class MethodExe3 {

	public String gugudan(int num, int toNum) {
	
		String str = "";
		for(int i = num;  i <= toNum; i++) {
			for(int j = 1;  j < 10; j++) {
				str += num + " * " + j + " = " + num*j + "\n";
//				System.out.println(num + " * " + j + " = " + num*j);
			}
			num++;
		}
		return str;
	}
	
	public void printStar(int cnt, String str) {
		String a = "";
		for(int i = 0; i < cnt; i++) {
			a += str ;
			System.out.println(a+"\n");
		}
	}
	
	public void printCard() {
		int[] intAry = new int[16];
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 16) + 1;
			for(int j = 0; j < intAry.length; j++) {
				int a = intAry[i];
				intAry[i] = 0;
				if(intAry[j] != a) {
					intAry[i] = a;
				} else {
					intAry[i] = 0;
					i--;
				}
			}
		}
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%3d", intAry[i]);
			if(i % 4 == 3) {
				System.out.println();
			}
		}

		System.out.println("수정");
	}
	
}
