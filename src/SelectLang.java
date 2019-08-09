import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class SelectLang extends EssentialFunctions {

	private static final long serialVersionUID = 1L;
	JFrame frameHide = new JFrame();
	JLabel instruc1[] = new JLabel[4];
	JRadioButton english;
	JRadioButton spanish;
	ButtonGroup bg;
	JButton ok;
	public SelectLang() {
		frameHide = new JFrame("Select Language"); 

		english = new JRadioButton("English"); 
		spanish = new JRadioButton("Spanish"); 
		bg = new ButtonGroup(); 
		ok = new JButton("ok");
		JPanel panel = new JPanel();
		panel.add(english);
		panel.add(spanish);
		panel.add(ok);
		bg.add(english);
		bg.add(spanish);
 

		frameHide.setResizable(false);
		frameHide.setSize(200, 100); 
		frameHide.setFocusable(true); 
		frameHide.setLocationRelativeTo(null);
		frameHide.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameHide.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				frameHide.dispose();
			}
		});
		frameHide.add(panel);
		frameHide.setVisible(true); 
		ok.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) 
			{ 
				if (english.isSelected()) { 
					System.out.println("1");
				} 

				else if (spanish.isSelected()) { 
					System.out.println("2");

				} 
				else { 
					System.out.println("3");

				} 
			} 
		}); 
	}

}
