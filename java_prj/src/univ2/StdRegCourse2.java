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
 * 상단테이블 하단테이블에서 데이터이동시 테이블에 포커싱해주기
 *  4/1 정보검색후 전체검색시 하단테이블로빠진 데이터까지 같이 들어오는 문제(중복데이터) -->완료 (상위프레임에서 두번 실행하는문제)
 *  4/3 15학점미만 9학점이상의 조건성립시 수강신청
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
		
		//학기에 맞게 리스트출력하기위해 만든 객체
//		StdVO stdVo ;
//		StdDAO stdDao ;
//		String term ;
		//@0318 수강신청
		// Constructor
		public StdRegCourse2() {
			//COLUMN에 데이터 추가
//			start();
		}
		public StdRegCourse2(StdVO stdVo,StdDAO stdDao) {
			this.stdVo =stdVo;
			this.stdDao = stdDao;
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
			tablePane = new JPanel();
			myTitlePane = new JPanel();
			myTablePane = new JPanel();
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
			//학점계산패널에 들어갈 컴포넌트
			creditPane = new JPanel();
			jl_credit = new JLabel("학점 > ");
			jtf_credit = new JTextField(5);
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
			term = stdVo.getTerm();
			System.out.println(term);
			list = dao.getVectorList(term);
			
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
			//텍스트필드 수정제한
			jtf_credit.setEditable(false);
			//컬럼 이동제한
			table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
			table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
			table.setDragEnabled(false);
			myTable.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
			myTable.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
			myTable.setDragEnabled(false);
			//폰트 적용
			jl_title.setFont(StdUI.TITLEFONT); jl_mytitle.setFont(StdUI.TITLEFONT);
			btn_reg.setFont(StdUI.FONT); btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT); btn_myCourse.setFont(StdUI.FONT);
			btn_search.setFont(StdUI.FONT);btn_allSearch.setFont(StdUI.FONT);
			//디자인 레이블에 border 작업주기
			titlePane.setLayout(new BorderLayout());
			titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			myTitlePane.setLayout(new BorderLayout());
			myTitlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j테이블에 데이터모델 부착 jtable.add(model) 이 부착이 안됨 
			//-->0406 )setModel로 가능
			table.setModel(data);
			myTable.setModel(myData);
			coursePane.setViewportView(table);
			myCoursePane.setViewportView(myTable);
			
			
			//패널에 컴포넌트 부착 !! 
			//학점계산을 위한 패널
			creditPane.add(jl_credit);creditPane.add(jtf_credit);
			//검색리스트 버튼패널
			searchPane.add(jcb_search);searchPane.add(jtf_search);
			searchPane.add(btn_search);searchPane.add(btn_allSearch);
			//버튼패널
			btnPane.add(btn_reg);btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_myCourse);
		
			//패널안에 패널넣을때 패널의 레이아웃 지정안해주면 나중에 레아아웃이 생각한데로 나오지않음
			titlePane.setLayout(new BorderLayout());
			myTitlePane.setLayout(new BorderLayout());
			tablePane.setLayout(new BorderLayout());
			myTablePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().WEST); titlePane.add(searchPane,new BorderLayout().EAST);
			myTitlePane.add(jl_mytitle,new BorderLayout().WEST);myTitlePane.add(creditPane,new BorderLayout().EAST);
			tablePane.add(coursePane,new BorderLayout().CENTER);myTablePane.add(myCoursePane,new BorderLayout().CENTER);
			
			//박스레이아웃으로 패널을 박스레이아웃형태로 담기                     //매개변수 부착점을 지정하고setLayout으로 또 설정해줘야되는게 이상하지만 구글링결과 이렇게사용카더라...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //박스레이아웃 매개변수(부착될 패널, 중심축)
			BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
//			BoxLayout boxLayout3 = new BoxLayout(btnPane, BoxLayout.X_AXIS);
			topPane.setLayout(boxLayout);
			bottomPane.setLayout(boxLayout2);
			//패널을 상단과 하단으로 나눠서 붙이기
//			topPane.setLayout(new BorderLayout());
//			topPane.add(searchPane);
			topPane.add(titlePane);
			topPane.add(tablePane);
			bottomPane.add(myTitlePane);
			bottomPane.add(myTablePane);
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
			btn_reg.addActionListener(eventObj);
			btn_allDel.addActionListener(eventObj);
			btn_del.addActionListener(eventObj);
			jtf_search.addActionListener(eventObj);
			btn_myCourse.addActionListener(eventObj);
		}
		//컬럼명 설정
		public void setVectorColumn() {
			COLNAMES.add("과목번호11");
			COLNAMES.add("과목이름11");
			COLNAMES.add("학점11");
			COLNAMES.add("담당교수11");
		}
		
		//새로운 전체데이터 가져오기
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
					 new StdMyRegCourse(uid,COLNAMES);
				}else if (obj ==btn_del) { //하단테이블 삭제
					int mt_row = myTable.getSelectedRow();
					Vector<Object> vo = getVectoraddRowData(mt_row,data); //삭제된 데이터행값구해서 상단테이블에부착
					data.addRow(vo);
					
					myData.removeRow(mt_row);
					table.clearSelection(); // 하나클릭시 선택해제
					myTable.clearSelection();
				}else if (obj == btn_allDel) { //하단테이블 전체삭제
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
					
					System.out.println("중복체크"+notDuplicate);
					if(notDuplicate < 15) {
						int result =dao.getRegInsert(uid, subjectNO);
						if(result == 1) JOptionPane.showMessageDialog(null, "수강신청 완료");
						else JOptionPane.showMessageDialog(null, "수강신청 오류");
					}else {
						JOptionPane.showMessageDialog(null, "이미 15학점 이상 수강신청하였습니다");
					}
				}
			}

			// mouseListener
			@Override
			//mouse double 클릭에 넣어놔야함
			public void mouseClicked(MouseEvent me) {
				mouseObj = me.getSource();
				
				if(me.getClickCount() == 2) {
					JTable jtobj = (JTable) mouseObj;
					Vector<Object> vo ;
					int click_row = jtobj.getSelectedRow();
					int ta_row = table.getSelectedRow();
					int dataCloumCount = table.getColumnCount();
					
					if( mouseObj == table ) { //주소검색 0331 마우스클릭시 이방법이 좀더 좋은거같아(adminInfo보다)
						if (click_row == ta_row) {//두개를나눈이유는 상단테이블 클릭시 하단이랑 같이눌려서
							if(myData.getRowCount()<5) { //유효성체크
								vo = getVectoraddRowData(click_row,data);
								//상위테이블의 컬럼이 중복되는 문제
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
										JOptionPane.showMessageDialog(null, "오류");
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
									//학점 카운팅
									this.creditCount = getPlusDataCount(creditCount, row);
									jtf_credit.setText(creditCount);
									data.removeRow(click_row);
									table.clearSelection(); // 하나클릭시 선택해제
									myTable.clearSelection();
									row++;
								}
							}else {
								JOptionPane.showMessageDialog(null, "15학점이상 수강하실수 없습니다");
							}//else if
						}//if
					}else if( mouseObj == myTable ) { //하단테이블을 눌르면 빼지고 위에테이블에 생기는구조로
						int mt_row = myTable.getSelectedRow();
						if (click_row == mt_row) {
							System.out.println("하단테이블의"+click_row + " 째가 눌렸습니다");
							vo = getVectoraddRowData(click_row, myData);
							data.addRow(vo);
							//학점카운팅
							StdRegCourseVO regVo = new StdRegCourseVO();
							regVo.setCounting((String)myTable.getValueAt(row-1, 2)); // 왜 -1을 붙여야되는지
							creditCount = getMinusDataCount(creditCount, regVo);
							jtf_credit.setText(creditCount);
							
							myData.removeRow(click_row);
							myTable.clearSelection();
							table.clearSelection();
							row--;
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
		//학점보여주는 텍스트필드 카운팅
		//플러스
		public String getPlusDataCount(String creditCount,int row) {
			int str = Integer.parseInt((String)myData.getValueAt(row, 2));
			System.out.println(creditCount);
			int sumCount =  Integer.parseInt(creditCount);
			sumCount += str;
			System.out.println(sumCount);
			
			return String.valueOf(sumCount);
		}
		//마이너스
		public String getMinusDataCount(String creditCount,StdRegCourseVO vo) {
			int counting = Integer.parseInt(vo.getCounting());
			int sumCount =  Integer.parseInt(creditCount);
			sumCount -= counting ;
			
			return String.valueOf(sumCount);
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
		//삭제후 상단테이블에 추가
		public Vector<Object> getVectoraddRowData(int clickRow,DefaultTableModel data){
			Vector<Object> vo = new Vector<Object>();
			int dataCloumCount = table.getColumnCount();
			for (int i = 0; i < dataCloumCount; i++) {
				vo.add(data.getValueAt(clickRow, i));
			}
			return vo;
		}
	}

