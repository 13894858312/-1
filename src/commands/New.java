package commands;

import javax.swing.JOptionPane;

import ui.MainFrame;

public class New {
	
	public static void go(){
		int n = JOptionPane.showConfirmDialog(null, "δ��������ݻᶪʧ���Ƿ������", "����", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			MainFrame.codeArea.setText("");
			MainFrame.paramArea.setText("");
			MainFrame.resultArea.setText("");
		}
	}
}
