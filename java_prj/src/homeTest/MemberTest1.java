package homeTest;

import java.util.Scanner;

/**
 * ȸ�� ���� ���α׷� ����
 * 
 * @author dksck
 */
public class MemberTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] namelist = new String[2];
		String[] addrlist = new String[2];
		int[] agelist= new int[2];
		
		boolean flag =true;
		boolean menuFlag_1 =true;
		
		int index = 0;
		int searchIndex =0;
		int addCount=0;
		while(flag) {

			System.out.println("--------------------");
			System.out.println("---------���� 0--------");
			System.out.println("---------ȸ�� ��� 1--------");
			System.out.println("---------ȸ�� ����Ʈ 2--------");
			System.out.println("---------ȸ�� �˻� 3--------");
			System.out.println("--------------------");

			System.out.println("�޴� ���� >\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				System.out.println("ȸ���� ��� �Ͻ� �ڽ��ϱ�?> y/n \t");
				String menu1_1 = scanner.next();

				if (menu1_1.equals("y")) {
					menuFlag_1=true;
					while(menuFlag_1) {
						System.out.println("����� ȸ���� ����Ͻðڽ��ϱ�?>>");
						int member_1 = scanner.nextInt();
						
						if (member_1 > 0) {//ȸ�� ���
							if(addCount<namelist.length) { //ȸ���� �ʰ��� 
								if(addCount==0) {
									for (int i = 0; i < member_1; i++) {
										System.out.print("�̸��Է�>\t");
										namelist[i] = scanner.next();
										System.out.print("�ּ��Է�>\t");
										addrlist[i] = scanner.next();
										System.out.print("�����Է�>\t");
										agelist[i] = scanner.nextInt();
										System.out.println("=======");
										addCount ++;
									}//for
								}else {//ȸ�� �߰�
									for (int i = 0; i < member_1; i++) {
										System.out.print("�̸��Է�>\t");
										namelist[addCount] = scanner.next();
										System.out.print("�ּ��Է�>\t");
										addrlist[addCount] = scanner.next();
										System.out.print("�����Է�>\t");
										agelist[addCount] = scanner.nextInt();
										System.out.println("=======");
										addCount ++;
									}//for
								}
							}else {
								System.out.println("ȸ���� �ʰ�! \n"+namelist.length+" �� �ѱ�� �����ϴ�.");
							}
							System.out.println("�޴��� ���ư��ϴ�");
							menuFlag_1 = false;
						} else {
							System.out.println("������ �Է��Ҽ� �����ϴ�.");
						} // if~else
					}//while
				} else {
					System.out.println("�޴��� ���ư��ϴ�");
				}//if~else
				
			}else if (menu == 2) {
				if(namelist[0]==null) {
					System.out.println("ȸ������� �Ǿ����� �ʽ��ϴ�\n����� �ʿ��մϴ�.");
				}else {
					System.out.println("---------------------------");
					System.out.println("��ȣ\t�̸�\t�ּ�\t����");
					for (int i = 0; i < namelist.length; i++) {
						
						if(namelist[i]!=null) {
							System.out.println((index + i) + "\t" + namelist[i] + "\t" 
												+ addrlist[i] + "\t" + agelist[i]);
						}else {
							i= namelist.length;
						}//if~else
					}//for
					System.out.println("---------------------------");
				}//if~else
			}else if (menu == 3) {
				System.out.println("�˻��� �̸��� �Է��ϼ���");
				String searchName = scanner.next();
				String sName = new String();
				String saddr = new String();
				int age = 0;
				
				if(namelist[0]==null) {
					System.out.println("ȸ������� �Ǿ����� �ʽ��ϴ�\n����� �ʿ��մϴ�.");
				} else {
					System.out.println("---------------------------");
					System.out.println("��ȣ\t�̸�\t�ּ�\t����");
					for (int i = 0; i < namelist.length; i++) {

						if (namelist[i] != null) {
							System.out.println((searchIndex) + "\t" + 
										sName + "\t" + saddr + "\t" + age);
						} else {
							i = namelist.length;
						} // if~else
					} // for
					System.out.println("---------------------------");
				}//if~else
			}else if (menu == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				flag =false;
			}else {
				System.out.println("�޴��� ���� �����Դϴ� \n �ٽ� �������ּ���.");
			}
			
			
		}//while
		
	}//main

}//class
