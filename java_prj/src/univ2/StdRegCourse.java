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
 * 상단테이블 하단테이블에서 데이터이동시 테이블에 포커싱해주기
 *  4/1 정보검색후 전체검색시 하단테이블로빠진 데이터까지 같이 들어오는 문제(중복데이터) -->완료 (상위프레임에서 두번 실행하는문제)
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
 *  4/3 15학점미만 9학점이상의 조건성립시 수강신청
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
 * @author dksck
 */
public class StdRegCourse extends JPanel{
	public static  Vector<String> COLNAMES =new Vector<String>();	
	public static final Vector<String>COLNAMES2 = new Vector<String>();	
	// Field
		JPanel topPane,bottomPane;
		JScrollPane coursePane,myCoursePane;
		JPanel titlePane,myTitlePane;
		JPanel searchPane,btnPane;
		JLabel jl_title, jl_mytitle;
		JTable table,myTable;
		JTextField jtf_search;
		JButton btn_reg,btn_del,btn_allDel,btn_myCourse; 
		JButton btn_search,btn_allSearch;
		JComboBox<String> jcb_search;
		DefaultTableModel data,myData;
		StdRegCourseDAO dao;
		Vector<Vector<String>> list;
<<<<<<< Upstream, based on origin/master
		Object DupliDataNO = null;
		String uid= StdUI.uid;
=======
<<<<<<< HEAD
		StdVO stdVo ;StdDAO stdDao; String term;
		String uid = StdUI.uid;
//		StdMyRegCourse myList;
=======
		Object DupliDataNO = null;
		String uid= StdUI.uid;
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
		
		//@0318 수강신청
		// Constructor
		public StdRegCourse() {
			//COLUMN에 데이터 추가
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
//			start();
		}
		public StdRegCourse(StdVO stdVo,StdDAO stdDao) {
			this.stdVo =stdVo;
			this.stdDao = stdDao;
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
			start();
		}
//		public StdRegCourse(Vector<String> COLNAMES) {
////			for(String str : COLNAMES) {
////				System.out.print("3.수강신청 생성자에서 객체 가져왔을때"+str + "\t\n");
////			}
//			this.COLNAMES = COLNAMES;
//			start();
//		}

		// Method
		public void start() {
		// default set
//			setTitle("수강신청");
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
		// 객체 생성
		// object create @@ DefaultTableModel -->메소드로 실행하여 객체생성
		/** table객체도DefaultTableModel 생성후 진행 **/
			topPane = new JPanel();
			bottomPane = new JPanel();
			titlePane = new JPanel();
			myTitlePane = new JPanel();
			searchPane = new JPanel();
			btnPane = new JPanel();
			jl_title = new JLabel("과목조회");
			jl_mytitle = new JLabel("수강 신청 내역");
			//버튼패널에 들어갈 컴포넌트
			btn_reg = new JButton("수강신청");
			btn_del = new JButton("삭제");
			btn_allDel = new JButton("전체삭제");
			btn_myCourse = new JButton("나의수강정보");
			//검색패널에 들어갈 컴포넌트
			jcb_search = new JComboBox<String>();
			jtf_search = new JTextField(15);
			btn_search = new JButton("검색");
			btn_allSearch = new JButton("전체검색");
			dao = new StdRegCourseDAO();
			//객체생성(테이블 모델,스크롤팬)
			table = new JTable();
			myTable = new JTable();
			coursePane=new JScrollPane();
			myCoursePane = new JScrollPane();
			
			//콤보박스에 리스트 추가
			jcb_search.addItem("과목번호");
			jcb_search.addItem("과목");
			jcb_search.addItem("담당교수");
			
			setVectorColumn();
//			for(String str : COLNAMES2) {
//				System.out.println(str+ "\t");
//			}
			// table 수정 불가 및 표에 들어갈 데이터들.. 테이블 열 생성(table)
			this.setEditable(0);
			
			list = dao.getResultVector();
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
			
			//폰트 적용
			jl_title.setFont(StdUI.TITLEFONT); jl_mytitle.setFont(StdUI.TITLEFONT);
			btn_reg.setFont(StdUI.FONT); btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT); btn_myCourse.setFont(StdUI.FONT);
			btn_search.setFont(StdUI.FONT);btn_allSearch.setFont(StdUI.FONT);
			//디자인 레이블에 border 작업주기
			jl_title.setLayout(new BorderLayout());
			jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			jl_mytitle.setLayout(new BorderLayout());
			jl_mytitle.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j테이블에 데이터 부착 jtable.add(model) 이 부착이 안됨 -->setModel로 가능

			table.setModel(data);
			myTable.setModel(myData);
			coursePane.setViewportView(table);
			myCoursePane.setViewportView(myTable);
			
			//패널에 컴포넌트 부착 !! 패널안에 패널넣을때 패널의 레이아웃 지정안해주면 나중에 레아아웃이 생각한데로 나오지않음
			titlePane.setLayout(new BorderLayout());
			myTitlePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().NORTH);myTitlePane.add(jl_mytitle,new BorderLayout().NORTH);
			titlePane.add(coursePane,new BorderLayout().CENTER);myTitlePane.add(myCoursePane,new BorderLayout().CENTER);
			//버튼패널
			btnPane.add(btn_reg);btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_myCourse);
			//검색리스트 버튼패널
			searchPane.add(jcb_search);searchPane.add(jtf_search);
			searchPane.add(btn_search);searchPane.add(btn_allSearch);
			
			//박스레이아웃으로 패널을 박스레이아웃형태로 담기                     //매개변수 부착점을 지정하고setLayout으로 또 설정해줘야되는게 이상하지만 구글링결과 이렇게사용카더라...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //박스레이아웃 매개변수(부착될 패널, 중심축)
			BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
//			BoxLayout boxLayout3 = new BoxLayout(btnPane, BoxLayout.X_AXIS);
			topPane.setLayout(boxLayout);
			bottomPane.setLayout(boxLayout2);
			//패널을 상단과 하단으로 나눠서 붙이기
//			topPane.setLayout(new BorderLayout());
			topPane.add(searchPane);
			topPane.add(titlePane);
			bottomPane.add(myTitlePane);
			bottomPane.add(btnPane);

			//Panel에 최종 패널 붙이기
			this.setLayout(new GridLayout(2,1));
			
			add(topPane);
			add(bottomPane);
			// JFrame visible
			setSize(500, 600);
			setVisible(true);
			// 프레임 중앙에 놓기
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
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
			btn_reg.addActionListener(eventObj);
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
			btn_allDel.addActionListener(eventObj);
			btn_del.addActionListener(eventObj);
			jtf_search.addActionListener(eventObj);
			btn_myCourse.addActionListener(eventObj);
		}
		//컬럼명 설정
		public void setVectorColumn() {
			COLNAMES.add("과목번호");
			COLNAMES.add("과목이름");
			COLNAMES.add("학점");
			COLNAMES.add("담당교수");
		}
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
		
>>>>>>> 85ee785 @rebase
		//새로운 전체데이터 가져오기
		public Vector<Vector<String>> getNewDataSource() {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
<<<<<<< Upstream, based on origin/master
			list = dao.getResultVector();
=======
			list = dao.getVectorList(term);
=======
		//새로운 전체데이터 가져오기
		public Vector<Vector<String>> getNewDataSource() {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			list = dao.getResultVector();
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
			return list;
		}
		
		// inner class
		class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {
			//field
			Object mouseObj;
			public void windowClosing(WindowEvent we) {
				System.out.println("종료");
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if (obj == btn_search || obj == jtf_search) {
					int item = jcb_search.getSelectedIndex();
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>(); //임시데이터
					if (item == 0) {// 과목번호
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND Q.SUBNO = ?";
						if (vaildationCheck() == 1) { //유효성검사후 데이터 가져오기
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
<<<<<<< Upstream, based on origin/master
								
=======
<<<<<<< HEAD
=======
								
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
						}
					}else if(item ==1) { //과목
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND SUB.SUBNAME = ?";
						if (vaildationCheck() == 1) { //유효성검사후 데이터 가져오기
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
						}
					}else if(item ==2 ) {//담당교수
						String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
								" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
								" WHERE Q.SUBNO = SUB.SUBNO AND PNAME = ?";
						if (vaildationCheck() == 1) { //유효성검사후 데이터 가져오기
							Vector<Vector<String>> searchData = replaceRow(sql);
							if (searchData.size() != 0) {
								data.setDataVector(searchData, COLNAMES);
							} else if (searchData.size() == 0) {
								JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
								data.setDataVector(tempDataes, COLNAMES);
							}
						} else {
							JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
						}
					}
				}else if(obj ==btn_allSearch) { //전체검색기능
					data.setDataVector(getNewDataSource(), COLNAMES);
				}else if (obj == btn_myCourse) {
<<<<<<< Upstream, based on origin/master
					new StdMyRegCourse(uid);
=======
<<<<<<< HEAD
					 new StdMyRegCourse(uid,COLNAMES);
>>>>>>> 85ee785 @rebase
				}else if (obj ==btn_del) { //하단테이블 삭제
					int mt_row = myTable.getSelectedRow();
					myData.removeRow(mt_row);
					table.clearSelection(); // 하나클릭시 선택해제
					myTable.clearSelection();
				}else if (obj == btn_allDel) { //하단테이블 전체삭제
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();
					myData.setDataVector(tempDataes, COLNAMES);
<<<<<<< Upstream, based on origin/master
=======
				}else if(obj == btn_reg) {
					Vector<String> subjectNO = new Vector<String>();
					int row = myData.getRowCount();
					for(int i=0;i<row;i++) {
						subjectNO.add((String)myData.getValueAt(i, 0));
					}
					int notDuplicate = getMyRegCourseCrdit();
					
					System.out.println("중복체크"+notDuplicate);
					if(notDuplicate < 15) {
						int result =dao.getRegInsert(uid, subjectNO);
						if(result == 1) JOptionPane.showMessageDialog(null, "수강신청 완료");
						else JOptionPane.showMessageDialog(null, "수강신청 오류");
					}else {
						JOptionPane.showMessageDialog(null, "이미 15학점 이상 수강신청하였습니다");
					}
=======
					new StdMyRegCourse(uid);
				}else if (obj ==btn_del) { //하단테이블 삭제
					int mt_row = myTable.getSelectedRow();
					myData.removeRow(mt_row);
					table.clearSelection(); // 하나클릭시 선택해제
					myTable.clearSelection();
				}else if (obj == btn_allDel) { //하단테이블 전체삭제
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();
					myData.setDataVector(tempDataes, COLNAMES);
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
				}
			}

			// mouseListener
			@Override
			//mouse double 클릭에 넣어놔야함
			public void mouseClicked(MouseEvent me) {
				mouseObj = me.getSource();
				
				if(me.getClickCount() == 2) {
					JTable jtobj = (JTable) mouseObj;
<<<<<<< Upstream, based on origin/master
					Vector<Object> vo = new Vector<Object>();
=======
<<<<<<< HEAD
					Vector<Object> vo ;
=======
					Vector<Object> vo = new Vector<Object>();
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
					int click_row = jtobj.getSelectedRow();
					int ta_row = table.getSelectedRow();
					
					if( mouseObj == table ) { //주소검색 0331 마우스클릭시 이방법이 좀더 좋은거같아(adminInfo보다)
						if (click_row == ta_row) {//두개를나눈이유는 상단테이블 클릭시 하단이랑 같이눌려서
							if(myData.getRowCount()<5) { //유효성체크
								for (int i = 0; i < 4; i++) {
									vo.add(data.getValueAt(click_row, i));
								}
								//상위테이블의 컬럼이 중복되는 문제
								String topNo= (String)data.getValueAt(click_row, 0);
								int myDataRowCount =myData.getRowCount();
								System.out.println("mydata의 로우수"+myDataRowCount);
								Vector<String>tempVO = new Vector<String>();
								boolean flag =true;
								if(myDataRowCount != 0) {
									for(int i =0 ; i<myDataRowCount;i++) {
										String myDataNO=(String)myData.getValueAt(i,0);
										if(myDataNO!=null){
											System.out.println("myData에있는 학번"+myDataNO);
											tempVO.add(myDataNO);
										}
									}
								}else {
									tempVO.add("0000");
								}
<<<<<<< HEAD

								for(String str:tempVO) {
									System.out.println("임시데이터 vo넣어둔 str"+str);
									if(!topNo.equals(str)) {
										flag =true;
									}else{
										JOptionPane.showMessageDialog(null, "오류");
										flag = false;
									}
								}
								if(flag=true) {
									myData.addRow(vo);
									data.removeRow(click_row);
									table.clearSelection(); // 하나클릭시 선택해제
									myTable.clearSelection();
								}
<<<<<<< Upstream, based on origin/master

=======
=======
								//상위테이블의 컬럼이 중복되는 문제
								String topNo= (String)data.getValueAt(click_row, 0);
								int myDataRowCount =myData.getRowCount();
								System.out.println("mydata의 로우수"+myDataRowCount);
								Vector<String>tempVO = new Vector<String>();
								boolean flag =true;
								if(myDataRowCount != 0) {
									for(int i =0 ; i<myDataRowCount;i++) {
										String myDataNO=(String)myData.getValueAt(i,0);
										if(myDataNO!=null){
											System.out.println("myData에있는 학번"+myDataNO);
											tempVO.add(myDataNO);
										}
									}
								}else {
									tempVO.add("0000");
								}

								for(String str:tempVO) {
									System.out.println("임시데이터 vo넣어둔 str"+str);
									if(!topNo.equals(str)) {
										flag =true;
									}else{
										JOptionPane.showMessageDialog(null, "오류");
										flag = false;
									}
								}
								if(flag=true) {
									myData.addRow(vo);
									data.removeRow(click_row);
									table.clearSelection(); // 하나클릭시 선택해제
									myTable.clearSelection();
								}

>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
							}else {
								JOptionPane.showMessageDialog(null, "15학점이상 수강하실수 없습니다");
							}//else if
						}//if
					}else if( mouseObj == myTable ) { //하단테이블을 눌르면 빼지고 위에테이블에 생기는구조로
						int mt_row = myTable.getSelectedRow();
						if (click_row == mt_row) {
							System.out.println("하단테이블의"+click_row + " 째가 눌렸습니다");
							for (int i = 0; i < 4; i++) {
								vo.add(myData.getValueAt(click_row, i));
							}
							data.addRow(vo);
							myData.removeRow(click_row);
							myTable.clearSelection();
							table.clearSelection();
						}//if
					}//if~else
				}//if_더블클릭
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
			//수강신청 탭 수정 불가
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
			//나의 수강신청 목록 수정 불가
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
		// 유효성검사
		public int vaildationCheck() {
			int result = 1;
			if (jtf_search.getText().equals("")) {
				result = 0;
			}
			return result;
		}

		// 검색기능에따라 다른 테이블보여주기
		public Vector<Vector<String>> replaceRow(String sql) {

			String where = jtf_search.getText();
			Vector<Vector<String>> searchlist = dao.getResultVector(sql, where);

			return searchlist;
		}
	}

