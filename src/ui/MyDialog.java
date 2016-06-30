package ui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyDialog {
	private JDialog d ;
	private static int sw = MainFrame.SCREEN_WIDTH;
	private static int sh = MainFrame.SCREEN_HT;
	private static int w = sw/6;
	private static int h = sw/8;
	
	public MyDialog(String text){
		d = new JDialog();
		d.setFont(MainFrame.FONT);
		d.setTitle("ÌבÊ¾");
		d.setLocation( (sw-w)/2 , (sh-h)/2 );
		d.setSize(w,h);
		d.setLayout(new BorderLayout());
		d.setVisible(true);
		
		JLabel jl = new JLabel();
		jl.setText(text);
		jl.setSize(sw/7,sw/7);
		jl.setFont(MainFrame.FONT);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setVisible(true);
		
		d.add(jl);
		d.repaint();
	}
}
