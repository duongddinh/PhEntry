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
	JRadioButton german;
	JRadioButton spanish;
	JRadioButton italian;
	ButtonGroup bg;
	JButton ok;
	public SelectLang() {
		frameHide = new JFrame("Credit"); 

		german = new JRadioButton("German"); 
		spanish = new JRadioButton("Spanish"); 
		italian = new JRadioButton("Italian"); 
		bg = new ButtonGroup(); 
		ok = new JButton("ok");
		JPanel panel = new JPanel();
		panel.add(german);
		panel.add(spanish);
		panel.add(italian);
		panel.add(ok);
		bg.add(german);
		bg.add(spanish);
		bg.add(italian);
 

		frameHide.setResizable(false);
		frameHide.setSize(150, 200); 
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
				if (german.isSelected()) { 
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
