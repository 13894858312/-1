package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import service.IOService;
import ui.MainFrame;

public class History {

	public static void go(String userId , String filename){

		try {
			IOService ios = (IOService) Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			String result = ios.readFile(userId, filename);
			MainFrame.codeArea.setText(result);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

}
