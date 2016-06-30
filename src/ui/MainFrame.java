package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import commands.History;
import commands.New;
import commands.Open;
import commands.Run;
import commands.Save;
import commands.SignIn;
import commands.SignOut;
import commands.SignUp;

public class MainFrame extends JFrame {
	
	private final static ImageIcon BACKGROUND = new ImageIcon("C:\\Users\\lenovo\\Desktop\\workspace\\BF\\����.png");

	public final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final static int SCREEN_HT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public final static Font FONT = new Font("���ֹ�����Բ�������ã�", Font.PLAIN, 16);
	
	private final static int WIDTH = 900;
	private final static int HEIGHT = 592;
	
	public static JFrame frame;
	public static String userId ="";
	
	public static JTextArea codeArea;
	public static JTextArea paramArea;
	public static JTextArea resultArea;
	public static JMenuItem signUpMenuItem;
	public static JMenuItem signOutMenuItem;
	public static JMenuItem saveMenuItem;
	
	public static ArrayList<JMenuItem> historys;
	
	public MainFrame(){
		
		frame = new JFrame();	
		Color blue = new Color(192,231,207);
		Color darkBlue = new Color(108,183,105);
		
		JMenuBar menuBar = new JMenuBar();

		menuBar.setBackground(blue);
		
		JMenu menu_0 = new JMenu("�˵�");
		menu_0.setFont(FONT);
		JMenu menu_1 = new JMenu("�˻�");
		menu_1.setFont(FONT);
		JMenu menu_2 = new JMenu("��ʷ�ļ�");
		menu_2.setFont(FONT);
		
		JMenuItem newMenuItem = new JMenuItem("�½�");
		newMenuItem.setFont(FONT);
		newMenuItem.setBackground(blue);
		menu_0.add(newMenuItem);
		newMenuItem.addActionListener(new NewActionListener());
		JMenuItem openMenuItem = new JMenuItem("��");
		openMenuItem.setFont(FONT);
		openMenuItem.setBackground(blue);
		menu_0.add(openMenuItem);
		openMenuItem.addActionListener(new OpenActionListener());
		saveMenuItem = new JMenuItem("����");
		saveMenuItem.setFont(FONT);
		saveMenuItem.setBackground(blue);
		saveMenuItem.setEnabled(false);				//δ��¼ǰ���ܱ���
		menu_0.add(saveMenuItem);
		saveMenuItem.addActionListener(new SaveActionListener());
		JMenuItem runMenuItem = new JMenuItem("����");
		runMenuItem.setFont(FONT);
		runMenuItem.setBackground(blue);
		menu_0.add(runMenuItem);
		runMenuItem.addActionListener(new RunActionListener());
		
		JMenuItem signInMenuItem = new JMenuItem("ע��");
		signInMenuItem.setFont(FONT);
		signInMenuItem.setBackground(blue);
		menu_1.add(signInMenuItem);
		signInMenuItem.addActionListener(new SignInActionListener());
		signUpMenuItem = new JMenuItem("��¼");
		signUpMenuItem.setFont(FONT);
		signUpMenuItem.setBackground(blue);
		menu_1.add(signUpMenuItem);
		signUpMenuItem.addActionListener(new SignUpActionListener());
		signOutMenuItem = new JMenuItem("ע��");
		signOutMenuItem.setFont(FONT);
		signOutMenuItem.setBackground(blue);
		signOutMenuItem.setEnabled(false);				//δ��¼ǰ������
		menu_1.add(signOutMenuItem);
		signOutMenuItem.addActionListener(new SignOutActionListener());
		
		historys = new ArrayList<JMenuItem>();
		
		JMenuItem history_0 = new JMenuItem();
		history_0.setText("1�����ļ�");
		history_0.setFont(FONT);
		history_0.setBackground(blue);
		history_0.setEnabled(false);
		menu_2.add(history_0);
		history_0.addActionListener(new HistoryActionListener());

		JMenuItem history_1 = new JMenuItem();
		history_1.setText("2�����ļ�");
		history_1.setFont(FONT);
		history_1.setBackground(blue);
		history_1.setEnabled(false);
		menu_2.add(history_1);
		history_1.addActionListener(new HistoryActionListener());
		
		JMenuItem history_2 = new JMenuItem();
		history_2.setText("3�����ļ�");
		history_2.setFont(FONT);
		history_2.setBackground(blue);
		history_2.setEnabled(false);
		menu_2.add(history_2);
		history_2.addActionListener(new HistoryActionListener());
		
		historys.add(history_0);
		historys.add(history_1);
		historys.add(history_2);
		menuBar.add(menu_0);
		menuBar.add(menu_1);
		menuBar.add(menu_2);
		menuBar.setVisible(true);
		
		//������
		codeArea = new JTextArea();
		codeArea.setLocation(72,65);
		codeArea.setSize(370,420);
		codeArea.setSelectedTextColor(blue);
		codeArea.setCaretColor(darkBlue);
		codeArea.setFont(FONT);
		codeArea.setLineWrap(true);
		codeArea.setVisible(true);
		//����������
		paramArea = new JTextArea();
		paramArea.setLocation(565,220);
		paramArea.setSize(255,100);
		paramArea.setSelectedTextColor(blue);
		paramArea.setCaretColor(darkBlue);
		paramArea.setFont(FONT);
		codeArea.setLineWrap(true);
		paramArea.setVisible(true);
		//�����
		resultArea = new JTextArea();
		resultArea.setLocation(565,394);
		resultArea.setSize(255, 100);
		resultArea.setEditable(false);
		resultArea.setSelectedTextColor(blue);
		resultArea.setCaretColor(darkBlue);
		resultArea.setFont(FONT);
		resultArea.setLineWrap(true);
		resultArea.setVisible(true);
		
		frame.setJMenuBar(menuBar);
		frame.add(codeArea);
		frame.add(paramArea);
		frame.add(resultArea);
		
		frame.setTitle("BrainFxxk ������");
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocation( (SCREEN_WIDTH-WIDTH)/2 , (SCREEN_HT-HEIGHT)/2 );
		frame.setLayout(null);
		frame.setUndecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//����ͼƬ����
		JLabel imgLabel = new JLabel(BACKGROUND);
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 10, WIDTH,HEIGHT);
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		((JPanel) cp).setOpaque(false); 
		
		frame.repaint();
	}
	
	//�ػ������档���롰A��B��C����ʽ���ļ���
	public static void repaintMainFrame(ArrayList<String> filenames){

		int length = 0;
		if(!filenames.isEmpty()){
			length = filenames.size();
		}

		
		switch(length){
		case 3:
			historys.get(2).setText("3:"+filenames.get(2) );
			historys.get(2).setEnabled(true);
		case 2:
			historys.get(1).setText("2:"+filenames.get(1) );
			historys.get(1).setEnabled(true);
		case 1:
			historys.get(0).setText("1:"+filenames.get(0) );
			historys.get(0).setEnabled(true);
			frame.repaint();
		case 0:
			break;
			default:
				historys.get(0).setText("1:"+filenames.get(length-3));
				historys.get(0).setEnabled(true);
				historys.get(1).setText("2:"+filenames.get(length-2));
				historys.get(1).setEnabled(true);
				historys.get(2).setText("3:"+filenames.get(length-1));
				historys.get(2).setEnabled(true);
				frame.repaint();
				break;
		}
	}
	
	class OpenActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Open.go();
		}
	}
	
	class NewActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			New.go();
		}
	}
	
	class SaveActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Save.go();
		}
	}
	class RunActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Run.go();
		}
	}
	
	class SignInActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SignIn.go();
		}
	}
	
	class SignUpActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SignUp.go();
		}
	}
	
	class SignOutActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			boolean flag = SignOut.go();
			if(flag){
				MyDialog md = new MyDialog("ע���ɹ���");
				signUpMenuItem.setText("��¼");
				signUpMenuItem.setEnabled(true);
				signOutMenuItem.setEnabled(false);
				userId = "";
				saveMenuItem.setEnabled(false);
				repaintMainFrame(new ArrayList<String>());
				historys.get(0).setText("1�����ļ�");
				historys.get(1).setText("2�����ļ�");
				historys.get(2).setText("3�����ļ�");
				historys.get(0).setEnabled(false);
				historys.get(1).setEnabled(false);
				historys.get(2).setEnabled(false);
				frame.repaint();
			}else{
				MyDialog md = new MyDialog("ע��ʧ�ܣ�");
			}
		}
	}
	
	class HistoryActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			History.go(userId,e.getActionCommand().substring(2));
		}
	}
	
}