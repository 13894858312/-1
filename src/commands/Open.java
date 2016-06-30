package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import ui.MainFrame;

public class Open {
	
	public static void go(){
		
		// 打开文件并重置各区
		MainFrame.paramArea.setText("");
		MainFrame.resultArea.setText("");
		
		String fileString = "";
		File file;
		
		final JFileChooser fc = new JFileChooser("D:/");
		fc.setDialogTitle("打开文件");
		fc.setApproveButtonText("确定");
		fc.showDialog(new JLabel(), "选择文件");

		int result = fc.showOpenDialog(MainFrame.frame);
		if (result == JFileChooser.APPROVE_OPTION) { // 选择的是确定按钮
			file = fc.getSelectedFile(); // 得到选择的文件

			FileReader fr;
			if (file.isFile()) {
				try {
					fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String str = "";
					while ((str = br.readLine()) != null) {
						fileString += str;
					}
					MainFrame.codeArea.setText(fileString);
					MainFrame.frame.repaint();
					br.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}

}
