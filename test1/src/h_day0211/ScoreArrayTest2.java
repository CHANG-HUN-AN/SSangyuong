package h_day0211;

import java.util.Scanner;

/**
 *	test1�� �ߴ� �����Է��� �迭���� �Է¹޾� �����
 *for���� �����ϰ� ��� �ϴ� ����
 * @author user
 */
public class ScoreArrayTest2 {

	public static void main(String[] args) {
		Scanner	scanner = new Scanner(System.in);//System�� �Ķ����� ����� �ǹ�
		boolean flag = true;
		
		while(flag) {
		System.out.print("�迭���� yes[1]/no[2]> \t");
		int start = scanner.nextInt();
		
			if(start==1){
				System.out.print("�迭 ���� �Է� yes[1]/no[0]> \t");
				int scoreSize= scanner.nextInt();
				int[] scoreList =new int[scoreSize];
				
				if(scoreList.length != 0) {
					int sum = 0;
					
					for (int i = 0; i < scoreList.length; i++) {
						System.out.print("������ �Է��Ͻðڽ��ϱ�?> yes[1]/no[0]\t");
						String exit = scanner.next();
						
						if (exit == "1" || exit.equals("1")||
								exit == "yes"||exit.equals("yes")||
								exit == "YES"||exit.equals("YES")) {
							System.out.print("scoreSize[" + i + "]���� �Է�>\t");
							scoreList[i] = scanner.nextInt();
							sum += scoreList[i];
						}else {
							System.out.println("�ٽ��Է��Ͻÿ�");
							i = scoreList.length;  //�ڿ������� ����� �������� ���缭 break ��� ���Ѵ�
						}//end else
					}//end for
					//�迭�����¾����� 3�� �˰� 2���� �𸣴� ���
					
//					for (int i = 0; i < scoreList.length; i++) {
//						System.out.println(scoreList[i]);
//					}//end for
					
					//���
					for(int i:scoreList) {
						System.out.println("score="+i);
					}//Ȯ��� for���̴�;
					System.out.println("����["+sum+"]"+
												"\t���["+sum/scoreList.length+"]");
				}else {
					System.out.println("���α׷� ����");
				}//end else
				flag=false;
			}else if (start ==2 ) {
				System.out.println("���α׷� ����˴ϴ�");
				flag=false;
			}else {
				System.out.println("�ٽ� �����ּ���");
				flag=true;
			}//end if
		}
		
	}

}
