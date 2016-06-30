package commands;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import service.UserService;
import ui.MainFrame;

public class SignOut {

	public static boolean go() {

		boolean flag = false;
		try {
			UserService us = (UserService) Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			flag = us.logout(MainFrame.userId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
