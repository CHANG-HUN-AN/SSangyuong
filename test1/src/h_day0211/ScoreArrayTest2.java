package h_day0211;

import java.util.Scanner;

/**
 *	test1에 했던 점수입력을 배열까지 입력받아 만든다
 *for문을 유연하게 사용 하는 로직
 * @author user
 */
public class ScoreArrayTest2 {

	public static void main(String[] args) {
		Scanner	scanner = new Scanner(System.in);//System의 파란색은 상수를 의미
		boolean flag = true;
		
		while(flag) {
		System.out.print("배열생성 yes[1]/no[2]> \t");
		int start = scanner.nextInt();
		
			if(start==1){
				System.out.print("배열 갯수 입력 yes[1]/no[0]> \t");
				int scoreSize= scanner.nextInt();
				int[] scoreList =new int[scoreSize];
				
				if(scoreList.length != 0) {
					int sum = 0;
					
					for (int i = 0; i < scoreList.length; i++) {
						System.out.print("점수를 입력하시겠습니까?> yes[1]/no[0]\t");
						String exit = scanner.next();
						
						if (exit == "1" || exit.equals("1")||
								exit == "yes"||exit.equals("yes")||
								exit == "YES"||exit.equals("YES")) {
							System.out.print("scoreSize[" + i + "]점수 입력>\t");
							scoreList[i] = scanner.nextInt();
							sum += scoreList[i];
						}else {
							System.out.println("다시입력하시오");
							i = scoreList.length;  //자연스러운 종료는 조건절에 맞춰서 break 사용 안한다
						}//end else
					}//end for
					//배열갯수는알지만 3명만 알고 2명은 모르는 경우
					
//					for (int i = 0; i < scoreList.length; i++) {
//						System.out.println(scoreList[i]);
//					}//end for
					
					//출력
					for(int i:scoreList) {
						System.out.println("score="+i);
					}//확장된 for문이다;
					System.out.println("점수["+sum+"]"+
												"\t평균["+sum/scoreList.length+"]");
				}else {
					System.out.println("프로그램 종료");
				}//end else
				flag=false;
			}else if (start ==2 ) {
				System.out.println("프로그램 종료됩니다");
				flag=false;
			}else {
				System.out.println("다시 적어주세요");
				flag=true;
			}//end if
		}
		
	}

}
