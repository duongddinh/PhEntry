
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Credit extends EssentialFunctions {
	private static final long serialVersionUID = 1L;
	JFrame frameHide = new JFrame();
	JLabel instruc1[] = new JLabel[4];
	public Credit() {
		frameHide = new JFrame("Credit"); 
		instruc1[0] = new JLabel("Developer: Bob");
		instruc1[1] = new JLabel("Translate to German: ");
		instruc1[2] = new JLabel("Translate to Spanish: ");
		instruc1[3] = new JLabel("Translate to Italian: ");

		JPanel panel = new JPanel();
		for(int i=0; i< instruc1.length; panel.add(instruc1[i++]));
		frameHide.setResizable(false);
		frameHide.setSize(200, 200); 
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
	}


}
