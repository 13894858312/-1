package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import ui.MainFrame;

public class Open {
	
	public static void go(){
		
		// ���ļ������ø���
		MainFrame.paramArea.setText("");
		MainFrame.resultArea.setText("");
		
		String fileString = "";
		File file;
		
		final JFileChooser fc = new JFileChooser("D:/");
		fc.setDialogTitle("���ļ�");
		fc.setApproveButtonText("ȷ��");
		fc.showDialog(new JLabel(), "ѡ���ļ�");

		int result = fc.showOpenDialog(MainFrame.frame);
		if (result == JFileChooser.APPROVE_OPTION) { // ѡ�����ȷ����ť
			file = fc.getSelectedFile(); // �õ�ѡ����ļ�

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
