import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AutoGenQuestion extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();;
	JButton ok;
	private boolean wantto = true;
	JTextField question1 = new JTextField(16);
	JTextField answer = new JTextField(21);

	JLabel instruc = new JLabel("Type in the names of 3 of your best friends, separate by a comma ex: Bob, Bob2, Bob3");
	JLabel instruc2 = new JLabel("If you have no friends, type in names of 3 of your crushes(exes), separate by a comma");
	JLabel instruc3 = new JLabel("Why we do this? We use this to generate random password that fits you, you can choose not to");
	JLabel instruc4 = new JLabel("Generated! Copy/edit your generated password above if you want");

	JCheckBox checkboc = new JCheckBox("Nah, I don't want to answer");
	public AutoGenQuestion(){
		frame = new JFrame("Questions"); 
		ok = new JButton("Ok");
		instruc3.setForeground(Color.RED);
		panel.add(instruc);
		panel.add(instruc2);
		panel.add(question1);
		panel.add(checkboc);
		panel.add(ok);
		panel.add(instruc3);
		checkboc.addActionListener(this);
		ok.addActionListener(this);
		frame.setResizable(false);
		frame.setSize(600, 200); 
		frame.setFocusable(true); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				frame.dispose();
			}
		});
		frame.add(panel);
		frame.setVisible(true); 

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if(checkboc.isSelected()) {
			wantto = false;
		}
		if(s.equals("Ok")) {
			panel.remove(answer);
			panel.remove(instruc4);

			if(wantto)
				RandomPass(question1.getText());
			else {
				RandomPass("");

			}
		}

	}

	public void RandomPass(String daFrined) {
		String upperC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String lowerC = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 
		String specialC = "!@#$%^&*_=+-/.?<>)"; 
		String values = upperC + lowerC + numbers + specialC + daFrined; 
		Random random = new Random(); 
		char[] password = new char[20]; 
		for (int i = 0; i < 20; password[i++] = values.charAt(random.nextInt(values.length())) );  
		answer = new JTextField(String.valueOf(password), 21);
		panel.add(answer);
		instruc4.setForeground(new Color(0,100,0));
		panel.add(instruc4);
        frame.revalidate();
        frame.repaint();

	}

}
