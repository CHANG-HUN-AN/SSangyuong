package day0205;
/**
	��������
	�Ϲݳ�:�������� ���迬���ڸ� ��� ���� ��
	 &&, ||
	��Ʈ��: ��Ʈ�� �����Ҷ�
	 &&, || ,^
	 
*/
public class Operator5 {
	public static void main(String[] args) 	{
		//�Ϲݳ�
		//&&;���װ� ������ ��� t >>t 
		
//		System.out.println(5>2 && 10 < 100);
		boolean flag1 = true , flag2 = false , flag3 = true, flag4 = false;
		System.out.println("--------------&&--------------------");
		System.out.println(flag1 + " && " +flag3+"= " + (flag1 && flag3));
		System.out.println(flag1 + " && " +flag2+"= " + (flag1 && flag2));
		//������ �����̸� �ڿ��� �������� �ʴ´�
		System.out.println(flag2 + " && " +flag3+"= " + (flag2 && flag3));
		System.out.println(flag2 + " && " +flag4+"= " + (flag2 && flag4));

		System.out.println("--------------||--------------------");
		//������ true �̸� ��������ʰ� true
		System.out.println(flag1 + " || " +flag3+"= " + (flag1 || flag3));
		System.out.println(flag1 + " ||	" +flag2+"= " + (flag1 || flag2));
		System.out.println(flag2 + " || " +flag3+"= " + (flag2 || flag3));
		System.out.println(flag2 + " || " +flag4+"= " + (flag2 || flag4));

		boolean temp1 = false, temp2 = false, result = false;
		//������ false �̸� ���׿����� ���� �ʴ´�.
		result= (temp1=3<2) && ( temp2 = 3>2);
		System.out.println(temp1 + ", " + temp2 +", "+result);

		//��Ʈ��
		//&(and): ������Ʈ�� ������Ʈ ��� 1�ΰ�� 1�������ش�
		//|(or)
		//^(xor)

		int i= 19, j =25 ;
		System.out.println(i+" & " +j +" = "+ (i&j));
		System.out.println(i+" | " +j +" = "+ (i|j));
		System.out.println(i+" ^ " +j +" = "+ (i^j));
	}//main

	
}//class

