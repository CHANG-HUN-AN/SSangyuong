package h_day0211;

/**
 * �迭�� ���뿡 ���� ����
 * �ε����� ����,����,����,����,��� ���
 * @author user
 */
public class ScoreArrayTest {

	public static void main(String[] args) {
		int [] score = {90,100,100,100,50};
		String [] subject = {"����","����","����","����","��ȸ"};
		int sum=0;
		
		for (int i = 0; i < score.length; i++) {
			String sub ="";
//			if(i==0)sub ="����";
//			else if (i==1) sub ="����";
//			else if (i==2)sub ="����";
			System.out.println(subject[i]+":"+score[i]);
//			if(i==0) {
//				System.out.println("����["+score[i]+"]");
//			}else if(i==1) {
//				System.out.println("����["+score[i]+"]");
//			}else if(i==2) {
//				System.out.println("����["+score[i]+"]");
//			}//end else -> �ݺ��Ǵ� ���� syso +socre[i] 
			sum+=score[i];
			if(i==score.length-1) {
				System.out.println("---------------------------------------");
				System.out.println("���� : " +sum+" ��� : "+sum/score.length);
			}
		}//end for
		System.out.println("����["+score[0]+"]"+"����["+score[1]+"]"+"����["+score[2]+"]"+
								"����["+sum+"]"+"����["+sum/score.length+"]");
	}//end main

}//end class
