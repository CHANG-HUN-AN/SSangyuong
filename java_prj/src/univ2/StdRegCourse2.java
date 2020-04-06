package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;


/**
 * ������̺� �ϴ����̺����� �������̵��� ���̺��� ��Ŀ�����ֱ�
 *  4/1 �����˻��� ��ü�˻��� �ϴ����̺��κ��� �����ͱ��� ���� ������ ����(�ߺ�������) -->�Ϸ� (���������ӿ��� �ι� �����ϴ¹���)
 *  4/3 15�����̸� 9�����̻��� ���Ǽ����� ������û
 * @author dksck
 */
public class StdRegCourse2 extends JPanel{
	public static  Vector<String> COLNAMES =new Vector<String>();	
	public static final Vector<String>COLNAMES2 = new Vector<String>();	
	// Field
		JPanel topPane,bottomPane;
		JScrollPane coursePane,myCoursePane;
		JPanel titlePane,myTitlePane;
		JPanel tablePane,myTablePane;
		JPanel searchPane,btnPane;
		JPanel creditPane;
		JLabel jl_title, jl_mytitle;
		JLabel jl_credit;
		JTextField jtf_credit;
		JTable table,myTable;
		JTextField jtf_search;
		JButton btn_reg,btn_del,btn_allDel,btn_myCourse; 
		JButton btn_search,btn_allSearch;
		JComboBox<String> jcb_search;
		DefaultTableModel data,myData;
		StdRegCourseDAO dao;
		Vector<Vector<String>> list;
		StdVO stdVo ;StdDAO stdDao; String term;
		String uid = StdUI.uid;
		
//		int row = 0;
//		int creditCount =0;
//		StdMyRegCourse myList;
		
		//�б⿡ �°� ����Ʈ����ϱ����� ���� ��ü
//		StdVO stdVo ;
//		StdDAO stdDao ;
//		String term ;
		//@0318 ������û
		// Constructor
		public StdRegCourse2() {
			//COLUMN�� ������ �߰�
//			start();
		}
		public StdRegCourse2(StdVO stdVo,StdDAO stdDao) {
			this.stdVo =stdVo;
			this.stdDao = stdDao;
			start();
		}
//		public StdRegCourse(Vector<String> COLNAMES) {
////			for(String str : COLNAMES) {
////				System.out.print("3.������û �����ڿ��� ��ü ����������"+str + "\t\n");
////			}
//			this.COLNAMES = COLNAMES;
//			start();
//		}

		// Method
		public void start() {
		// default set
//			setTitle("������û");
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
		// ��ü ����
		// object create @@ DefaultTableModel -->�޼ҵ�� �����Ͽ� ��ü����
		/** table��ü��DefaultTableModel ������ ���� **/
			topPane = new JPanel();
			bottomPane = new JPanel();
			titlePane = new JPanel();
			tablePane = new JPanel();
			myTitlePane = new JPanel();
			myTablePane = new JPanel();
			searchPane = new JPanel();
			btnPane = new JPanel();
			jl_title = new JLabel("������ȸ");
			jl_mytitle = new JLabel("���� ��û ����");
			//��ư�гο� �� ������Ʈ
			btn_reg = new JButton("������û");
			btn_del = new JButton("����");
			btn_allDel = new JButton("��ü����");
			btn_myCourse = new JButton("���Ǽ�������");
			//�˻��гο� �� ������Ʈ
			jcb_search = new JComboBox<String>();
			jtf_search = new JTextField(15);
			btn_search = new JButton("�˻�");
			btn_allSearch = new JButton("��ü�˻�");
			dao = new StdRegCourseDAO();
			//��������гο� �� ������Ʈ
			creditPane = new JPanel();
			jl_credit = new JLabel("���� > ");
			jtf_credit = new JTextField(5);
			//��ü����(���̺� ��,��ũ����)
			table = new JTable();
			myTable = new JTable();
			coursePane=new JScrollPane();
			myCoursePane = new JScrollPane();
			//�޺��ڽ��� ����Ʈ �߰�
			jcb_search.addItem("�����ȣ");
			jcb_search.addItem("����");
			jcb_search.addItem("��米��");
			
			setVectorColumn();
//			for(String str : COLNAMES2) {
//				System.out.println(str+ "\t");
//			}
			// table ���� �Ұ� �� ǥ�� �� �����͵�.. ���̺� �� ����(table)
			this.setEditable(0);
			term = stdVo.getTerm();
			System.out.println(term);
			list = dao.getVectorList(term);
			
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
			//�ؽ�Ʈ�ʵ� ��������
			jtf_credit.setEditable(false);
			//�÷� �̵�����
			table.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
			table.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�
			table.setDragEnabled(false);
			myTable.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
			myTable.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�
			myTable.setDragEnabled(false);
			//��Ʈ ����
			jl_title.setFont(StdUI.TITLEFONT); jl_mytitle.setFont(StdUI.TITLEFONT);
			btn_reg.setFont(StdUI.FONT); btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT); btn_myCourse.setFont(StdUI.FONT);
			btn_search.setFont(StdUI.FONT);btn_allSearch.setFont(StdUI.FONT);
			//������ ���̺��� border �۾��ֱ�
			titlePane.setLayout(new BorderLayout());
			titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			myTitlePane.setLayout(new BorderLayout());
			myTitlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j���̺��� �����͸� ���� jtable.add(model) �� ������ �ȵ� 
			//-->0406 )setModel�� ����
			table.setModel(data);
			myTable.setModel(myData);
			coursePane.setViewportView(table);
			myCoursePane.setViewportView(myTable);
			
			
			//�гο� ������Ʈ ���� !! 
			//��������� ���� �г�
			creditPane.add(jl_credit);creditPane.add(jtf_credit);
			//�˻�����Ʈ ��ư�г�
			searchPane.add(jcb_search);searchPane.add(jtf_search);
			searchPane.add(btn_search);searchPane.add(btn_allSearch);
			//��ư�г�
			btnPane.add(btn_reg);btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_myCourse);
		
			//�гξȿ� �гγ����� �г��� ���̾ƿ� ���������ָ� ���߿� ���ƾƿ��� �����ѵ��� ����������
			titlePane.setLayout(new BorderLayout());
			myTitlePane.setLayout(new BorderLayout());
			tablePane.setLayout(new BorderLayout());
			myTablePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().WEST); titlePane.add(searchPane,new BorderLayout().EAST);
			myTitlePane.add(jl_mytitle,new BorderLayout().WEST);myTitlePane.add(creditPane,new BorderLayout().EAST);
			tablePane.add(coursePane,new BorderLayout().CENTER);myTablePane.add(myCoursePane,new BorderLayout().CENTER);
			
			//�ڽ����̾ƿ����� �г��� �ڽ����̾ƿ����·� ���                     //�Ű����� �������� �����ϰ�setLayout���� �� ��������ߵǴ°� �̻������� ���۸���� �̷��Ի��ī����...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //�ڽ����̾ƿ� �Ű�����(������ �г�, �߽���)
			BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
//			BoxLayout boxLayout3 = new BoxLayout(btnPane, BoxLayout.X_AXIS);
			topPane.setLayout(boxLayout);
			bottomPane.setLayout(boxLayout2);
			//�г��� ��ܰ� �ϴ����� ������ ���̱�
//			topPane.setLayout(new BorderLayout());
//			topPane.add(searchPane);
			topPane.add(titlePane);
			topPane.add(tablePane);
			bottomPane.add(myTitlePane);
			bottomPane.add(myTablePane);
			bottomPane.add(btnPane);

			//Panel�� ���� �г� ���̱�
			this.setLayout(new GridLayout(2,1));
			
			add(topPane);
			add(bottomPane);
			// JFrame visible
			setSize(500, 600);
			setVisible(true);
			// ������ �߾ӿ� ����
//			Dimension fsize = getSize();
//			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
//			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
//			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
//			setLocation(width, height);
			// eventListener
			MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
//			addWindowListener(eventObj);
			table.addMouseListener(eventObj);
			myTable.addMouseListener(eventObj);
			btn_search.addActionListener(eventObj);
			btn_allSearch.addActionListener(eventObj);
			btn_reg.addActionListener(eventObj);
			btn_allDel.addActionListener(eventObj);
			btn_del.addActionListener(eventObj);
			jtf_search.addActionListener(eventObj);
			btn_myCourse.addActionListener(eventObj);
		}
		//�÷��� ����
		public void setVectorColumn() {
			COLNAMES.add("�����ȣ11");
			COLNAMES.add("�����̸�11");
			COLNAMES.add("����11");
			COLNAMES.add("��米��11");
		}
		
		//���ο� ��ü������ ��������
		public Vector<Vector<String>> getNewDataSource() {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			list = dao.getVectorList(term);
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
			return list;
		}
		
		// inner class
		class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {
			//field
			Object mouseObj;
			int row = 0;
			String creditCount = "0";
			
			public void windowClosing(WindowEvent we) {
				System.out.println("����");
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if (obj == btn_search || obj == jtf_search) {
					int item = jcb_search.getSelectedIndex();
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>(); //�ӽõ�����
					if (item == 0) {// �����ȣ
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND Q.SUBNO = ?";
						if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
						}
					}else if(item ==1) { //����
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND SUB.SUBNAME = ?";
						if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
						}
					}else if(item ==2 ) {//��米��
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND PNAME = ?";
						if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
						}
					}
				}else if(obj ==btn_allSearch) { //��ü�˻����
					data.setDataVector(getNewDataSource(), COLNAMES);
				}else if (obj == btn_myCourse) {
					 new StdMyRegCourse(uid,COLNAMES);
				}else if (obj ==btn_del) { //�ϴ����̺� ����
					int mt_row = myTable.getSelectedRow();
					Vector<Object> vo = getVectoraddRowData(mt_row,data); //������ �������ప���ؼ� ������̺�������
					data.addRow(vo);
					
					myData.removeRow(mt_row);
					table.clearSelection(); // �ϳ�Ŭ���� ��������
					myTable.clearSelection();
				}else if (obj == btn_allDel) { //�ϴ����̺� ��ü����
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();
					Vector<StdRegCourseVO> list ;
					int dataColumCount = myTable.getColumnCount();
					int dataRowCount = myTable.getRowCount();
					
					list = dao.getArrVoList(dataRowCount, myData);
					
					for(StdRegCourseVO vo : list) {
						String subno = vo.getSubno();
						String subname = vo.getSubname();
						String criedit = vo.getCredit();
						String professor = vo.getProfessor();
						String[] tempList = {subno, subname,criedit,professor};
						data.addRow(tempList);
					}
					myData.setDataVector(tempDataes, COLNAMES);
				}else if(obj == btn_reg) {
					Vector<String> subjectNO = new Vector<String>();
					int row = myData.getRowCount();
					for(int i=0;i<row;i++) {
						subjectNO.add((String)myData.getValueAt(i, 0));
					}
					int notDuplicate = getMyRegCourseCrdit();
					
					System.out.println("�ߺ�üũ"+notDuplicate);
					if(notDuplicate < 15) {
						int result =dao.getRegInsert(uid, subjectNO);
						if(result == 1) JOptionPane.showMessageDialog(null, "������û �Ϸ�");
						else JOptionPane.showMessageDialog(null, "������û ����");
					}else {
						JOptionPane.showMessageDialog(null, "�̹� 15���� �̻� ������û�Ͽ����ϴ�");
					}
				}
			}

			// mouseListener
			@Override
			//mouse double Ŭ���� �־������
			public void mouseClicked(MouseEvent me) {
				mouseObj = me.getSource();
				
				if(me.getClickCount() == 2) {
					JTable jtobj = (JTable) mouseObj;
					Vector<Object> vo ;
					int click_row = jtobj.getSelectedRow();
					int ta_row = table.getSelectedRow();
					int dataCloumCount = table.getColumnCount();
					
					if( mouseObj == table ) { //�ּҰ˻� 0331 ���콺Ŭ���� �̹���� ���� �����Ű���(adminInfo����)
						if (click_row == ta_row) {//�ΰ������������� ������̺� Ŭ���� �ϴ��̶� ���̴�����
							if(myData.getRowCount()<5) { //��ȿ��üũ
								vo = getVectoraddRowData(click_row,data);
								//�������̺��� �÷��� �ߺ��Ǵ� ����
								String topNo= (String)data.getValueAt(click_row, 0);
								int myDataRowCount =myData.getRowCount();
								Vector<String>tempVO = new Vector<String>();
								boolean flag =true;
								
								if(myDataRowCount != 0) {
									for(int i =0 ; i<myDataRowCount;i++) {
										String myDataNO=(String)myData.getValueAt(i,0);
										if(myDataNO!=null){
											tempVO.add(myDataNO);
										}
									}
								}else {
									tempVO.add("0000");
								}

								for(String str:tempVO) {
									if(!topNo.equals(str)) {
										flag =true;
									}else{
										JOptionPane.showMessageDialog(null, "����");
										flag = false;
									}
								}
								if(flag=true) {
									myData.addRow(vo);
//									int str = Integer.parseInt((String)myData.getValueAt(row, 2));
//									creditCount += str;
//									System.out.println(creditCount);
									
//									StdRegCourseVO countVO = new StdRegCourseVO();
//									countVO.setCounting("0"); 
									//���� ī����
									this.creditCount = getPlusDataCount(creditCount, row);
									jtf_credit.setText(creditCount);
									data.removeRow(click_row);
									table.clearSelection(); // �ϳ�Ŭ���� ��������
									myTable.clearSelection();
									row++;
								}
							}else {
								JOptionPane.showMessageDialog(null, "15�����̻� �����ϽǼ� �����ϴ�");
							}//else if
						}//if
					}else if( mouseObj == myTable ) { //�ϴ����̺��� ������ ������ �������̺��� ����±�����
						int mt_row = myTable.getSelectedRow();
						if (click_row == mt_row) {
							System.out.println("�ϴ����̺���"+click_row + " °�� ���Ƚ��ϴ�");
							vo = getVectoraddRowData(click_row, myData);
							data.addRow(vo);
							//����ī����
							StdRegCourseVO regVo = new StdRegCourseVO();
							regVo.setCounting((String)myTable.getValueAt(row-1, 2)); // �� -1�� �ٿ��ߵǴ���
							creditCount = getMinusDataCount(creditCount, regVo);
							jtf_credit.setText(creditCount);
							
							myData.removeRow(click_row);
							myTable.clearSelection();
							table.clearSelection();
							row--;
						}//if
					}//if~else
				}//if_����Ŭ��
			} //event MouseClick

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
			
		} //end MgmSystemUIEvent

		// Method
		public void setEditable(int zero) {
			//������û �� ���� �Ұ�
			data = new DefaultTableModel(COLNAMES, zero) {
				@Override
				public boolean isCellEditable(int row, int column) {
					if (column >= 0) {
						return false;
					} else {
						return true;
					}
				}
			};
			//���� ������û ��� ���� �Ұ�
			myData= new DefaultTableModel(COLNAMES, zero) {
				@Override
				public boolean isCellEditable(int row, int column) {
					if (column >= 0) {
						return false;
					} else {
						return true;
					}
				}
			};
		}
		//���������ִ� �ؽ�Ʈ�ʵ� ī����
		//�÷���
		public String getPlusDataCount(String creditCount,int row) {
			int str = Integer.parseInt((String)myData.getValueAt(row, 2));
			System.out.println(creditCount);
			int sumCount =  Integer.parseInt(creditCount);
			sumCount += str;
			System.out.println(sumCount);
			
			return String.valueOf(sumCount);
		}
		//���̳ʽ�
		public String getMinusDataCount(String creditCount,StdRegCourseVO vo) {
			int counting = Integer.parseInt(vo.getCounting());
			int sumCount =  Integer.parseInt(creditCount);
			sumCount -= counting ;
			
			return String.valueOf(sumCount);
		}
		
		// ��ȿ���˻�
		public int vaildationCheck() {
			int result = 1;
			if (jtf_search.getText().equals("")) {
				result = 0;
			}
			return result;
		}

		// �˻���ɿ����� �ٸ� ���̺������ֱ�
		public Vector<Vector<String>> replaceRow(String sql) {

			String where = jtf_search.getText();
			Vector<Vector<String>> searchlist = dao.getVectorList(sql, where);

			return searchlist;
		}
		public int getMyRegCourseCrdit() {
			StdMyRegCourseDAO dao = new StdMyRegCourseDAO(uid); 
			ArrayList<StdRegCourseVO> list = dao.getVoMyRegisterList();
			int MyCourseCredit=0;
			for(StdRegCourseVO vo :list) {
				String credit = vo.credit;
				MyCourseCredit += Integer.parseInt(credit);
			}
			return MyCourseCredit;
		}
		//������ ������̺��� �߰�
		public Vector<Object> getVectoraddRowData(int clickRow,DefaultTableModel data){
			Vector<Object> vo = new Vector<Object>();
			int dataCloumCount = table.getColumnCount();
			for (int i = 0; i < dataCloumCount; i++) {
				vo.add(data.getValueAt(clickRow, i));
			}
			return vo;
		}
	}
