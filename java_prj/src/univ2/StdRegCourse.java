package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class StdRegCourse extends JPanel{
		// Field
//		JPanel jp_search;
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 16);
		JPanel topPane,bottomPane;
		JScrollPane coursePane,myCoursePane;
		JPanel titlePane,myTitlePane;
		JLabel jl_title, jl_mytitle;
		JTable table,myTable;
		DefaultTableModel data,myData;

		//@0318 수강신청
		// Constructor
		public StdRegCourse() {
			start();
		}

		// Method
		public void start() {
			// default set
//			setTitle("회원 명단 관리 프로그램");
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
			//객체 생성
			// object create @@ DefaultTableModel -->메소드로 실행하여 객체생성
			/** table객체도DefaultTableModel 생성후 진행**/
			 topPane = new JPanel(); bottomPane = new JPanel();
			 titlePane= new JPanel();myTitlePane = new JPanel();
			 jl_title=  new JLabel("수강신청"); jl_mytitle = new JLabel("나의 수강신청 목록");
			
			// 표에 들어갈 데이터들.. 테이블 열 생성(table)
			String[] colNames = new String[] { "과목번호", "과목이름", "학점", "담당교수" };
			// table 수정 불가
			this.setEditable(colNames, 0);
			this.setEditable(colNames,0);
			// delete 차후 삭제(임시데이터)
			String[] rowData = new String[] { "1", "데이터베이스", "2",  "이비자" };
			String[] rowData2 = new String[] { "2", "자바기초", "2",  "차미리" };
			data.addRow(rowData);
			data.addRow(rowData2);
			myData.addRow(rowData);
			myData.addRow(rowData2);
			//
			//폰트 적용
			jl_title.setFont(titleFont);
			jl_mytitle.setFont(titleFont);
			//디자인 레이블에 border 작업주기
			jl_title.setLayout(new BorderLayout());
			jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			jl_mytitle.setLayout(new BorderLayout());
			jl_mytitle.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j테이블에 데이터 부착 jtable.add(model) 이 부착이 안됨 
			//JScrollPane 역시 초기화시 붙여줘야함
			table = new JTable(data);
			myTable = new JTable(myData);
			coursePane=new JScrollPane(table);
			myCoursePane = new JScrollPane(myTable);
			
			//패널에 컴포넌트 부착 !! 패널안에 패널넣을때 패널의 레이아웃 지정안해주면 나중에 풀린다
			titlePane.setLayout(new BorderLayout());
			myTitlePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().NORTH);myTitlePane.add(jl_mytitle,new BorderLayout().NORTH);
			titlePane.add(coursePane,new BorderLayout().CENTER);myTitlePane.add(myCoursePane,new BorderLayout().CENTER);

			//박스레이아웃으로 패널을 박스레이아웃형태로 담기                     //매개변수 부착점을 지정하고setLayout으로 또 설정해줘야되는게 이상하지만 구글링결과 이렇게사용카더라...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //박스레이아웃 매개변수(부착될 패널, 중심축)
			BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
			topPane.setLayout(boxLayout);
			bottomPane.setLayout(boxLayout2);
			//패널을 상단과 하단으로 나눠서 붙이기
			topPane.add(titlePane);
			bottomPane.add(myTitlePane);
			// this 에 최종 패널 붙이기
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
		}

		// inner class
		class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {

			public void windowClosing(WindowEvent we) {
				System.out.println("종료");
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
//				if (obj == btn_search || obj == jt_search) {
//					System.out.println("검색기능");
//				}
			}

			// mouseListener
			@Override
			public void mouseClicked(MouseEvent me) {
				Object obj = me.getSource();
				JTable jtobj = (JTable) obj;
				int erow = jtobj.getSelectedRow();
				
				if( obj == table ) {
					int ta_row = table.getSelectedRow();
					if (erow == ta_row) {
						System.out.println("상단테이블의"+erow + " 째가 눌렸습니다");
						table.clearSelection();
						myTable.clearSelection();
					}
				}else if( obj == myTable ) {
					int mt_row = myTable.getSelectedRow();
					if (erow == mt_row) {
						System.out.println("하단테이블의"+erow + " 째가 눌렸습니다");
						myTable.clearSelection();
						table.clearSelection();
					}
				}
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		}

		// Method
		public void setEditable(String colNames[], int zero) {
			
			//수강신청 탭 수정 불가
			data = new DefaultTableModel(colNames, 0) {
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
			myData= new DefaultTableModel(colNames, 0) {
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
	}

