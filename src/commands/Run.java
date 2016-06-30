package commands;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import service.ExecuteService;
import ui.MainFrame;

public class Run {
	public static void go(){
		String code = MainFrame.codeArea.getText();
		String param = MainFrame.paramArea.getText();
		
		String result = "";
		try {	
			ExecuteService es = (ExecuteService)Naming.lookup("rmi://localhost:8888/DataRemoteObject");
			result += es.execute(code, param);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		MainFrame.resultArea.setText(result);
	}
}
