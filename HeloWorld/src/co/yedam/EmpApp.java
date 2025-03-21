package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EmpApp {
	
	public static void main(String[] args) {
		
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		
		
		while(run) {			
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			int num1 = Integer.parseInt(scanner.nextLine());
			
			switch (num1){
			case 1 :
				
				System.out.print("사번입력 >> ");
				String empNo = scanner.nextLine();
				System.out.print("이름입력 >> ");
				String name = scanner.nextLine();
				System.out.print("전화번호입력 >> ");
				String phoneNo = scanner.nextLine();
				System.out.print("입사일입력 >> ");
				String date = scanner.nextLine();
				System.out.print("급여입력 >> ");
				String salary = scanner.nextLine();
				
				Employee employee =  new Employee(empNo, name, phoneNo, date, Integer.parseInt(salary));

				if(dao.insert(employee)) {
					System.out.println("등록완료");
				} else {
					System.out.println("등록실패");
				}
				
				break;
			case 2 :
				
				
				System.out.println(dao.list());

				
				
				break;
			case 3 :
				
				
				

				break;
			case 4 :
				while(true) {
					System.out.print("사번 >> ");
					String num2 = scanner.nextLine();
					
					if (dao.delete(num2)) {
						System.out.println("삭제 완료");
						break;
					} else {
						System.out.println("삭제 실패");
					}
				}
				break;
			case 5 :
//				while(true) {
//					System.out.println("입사 일자 >> ");
//					String date2 = scanner.nextLine();
//					
////					if(dao.list() == date2) {
////						
////					}
//				}
//				
//				
				break;
			case 6 :
				System.out.println("종료");
				run = false;
				break;
			default:
				System.out.println("다시입력");
			}
			
		}
		
	}
}
