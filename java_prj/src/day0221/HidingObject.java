package day0221;

/**
 * ����ȭ�� �������� modifier �� ���������� �˾ƺ���
 * @author user
 */
public class HidingObject {
	//Field
	public String name1 = "ȫ�浿";
	private String name2 = "��浿";
	String name3 = "ȫ�浿3";
	
	/**
	 *private�� ���������� ������ ��ȸ������ read�� �ǰ� ����°���
	 * @return
	 */
	public String getName2() {
		return name2; 
	}
}
