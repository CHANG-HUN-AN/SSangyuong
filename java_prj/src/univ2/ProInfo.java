package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProInfo extends JPanel {
	String pid;
	// Field
	JPanel topPane, titlePane,subjectPane, jp_search;
	JLabel jl_title;
	JTabbedPane adminPane;
	JLabel jl_search;
	JComboBox<String> jcb_search;
	JComboBox<String> jcb_subject;
	JTextField jt_search;
	JButton btn_search, btn_AllList;
	JScrollPane sp_stdInfo;
	JTable table;
	DefaultTableModel model;
	ProInfoDAO dao;
	Vector<Vector<String>> list;
	static Vector<String> VCOLNAMES=new Vector<String>();
	
	// Constructor
	public ProInfo() {
		start();
	}
	public ProInfo(String pid) {
		this.pid = pid;
		start();
	}

	// Method
	public void start() {
		// default set
//		setTitle("회원 명단 관리 프로그램");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);		
//		setAlwaysOnTop(true);
		UIset uiset = new UIset();
		setVectorColumn();
		// object create
		topPane = new JPanel();
		subjectPane = new JPanel();
		titlePane = new JPanel();
		jl_title = new JLabel("학생정보관리");
		jp_search = new JPanel();
		jl_search = new JLabel("검색>");
		jcb_search = new JComboBox<String>();
		jt_search = new JTextField(20);
		btn_search = new JButton("검색");
		btn_AllList = new JButton("전체목록");
		jcb_subject = new JComboBox<String>();
		dao = new ProInfoDAO();
		

		// 폰트 셋팅
		jl_search.setFont(ProUI.FONT);
		jcb_search.setFont(ProUI.FONT);
		jt_search.setFont(ProUI.FONT);
		btn_search.setFont(ProUI.FONT);
		btn_AllList.setFont(ProUI.FONT);
		// title에 border넣기
//		titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		// 표에 들어갈 데이터들.. 테이블 열 생성(table)
		// table 수정 불가
		this.setEditable(VCOLNAMES, 0);

		// 데이터베이스 연동
		list = dao.getResultVectorList(pid);
		for (Vector<String> vo : list) {
			model.addRow(vo); // vector 형태를 열로 다 받아드릴수있다.(이중포문을 사용할필요가 없다)
		}
		//
		table = new JTable(model);
		sp_stdInfo = new JScrollPane(table); // scrollPanel add table;
		// 콤보박스 목록 추가
		jcb_search.addItem("학번");
		jcb_search.addItem("이름");
		jcb_search.addItem("학과");
	
		//임시 콤보박스
		ArrayList<String> tempItem = new ArrayList<String>();
		tempItem.add("데이터베이스");
		tempItem.add("과목2");
		tempItem.add("과목3");
		for(String str:tempItem) {
			jcb_subject.addItem(str);
		}
		
		//패널에 과목콤보박스추가
		subjectPane.add(jcb_subject);
		// 검색패널에 부가적인거 추가
		jp_search.add(jl_search);
		jp_search.add(jcb_search);
		jp_search.add(jt_search);
		jp_search.add(btn_search);
		jp_search.add(btn_AllList);
		// 박스레이아웃으로 감싸기
		BoxLayout boxLayout = new BoxLayout(topPane, BoxLayout.Y_AXIS);
		topPane.setLayout(boxLayout);

		// 클래스를 별도로만들어서 title디자인 통합
		titlePane = (JPanel) uiset.title(titlePane,subjectPane ,jl_title);
		
		topPane.add(titlePane);
		topPane.add(sp_stdInfo);
		
		add(topPane, new BorderLayout().CENTER);
		add(jp_search);
		
		//컬럼 이동제한
		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
		table.setDragEnabled(false);
		// JFrame visible
		setSize(600, 600);
		setVisible(true);
		// location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
		//리스너 메소드(이벤트객체)
		MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
		table.addMouseListener(eventObj);
		btn_search.addActionListener(eventObj);
		btn_AllList.addActionListener(eventObj);
		jt_search.addActionListener(eventObj);
	}

	// 내부객체->이벤트객체
	class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {

		public void windowClosing(WindowEvent we) {
			System.out.println("종료");
			System.exit(0);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();

			if (obj == btn_search || obj == jt_search) {
				int item = jcb_search.getSelectedIndex();
				// 검색결과 없을시 보여주는 깡통데이터
				Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();

				if (item == 0) {// 학번
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND STDNO = ? ";
					// vector<StudentVo>형태로 데이터 표출이안되서 -->2차원배열 Vector<Vector<String>>형으로 다시 넣어줌
					Vector<Vector<String>> searchData = replaceRow(sql);
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
					}
				} else if (item == 1) {// 이름
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND SNAME = ?";
					// vector<StudentVo>형태로 데이터 표출이안되서 -->2차원배열 Vector<Vector<String>>형으로 다시 넣어줌
					Vector<Vector<String>> searchData = replaceRow(sql);
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
					}
				} else if (item == 2) {// 학과
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND MAJ.MNAME = ?";
					// vector<StudentVo>형태로 데이터 표출이안되서 -->2차원배열 Vector<Vector<String>>형으로 다시 넣어줌
					Vector<Vector<String>> searchData = replaceRow(sql);
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
					}
				} else {
					System.out.println("항목오류");
				}
			} else if (obj == btn_AllList) {
				model.setDataVector(list, VCOLNAMES);
			}
		}

		// mouseListener
		@Override
		public void mouseClicked(MouseEvent me) {
			Object obj = me.getSource();
			JTable jtobj = (JTable) obj;
			int erow = jtobj.getSelectedRow();
			int row = table.getSelectedRow();
			System.out.println(erow);
			System.out.println(row);
			if(me.getClickCount()==2) {
				if (erow == row) {
					Object detailData = table.getValueAt(row, 0);
					new ProInfoList(detailData,dao);
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
	public void setEditable(Vector<String> colNames, int zero) {
		model = new DefaultTableModel(colNames, 0) {
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
	//컬럼가져오기
	public void setVectorColumn() {
		VCOLNAMES.add("학번");
		VCOLNAMES.add("이름");
		VCOLNAMES.add("학과");
		VCOLNAMES.add("성별");
		VCOLNAMES.add("생년월일");
	}
	//검색의 조건별로 list다르게 가져오기
	public Vector<Vector<String>> replaceRow(String sql) {

		String where = jt_search.getText().trim();
		Vector<Vector<String>> searchlist = dao.getResultVOList(sql, where);

		return searchlist;
	}

	// 유효성검사
	public int vaildationCheck() {
		int result = 1;
		if (jt_search.getText().equals("")) {
			result = 0;
		}
		return result;
	}
}
