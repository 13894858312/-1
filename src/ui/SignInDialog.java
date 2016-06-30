package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import service.UserService;

//×¢²á¶Ô»°¿ò
public class SignInDialog extends UserDialog{
	
	public void actionPerformed(ActionEvent e){
		
		String name = idField.getText();
		String password = new String(passwordField.getPassword());
		boolean flag = false;
		
		UserService us;
		try {
			us = (UserService)Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			flag = us.signin(name, password);
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dialog.setVisible(true);
		dialog.dispose();
		
		if(flag){
			MyDialog md = new MyDialog("×¢²á³É¹¦£¡");
		}else{
			MyDialog md = new MyDialog("×¢²áÊ§°Ü£¡");
		}

	}
	
	
	public SignInDialog(){
		super();
		dialog.setTitle("×¢²á");
		yes.setText("×¢²á");
		dialog.repaint();
	}

}
