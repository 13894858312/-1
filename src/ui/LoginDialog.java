package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import service.IOService;
import service.UserService;

//µÇÂ¼¶Ô»°¿ò
public class LoginDialog extends UserDialog implements ActionListener{

	public void actionPerformed(ActionEvent e){
		String name = idField.getText();
		String password = new String(passwordField.getPassword());
		boolean flag = false;
		
		UserService us;
		try {
			us = (UserService)Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			flag = us.login(name, password);
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(flag){
			dialog.setVisible(false);
			dialog.dispose();
			
			MyDialog md = new MyDialog("µÇÂ½³É¹¦~");
			
			MainFrame.userId = name;
			MainFrame.signUpMenuItem.setText(name);
			MainFrame.signUpMenuItem.setEnabled(false);
			MainFrame.signOutMenuItem.setEnabled(true);
			MainFrame.saveMenuItem.setEnabled(true);
			
			IOService ios;
			try {
				ios = (IOService) Naming.lookup("rmi://localhost:8888/DataRemoteObject");
				ArrayList<String> fileNames = ios.readFileList(name);
				MainFrame.repaintMainFrame(fileNames);
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else{
			MyDialog md = new MyDialog("µÇÂ¼Ê§°Ü£¡");
		}
	}	
	
	public LoginDialog(){
		super();
		dialog.setTitle("µÇÂ¼");
		yes.setText("µÇÂ¼");
		dialog.repaint();
	}

}
