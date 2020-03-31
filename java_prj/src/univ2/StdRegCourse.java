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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class StdRegCourse extends JPanel{
		// Field
//		JPanel jp_search;
//		Font font = new Font("맑은 고딕", Font.BOLD, 12);
//		Font titleFont = new Font("맑은 고딕", Font.BOLD, 16);
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
		public static final Vector<String>COLUMNS = new Vector<String>();
		//@0318 수강신청
		// Constructor
		public StdRegCourse() {
			start();
		}

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
			//콤보박스에 리스트 추가
			jcb_search.addItem("과목번호");
			jcb_search.addItem("과목");
			//COLUMN에 데이터 추가
			setVectorColumn();
			
			// 표에 들어갈 데이터들.. 테이블 열 생성(table)
			// table 수정 불가
			this.setEditable(0);
			this.setEditable(0);
			
			Vector<Vector<String>> list = dao.getResultVector();
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}
//			data.addRow(rowData);
//			data.addRow(rowData2);
//			myData.addRow(rowData);
//			myData.addRow(rowData2);
			//
			//폰트 적용
			jl_title.setFont(StdUI.TITLEFONT); jl_mytitle.setFont(StdUI.TITLEFONT);
			btn_reg.setFont(StdUI.FONT); btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT); btn_myCourse.setFont(StdUI.FONT);
			btn_search.setFont(StdUI.FONT);btn_allSearch.setFont(StdUI.FONT);
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
			jtf_search.addActionListener(eventObj);
			btn_myCourse.addActionListener(eventObj);
		}
		public void setVectorColumn() {
			COLUMNS.add("과목번호");
			COLUMNS.add("과목이름");
			COLUMNS.add("학점");
			COLUMNS.add("담당교수");
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
				if (obj == btn_search || obj == jtf_search) {
					System.out.println("검색기능");
				}else if(obj ==btn_allSearch) {
					System.out.println("전체검색기능");
				}else if (obj == btn_myCourse) {
					new StdMyRegCourse();
				}
			}

			// mouseListener
			@Override
			//mouse double 클릭에 넣어놔야함
			public void mouseClicked(MouseEvent me) {
				Object obj = me.getSource();
				JTable jtobj = (JTable) obj;
				int click_row = jtobj.getSelectedRow();
				
				int ta_row = table.getSelectedRow();
				if( obj == table ) { //주소검색 0331 마우스클릭시 이방법이 좀더 좋은거같아(adminInfo보다)
					if (click_row == ta_row) {
						System.out.println("상단테이블의"+ click_row + " 째가 눌렸습니다");
						data.removeRow(click_row);
						Vector<Object> vo = new Vector<Object>();
						
						for(int i=0 ;i<4;i++ ) {
							vo.add(data.getValueAt(click_row, i));
						}
						myData.addRow(vo);
						table.clearSelection(); //하나클릭시 선택해제
						myTable.clearSelection();
					}
				}else if( obj == myTable ) {
					int mt_row = myTable.getSelectedRow();
					if (click_row == mt_row) {
						System.out.println("하단테이블의"+click_row + " 째가 눌렸습니다");
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
		public void setEditable(int zero) {
			
			//수강신청 탭 수정 불가
			data = new DefaultTableModel(COLUMNS, 0) {
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
			myData= new DefaultTableModel(COLUMNS, 0) {
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

