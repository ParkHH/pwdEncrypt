package kccglass.encoder.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EncoderUi extends JFrame{
	private JPanel panel1;			// 상단패널
	private JPanel panel2;			// 하단패널
	private JLabel label1;			// 상단패널 안내문구
	private JLabel label2;			// 하단패널 안내문구
	private JTextField tf1;			// 상단패널 입력창
	private JTextField tf2;			// 하단패널 입력창
	private JTextArea ta1;			// 하단패널 출력창
	
	int screenX = 750;				// 프레임 가로 사이즈
	int screenY = 450;				// 프레임 세로 사이즈
	String title = "사용자 암호 암호화하기";		// 프레임 제목
	
	int panel1Width = 100;		// 상단패널 가로 사이즈
	int panel1Height = 250;		// 상단패널 세로 사이즈
	int panel2Width = 100;		// 하단패널 가로 사이즈
	int panel2Height = 250;		// 하단패널 세로 사이즈
	
	
	/**
	 * 비밀번호 암호화 UI 구성 생성자
	 * 본 생성자를 호출함으로써 UI 를 구성한다. 
	 */
	public EncoderUi() {
		// UI 동작에 대한 Class 를 연결
		UiProcess uiProcess = new UiProcess(this);
						
		// ***************** 암호화할 비밀번호 입력 UI 생성
		// -------------------------------------------------
		// 1. 상단 패널 (비밀번호 입력 부분)
		// -------------------------------------------------
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		panel1.setSize(panel1Width, panel1Height);		
		//panel1.setBackground(Color.BLUE);		
		
		// -------------------------------------------------		
		// 2. 비밀번호 입력창
		// -------------------------------------------------
		label1 = new JLabel();
		label1.setText("비밀번호 입력 : ");
		label1.setSize(20, 20);
		label1.setBackground(Color.RED);
		
		tf1 = new JTextField(25);		
		tf1.addActionListener(uiProcess);
		
		panel1.add(label1);
		panel1.add(tf1);		
		
		
		// **************** 암호화된 비밀번호 출력 UI 생성
		// -------------------------------------------------
		// 3. 상단 패널 (비밀번호 입력 부분)
		// -------------------------------------------------
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		panel2.setSize(panel2Width, panel2Height);		
		//panel2.setBackground(Color.YELLOW);		
						
		ta1 = new JTextArea("", 10, 33);
		ta1.setEditable(false);
		ta1.setText("※KCC글라스 AD, 그룹웨어에 지정되는 암호화된 password 를\n확인하는 용도로 사용\n\n입력한 텍스트 암호를 암호화한 결과를 출력합니다.\n**암호화 방식 : AES256, BASE64");
		
		// 하단패널 출력창 스크롤 연결 (overflow = scroll)
		JScrollPane scroll = new JScrollPane(ta1);
		scroll.setBounds(534, 89, 334, 200);
				
		panel2.add(scroll);
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		
		this.setSize(400, 270);
		this.setResizable(false);
		this.setLocation(screenX, screenY);
		this.setTitle(title);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	
	
	// ******************************************************* 아래부터 Getter Setter
	public JPanel getPanel1() {
		return panel1;
	}


	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}


	public JPanel getPanel2() {
		return panel2;
	}


	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}


	public JLabel getLabel1() {
		return label1;
	}


	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}


	public JLabel getLabel2() {
		return label2;
	}


	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}


	public JTextField getTf1() {
		return tf1;
	}


	public void setTf1(JTextField tf1) {
		this.tf1 = tf1;
	}


	public JTextField getTf2() {
		return tf2;
	}


	public void setTf2(JTextField tf2) {
		this.tf2 = tf2;
	}


	public JTextArea getTa1() {
		return ta1;
	}


	public void setTa1(JTextArea ta1) {
		this.ta1 = ta1;
	}


	public int getScreenX() {
		return screenX;
	}


	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}


	public int getScreenY() {
		return screenY;
	}


	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPanel1Width() {
		return panel1Width;
	}


	public void setPanel1Width(int panel1Width) {
		this.panel1Width = panel1Width;
	}


	public int getPanel1Height() {
		return panel1Height;
	}


	public void setPanel1Height(int panel1Height) {
		this.panel1Height = panel1Height;
	}


	public int getPanel2Width() {
		return panel2Width;
	}


	public void setPanel2Width(int panel2Width) {
		this.panel2Width = panel2Width;
	}


	public int getPanel2Height() {
		return panel2Height;
	}


	public void setPanel2Height(int panel2Height) {
		this.panel2Height = panel2Height;
	}		
}
