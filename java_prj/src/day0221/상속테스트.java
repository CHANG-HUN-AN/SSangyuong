package day0221;

public class ����׽�Ʈ {

	public static void main(String[] args) {
		�ﰢ�� �������ﰢ�� = new �ﰢ��();
		���� ������ﰢ�� = new �ﰢ��();
		�簢�� �Ķ����簢�� = new �簢��();
		�� �ʷϻ��� = new ��();
		���� ���� = new ����();
		
//		�ﰢ�� �ʷϻﰢ�� = new ����(); ->���屸����ü�� ���� x
		System.out.println("-----------------------------");
		����.draw();
		�������ﰢ��.draw();
		�Ķ����簢��.draw();
		�ʷϻ���.draw();
		System.out.println("-----------------------------");
		�ﰢ�� �ʷϻﰢ�� = (�ﰢ��)������ﰢ��;
		������ﰢ��.getColor();
		System.out.println(������ﰢ��.color);
		
		
		�ʷϻﰢ��.getColor();
		System.out.println(�ʷϻﰢ��.color);
		�ʷϻﰢ��.draw();
		
		
		�������ﰢ��.color="����";
		�Ķ����簢��.color="�Ķ�";
		�ʷϻ���.color="�ʷ�";

		�������ﰢ��.getColor();
		�Ķ����簢��.getColor();
		�ʷϻ���.getColor();
		
	}
}
