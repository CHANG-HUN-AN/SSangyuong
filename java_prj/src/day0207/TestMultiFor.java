package day0207;

/**
 * ���� for �� ���� ����
 * 
 * @author user
 */
public class TestMultiFor {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(i + " " + j);
			} // mfor\
			System.out.println("---------------------------");
		} // for

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "= " + i * j);
			} // end for
			System.out.println("---------------------------");
		} // end for

//		00
//		1011
//		202122
//		30313233 �� ����϶�
//		���� for �� ���
//		hint ) print �� print ln �� ������ ����Ѵ�.

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print((i-1)+""+j);
			}//end mfor
			System.out.println();
		}//end for
		System.out.println("------------------------------");
		
		for(int i =0; i<6; i++) {
			for(int j = i+1; j<6;j++) {
				System.out.print(i+""+j);
			}
			System.out.println();
		}
		
		//���ѷ���~(ä�ü���,������)�� ���
		for(;;) {
			System.out.println("����������������");
			break;
		}//end for
		System.out.println("���ѷ���~");
		
		//���� ������ų�� �ִ� ���ѷ���
//		for(int i =1 ; ; i++) {
//			System.out.println("���ѷ���~");
//		}//end for
		
		//continue : �ݺ����� ������ �ǳ� �۶�
		//0~100���� ¦���� ����(continue�̿�)
		for(int i = 0; i <100; i++) {
			if(i%2==1) {
				continue;
			}//end if
			System.out.println(i);
		}//end for
	}// end main
}// end class
