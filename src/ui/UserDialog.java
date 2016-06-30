package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class UserDialog implements ActionListener{
	protected static JDialog dialog;
	private final static int WIDTH = 600;
	private final static int HT=400;
	public static JTextField idField;
	public static JPasswordField passwordField;
	protected JButton yes;
	
	public UserDialog(){
		dialog = new JDialog();
		dialog.setLocation( (MainFrame.SCREEN_WIDTH-WIDTH)/2 , (MainFrame.SCREEN_HT-HT)/2);
		dialog.setSize(WIDTH,HT);
		dialog.setVisible(true);
		dialog.setLayout(null);

		JLabel nameLabel = new JLabel();
		nameLabel.setText("用户名");
		nameLabel.setFont(MainFrame.FONT);
		nameLabel.setLocation(WIDTH/12, HT/6);
		nameLabel.setSize(WIDTH/3,HT/6);
		nameLabel.setVisible(true);
		
		JLabel pswdLabel = new JLabel();
		pswdLabel.setText("密码");
		nameLabel.setFont(MainFrame.FONT);
		pswdLabel.setLocation(WIDTH/12 , HT*5/12);
		pswdLabel.setSize(WIDTH/3,HT/6);
		pswdLabel.setVisible(true);
		
		idField = new JTextField();
		idField.setText("请输入用户名");
		idField.setLocation(WIDTH/3,HT/6);
		idField.setFont(MainFrame.FONT);
		idField.setSize(WIDTH/2,HT/6);
		idField.setVisible(true);
		
		passwordField = new JPasswordField();
		passwordField.setText("请输入密码");
		passwordField.setLocation(WIDTH/3,HT*5/12);
		passwordField.setSize(WIDTH/2,HT/6);
		passwordField.setFont(MainFrame.FONT);
		passwordField.setEchoChar('★');
		passwordField.setVisible(true);
		
		yes = new JButton();
		yes.setText("确认");
		yes.setLocation(WIDTH/6,HT*2/3);
		yes.setSize(WIDTH/3,HT/5);
		yes.setFont(MainFrame.FONT);
		yes.setVisible(true);
		yes.addActionListener(this);
		
		JButton no = new JButton();
		no.setText("取消");
		no.setLocation(WIDTH/2,HT*2/3);
		no.setSize(WIDTH/3,HT/5);
		no.setFont(MainFrame.FONT);
		no.setVisible(true);
		no.addActionListener(new NoActionListener());
		
		dialog.add(nameLabel);
		dialog.add(pswdLabel);
		dialog.add(idField);
		dialog.add(passwordField);
		dialog.add(yes);
		dialog.add(no);
		dialog.repaint();
		}
	
	class NoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dialog.setVisible(false);
			dialog.dispose();
		}
	}
	
	public abstract void actionPerformed(ActionEvent e);
	
}
