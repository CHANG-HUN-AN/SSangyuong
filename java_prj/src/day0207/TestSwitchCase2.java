package day0207;

/**
 * switch case �� ����Ͽ� �������ϱ�<br>
 * @author user
 */
public class TestSwitchCase2 {
	//case���� ����� ���°ͺ��� constant �� �Ἥ �������� ����ų�� �ִ�.
	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	public static void main(String[] args) {
		int score = 100;
		char grade = 'F';
		if(score>-1 && score<101) {
			switch(score/10) {
			case GRADE_A_PLUS: 
			case GRADE_A: grade ='A';break;
			case GRADE_B: grade ='B';break;
			case GRADE_C: grade ='C';break;
			case GRADE_D: grade ='D';
			}//end switch
			System.out.println(score+" ���� ������ "+grade+" �̳� ������");
		}//end if
		//������ break�� ���̽Ἥ �Ʒ��Ŵ� break�� ���ݽἭ(break�� �ִ°� �����ڵ� why? ���� �����Ͽ� ������� ���ֱ⶧��)
		//break �� ���̾��ٰ� �׻� ���� �ڵ�� �ƴϴ� ��Ȳ�� ���� �����ϰ� ����� �����ڵ�
		System.out.println("----------------------------------------");
		grade = 'A';//�����ڵ� 64�⺻���� 
		score = 96;
		switch(score/10) {
		case GRADE_D: grade++;
		case GRADE_C: grade++;
		case GRADE_B: grade++;
		case GRADE_A: 
		case GRADE_A_PLUS:grade++;break;
		default: grade+= 6;
		}//end switch
		System.out.println("����"+score+"������"+grade);
		
		System.out.println("----------------------------------------");
		
	}//end main
}//end class
