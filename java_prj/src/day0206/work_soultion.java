package day0206;

/**
 * work �� ���� �ؼ�
 * �ڵ��� ó���� �κкκ� ¥�� ���� ��õ�Ѵ�.
 * @author user
 */
public class work_soultion {
	//�⺻����� ���ֺ�������ʾ� constant �� ǥ���Ѵ�.
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	public static final int TAXI = 3800;
	
	public static void main(String[] args) {
		//���߱������� �ƴ����� �Ǵ�
		if(args[0].equals("����")||args[0].equals("����ö")||args[0].equals("�ý�")) {
			//����,����ö(������ݰ�� ���)���� �ƴ����� �Ǵ�
			if(args[0].equals("����")||args[0].equals("����ö")) {//������ݴ��
				int distance = Integer.parseInt(args[1]);//�̿�Ÿ�
				int typeFare = work_soultion.BUS; //������ �⺻������� �켱 ����
				int tempFare = 0; // �ʰ����
				
				if(args[0].equals("����ö")){
					typeFare = work_soultion.SUBWAY;
				}//end if
				if(distance >10) {//10km�� �ʰ��� ����� �ʰ����
					tempFare = (((distance-10)/5)+1)*100;
				}//end if
				System.out.println("�Է±��������"+args[0]+" �����"+typeFare+"��, �ʰ����"+tempFare+"��, �Ѱ��� ��� "+(typeFare+tempFare)+"�� �Դϴ�");			}else{//�ܼ���� ���
				System.out.println("���Ҷ� �̿��ϴ� ������� ��� 3800���Դϴ�.");
			}//end else
		}else {
			System.out.println("���߱��� �ƴ�");
		}//end else
	}//main
}//class
