package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 0331 나의수강정보가 수강조회프레임을 가려서 오른쪽으로 위치조정--x
 * 0403 dataRowCount 가 없을때 오류
 * @author user
 */
public class StdMyRegCourse extends JFrame{
		// Field
//		JPanel jp_search;
		JPanel topPane;
		JScrollPane coursePane;
		JPanel titlePane,btnPane;
		JLabel jl_title;
		JTable table;
		JButton btn_del,btn_allDel,btn_cancel;
		DefaultTableModel data;
		static Vector<String> COLNAMES = new Vector<String>();
		String uid;
		StdMyRegCourseDAO dao;
		static int MyCourseCredit;
		//@0318 수강신청
		// Constructor
		public StdMyRegCourse() {
		
		}
		public StdMyRegCourse(String uid,Vector<String> COLNAMES) {
			setTitle("나의 수강신청 목록");
			this.uid =uid;
			this.COLNAMES = COLNAMES;
			start();
		}

		// Method
		public void start() {
		// default set
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
		// 객체 생성
		// object create @@ DefaultTableModel -->메소드로 실행하여 객체생성
		/** table객체도DefaultTableModel 생성후 진행 **/
			topPane = new JPanel();
			titlePane = new JPanel();
			btnPane = new JPanel();
			jl_title = new JLabel("나의 수강 정보");
			//버튼패널에 들어갈 컴포넌트
			btn_del = new JButton("삭제");
			btn_allDel = new JButton("전체삭제");
			btn_cancel = new JButton("취소");
			//객체생성가능 차후붙이기 setModel(),setViewPortView()
			table = new JTable();
			coursePane=new JScrollPane();
//			getColNames();
			// 표에 들어갈 데이터들.. 테이블 열 생성(table)
			// table 수정 불가
			
			this.setEditable(0);
			// 본인의 수강신청 리스트 출력
			dao = new StdMyRegCourseDAO(uid); 
			ArrayList<StdRegCourseVO> list = dao.getVoMyRegisterList();
			for(StdRegCourseVO vo :list) {
				String subno= vo.getSubno();
				String subname = vo.getSubname();
				String credit = vo.getCredit();
				String pname = vo.getPname();
				System.out.println("나의수강목록:"+subno+" "+subname+" "+credit+" "+pname);
				String [] tempvo = {subno,subname,credit,pname};
				data.addRow(tempvo);
				MyCourseCredit += Integer.parseInt(credit);
			}
//			Vector<Vector<String>>list = dao.getMyRegisterList();
//			
//			for(Vector<String> vo : list) {
//				System.out.println(vo.size());
//				data.addRow(vo);
//			}
			
			//
			//폰트 적용
			jl_title.setFont(StdUI.TITLEFONT); 
			btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT);btn_cancel.setFont(StdUI.FONT); 
		
			//디자인 레이블에 border 작업주기
			jl_title.setLayout(new BorderLayout());
			jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j테이블에 데이터 부착 jtable.add(model) 이 부착이 안됨 
			//JScrollPane 역시 초기화시 붙여줘야함
			table.setModel(data);
			coursePane.setViewportView(table);
			
			//패널에 컴포넌트 부착 !! 패널안에 패널넣을때 패널의 레이아웃 지정안해주면 나중에 레아아웃이 생각한데로 나오지않음
			titlePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().NORTH);
//			myTitlePane.add(jl_mytitle,new BorderLayout().NORTH);
			titlePane.add(coursePane,new BorderLayout().CENTER);
//			myTitlePane.add(myCoursePane,new BorderLayout().CENTER);
			//버튼패널
			btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_cancel);
			
			//박스레이아웃으로 패널을 박스레이아웃형태로 담기                     //매개변수 부착점을 지정하고setLayout으로 또 설정해줘야되는게 이상하지만 구글링결과 이렇게사용카더라...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //박스레이아웃 매개변수(부착될 패널, 중심축)
			topPane.setLayout(boxLayout);
			//패널을 상단과 하단으로 나눠서 붙이기
//			topPane.setLayout(new BorderLayout());
			topPane.add(titlePane);
			topPane.add(btnPane);

			//Panel에 최종 패널 붙이기
			this.setLayout(new GridLayout(1,1));
			
			add(topPane);
			// JFrame visible
			setSize(500, 600);
			setVisible(true);
		
			// 프레임 중앙에 놓기
			Dimension fsize = getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
			setLocation(width, height);
			// eventListener
			MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
			addWindowListener(eventObj);
			table.addMouseListener(eventObj);
			btn_del.addActionListener(eventObj);
			btn_allDel.addActionListener(eventObj);
			btn_cancel.addActionListener(eventObj);
		}

		
		// inner class
		class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {
			//filed
			String subNo;
			
			public void windowClosing(WindowEvent we) {
				System.out.println("종료");
				dispose();
			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == btn_cancel) {
					System.out.println("종료");
					dispose();
				}else if (obj == btn_del) {//삭제버튼 시 데이터 삭제
					System.out.println("삭제기능"); //confrim yes 0 no 1
					int confirm=JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
					if(confirm == 0) {
						int result = dao.getMyRegDelete(subNo);
						
						setEditable(0);
						getMyListShow();
		 				
						table.setModel(data);
						if(result != 0)  JOptionPane.showMessageDialog(null, "삭제실패");
						else JOptionPane.showMessageDialog(null, "삭제성공");
					}
				}else if (obj == btn_allDel) {
					System.out.println("삭제기능"); //confrim yes 0 no 1
					int confirm=JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
					if(confirm == 0) {
						int result = dao.getMyRegDelete();
						
						setEditable(0);
						getMyListShow();
		 				
						table.setModel(data);
						if(result != 0)JOptionPane.showMessageDialog(null, "전체삭제성공 처음부터 다시 수강신청해주세요"); //성공시 update 한 쿼리수를 가져옴 
						else JOptionPane.showMessageDialog(null, "전체삭제실패");
					}
				}
			}

			// mouseListener
			@Override
			public void mouseClicked(MouseEvent me) {
				Object obj = me.getSource();
				JTable jtobj = (JTable) obj;
				int erow = jtobj.getSelectedRow();
				int ta_row = table.getSelectedRow();
				subNo = (String)data.getValueAt(erow, 0);
				
				if(me.getClickCount() ==2) { //떠브르 클릭시 삭제
					int confirm=JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","삭제해볼래?",JOptionPane.YES_NO_OPTION);
					if(confirm ==0) {
						if (erow == ta_row) {
							int result = dao.getMyRegDelete(subNo);
							setEditable(0);
							getMyListShow();
							if(result == 1) JOptionPane.showMessageDialog(null, "삭제성공");
							else JOptionPane.showMessageDialog(null, "삭제실패");
							table.clearSelection();
						}
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
		}
		//리스트 출력
		private void getMyListShow() {
			dao = new StdMyRegCourseDAO(uid); 
			Vector<Vector<String>>list = dao.getMyRegisterList();
//			DefaultTableModel data = new DefaultTableModel();
			for(Vector<String> vo : list) {
				System.out.println(vo);
				data.addRow(vo);
			}
//			return data;
		}
		
		 public int getMyListRowCount() {
			StdMyRegCourse stdObj = new StdMyRegCourse();
			int rowCount = stdObj.data.getRowCount(); //dataRowCount 가 없을때 오류
			return rowCount;
		}
	}

