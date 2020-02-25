package day0210;

import java.util.Scanner;

/**
 * 이름과 주소를 입력받아 출력하시오 
 * $Scanner 의 메소드들의 사용법$
 * 유효성검사
 * @author user
 */
public class ScannerTest2 {
	// field
	// constructor
	// Method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		boolean flag2 = true;
		while (flag) {
			System.out.print("이름 입력");
			String name = scanner.nextLine();
			// validation 체크 유효성체크
			if (name == "" || name.equals("")) { // 버전에따라 Scanner 객체의 메소드형이 참조형으로 넘어올때도 있고 기본형으로 넘어올때가있어 둘다써준다
				System.out.println("입력값이 없습니다."); // 요버전은 참조형으로 데이터가 넘어오더라
			}
			// next는 띄어쓰기에서 입력값이 멈추지만 , nextLine 메소드는 띄어쓰기 포함해서 한라인을 다 읽어준다
			// 자바버그 next 와 nextLine 을 동시에 같이쓰면 next값이 출력되고 Line값이 먹힌다.
			else {
				while (flag2) {
					System.out.print("주소 입력");
					String address = scanner.nextLine();

					if (address == "" || address.equals("")) {
						System.out.println("주소값이 없습니다.");
					} else {
						System.out.println(name + "는(은)" + address + "에 살고있습니다.");
						flag = false;
						flag2 =false;
					} // end else
				} // end while
					// while이나 do-while은 flag를 설정해주는게 좋다 break로 빠져나오는것은 좋지않음.
			} // end else
		} // end while
	}

}
