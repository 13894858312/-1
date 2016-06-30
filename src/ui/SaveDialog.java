package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import service.IOService;

public class SaveDialog extends JDialog {
	private static JTextField filenameInput;
	public static JButton yes;
	public String str;
	private static JDialog jd;
	
	public SaveDialog(){
		jd = new JDialog();
		jd.setTitle("保存");
		jd.setLocation( (MainFrame.SCREEN_WIDTH-300 )/2 , (MainFrame.SCREEN_HT-200)/2);
		jd.setSize(300,200);
		jd.setLayout(null);
		jd.setVisible(true);
		
		filenameInput = new JTextField();
		filenameInput.setLocation(50,30);
		filenameInput.setSize(200,50);
		filenameInput.setText("请输入文件名称");
		
		yes = new JButton();
		yes.setText("确认");
		yes.setLocation(120,100);
		yes.setSize(60,50);
		yes.setVisible(true);
		yes.addActionListener(new yesActionListener());
		
		jd.add(yes);
		jd.add(filenameInput);
		jd.repaint();
		
	}
	
	class yesActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e1){
			str = filenameInput.getText();
			jd.setVisible(false);
			jd.dispose();

			
			boolean flag = false;
			String fileString = MainFrame.codeArea.getText();
			String filename = filenameInput.getText();
			
			try {
				IOService ios = (IOService) Naming.lookup("rmi://localhost:8888/DataRemoteObject");
				flag = ios.writeFile(fileString, MainFrame.userId, filename);
				ArrayList<String> filenames = ios.readFileList(MainFrame.userId);
				MainFrame.repaintMainFrame(filenames);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!flag){
				MyDialog md = new MyDialog("保存失败！");
			}else{
				MyDialog md = new MyDialog("保存成功！");
			}
		}
	}
}

