package day0206;

/**
 *���߱�����ܰ� km�� �Է¹޾� �Ʒ��� ǥ�� �����Ͽ� ���
 *����-1250,����ö-1300,�ý�-3800
 *�Է±�������� ����,����ö,�ýÿ����� ��� �ϰ� 3���� ���߱����� �ƴ϶�� "���߱����� �ƴѺκ� ����,������"���
 *����,����ö�� ��5km����  100���� �߰������ �ٴ´� �ýô� �⺻��ݸ� ���
 *����,����ö:�Է� ������� xx ����� xx��,�պ���� xx�� �Ѵ� 20�ϱ��� �����xxx�� �Դϴ�.
 *�ý�:���Ҷ� �̿��ϴ� ������� ��� 3800���Դϴ�.
 * @author user
 */
public class work {
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	public static final int TAXI = 3800;

	public static void main(String[] args) {
		String pubTrans = args[0]; //args�� ������ ��������
		int km =Integer.parseInt(args[1]);
		int price = 0;
		if(pubTrans.equals("����")||pubTrans.equals("����ö")) {
			if(km>10) {
				km = km -10;
				price += ((km/5)+1)*100;
			}
			if(pubTrans.equals("����")) {
				price += BUS;
				System.out.println("�Է±��������"+pubTrans+" �����"+price+"��, �պ����"+price*2+"��, �Ѵ� 20�� ���� ����� "+price*2*20+"�� �Դϴ�");
			}else{
				price += SUBWAY;
				System.out.println("�Է±��������"+pubTrans+" �����"+price+"��, �պ����"+price*2+"��, �Ѵ� 20�� ���� ����� "+price*2*20+"�� �Դϴ�");
			}
		}else if(pubTrans.equals("�ý�")) {
			System.out.println("���Ҷ� �̿��ϴ� ������� ��� 3800���Դϴ�.");
		}else {
			System.out.println("���߱����� �ƴѺκ� ����,������");
		}//end else
	}
}