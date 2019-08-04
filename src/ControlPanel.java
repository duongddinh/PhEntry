
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ControlPanel extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField psswd;
	private JButton allButton[] = new JButton[9];
	private long tStart;
	private long tStart2;
	private boolean isReadingPrvacy = false;
	private boolean isReadingTerms = false;
	private boolean isReadingHelp = false;
	public boolean havereadp = false;
	public boolean havereadh = false;
	public boolean havereadt = false;

	private JCheckBox cb = new JCheckBox("Not show password");
	public static boolean readterms = false;
	public ControlPanel() {
		allButton[0] = new JButton("Register because I don't have an account");
		allButton[1] = new JButton("Read terms and conditions");
		allButton[2] = new JButton("Close Terms Conditions");
		allButton[3] = new JButton("help");
		allButton[4] = new JButton("Close Help");
		allButton[5] = new JButton("Privacy policy");
		allButton[6] = new JButton("Close Privacy policy");
		allButton[7] = new JButton("Log in because I already have an account as I created it");
		allButton[8] = new JButton("Log out because I don't want to log in anymore");
		for(int i=0; i< allButton.length; allButton[i++].addActionListener(this));
		for(int i=0; i< allButton.length; allButton[i++].setOpaque(true));
		cb.setOpaque(true);
		username = new JTextField("Type in the name please", 30);
		username.grabFocus();
		psswd = new JPasswordField("Type in the password", 30);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				changeColor();
			}
		};
		Timer timer = new Timer();
		long delay = 1;
		long intevalPeriod = 1 * 1000; 
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
		cb.addActionListener(this);

		this.setPreferredSize(new Dimension(50,120));
		this.setBackground(new Color(0, 0, 139));  
		this.add(username);
		this.add(psswd);
		this.add(cb);
		for(int i=0; i<allButton.length; this.add(allButton[i++]));
		allButton[2].setVisible(false);
		allButton[4].setVisible(false);
		allButton[6].setVisible(false);
		allButton[8].setVisible(false);

	}

	private void changeColor() {
		cb.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		cb.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));

		for (int i=0; i< allButton.length; allButton[i++].setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));
		for (int i=0; i< allButton.length; allButton[i++].setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));

	}

	public boolean checkNumInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isDigit(c)){
				return true;
			}
		}
		popUp("Atleast a number is required","password is not secured");

		return false;
	}

	public boolean checkSpecialInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(String.valueOf(c).matches("[^a-z A-Z0-9]")){
				return true;
			}
		}
		popUp("Atleast a special charater is required","password is not secured");

		return false;

	}

	public boolean checkLowerCInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isLowerCase( c )){
				return true;
			}
		}
		popUp("Atleast a lower case charater is required","password is not secured");

		return false;

	}

	public boolean checkUpperCInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isUpperCase( c )){
				return true;
			}
		}
		popUp("Atleast a upper case charater is required","password is not secured");

		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if(cb.isSelected()) {
			psswd.setEchoChar('*');
		} else {
			popUp("Showing password may potentially get your password stolen\ncheck the option if you don't want to take a risk!","Warning");
			psswd.setEchoChar((char) 0);
		}
		if (s.equals("Register because I don't have an account") ) {
			if (confirm("Are you not want to register?\nyou will have to remember your password and username\nfurthermore, it will cost you few bytes storage!") == 0) {
				if (havereadh && havereadp && havereadt) {
					if (String.valueOf(psswd.getPassword()).length() >=8 && checkNumInPass() && checkSpecialInPass()&& checkLowerCInPass() && checkUpperCInPass()) {
						UserCredent.createnew(username.getText(),String.valueOf(psswd.getPassword()));
						allButton[0].setVisible(false);
						allButton[7].setVisible(false);
						allButton[8].setVisible(true);
						username.setVisible(false);
						psswd.setVisible(false);
						cb.setVisible(false);
					} else {
						if (String.valueOf(psswd.getPassword()).length() <8 ) {
							popUp("Your password needs atleast 8 characters","Password is not secured!!");
						}
						popUp("Your password is not strong enough\nMake sure your password meets the criteria","password is not secured");
					}

				} else {
					popUp("You haven't read help/terms and conditions/privacy policy\nTherefore, you can't continue\n We want to make sure you understand everything", "warning");
				}
			}
		}
		if(s.equals("Read terms and conditions")&&!isReadingHelp) {
			if (!isReadingPrvacy) {
				isReadingTerms  = true;
				tStart = System.currentTimeMillis();
				ShowTermYC.doit();
				allButton[2].setVisible(true);
				allButton[1].setVisible(false);
			} else popUp("dude, keep reading.", "Keep reading");
		}
		if(s.equals("help")) {
			isReadingHelp = true;
			if (!isReadingPrvacy &&!isReadingTerms) {
				Help.showHelp();
				allButton[4].setVisible(true);
				allButton[3].setVisible(false);
			} else popUp("You haven't done reading yet!", "Keep reading");
		}
		if(s.equals("Close Help")) {
			havereadh = true;
			isReadingHelp = false;
			Help.closeHelp();
			allButton[4].setVisible(false);
			allButton[3].setVisible(true);
		}
		if (s.equals("Log in because I already have an account as I created it")) {
			UserCredent.login(username.getText(),String.valueOf(psswd.getPassword()));
            if (UserCredent.loginS) {
    			allButton[0].setVisible(false);
    			allButton[7].setVisible(false);
    			allButton[8].setVisible(true);
    			username.setVisible(false);
    			psswd.setVisible(false);
    			cb.setVisible(false);

            }
		}
		if (s.equals("Privacy policy") && !isReadingHelp) {
			if (!isReadingTerms) {
				isReadingPrvacy = true;
				tStart2 = System.currentTimeMillis();
				ShowPrivacyPo.doit();
				allButton[5].setVisible(false);
				allButton[6].setVisible(true);
			} else popUp("dude, keep reading", "Keep reading");

		}
		if (s.equals("Close Privacy policy")) {
			havereadp = true;
			isReadingPrvacy = false;
			long tEnd2 = System.currentTimeMillis();
			if ((tEnd2 - tStart2)/1000.0 >= (10)) {
				ShowPrivacyPo.close();
				allButton[5].setVisible(true);
				allButton[6].setVisible(false);
			} else {
				popUp("There is no way you read that fast, keep reading\n"+(tEnd2 - tStart2)/1000.0 +"/"+300+" secs", "Keep reading");

			}

		}

		if (s.equals("Log out because I don't want to log in anymore")) {
			allButton[0].setVisible(true);
			allButton[7].setVisible(true);
			allButton[8].setVisible(false);
			username.setVisible(true);
			psswd.setVisible(true);
			cb.setVisible(true);
			
		}
		if(s.equals("Close Terms Conditions")) {
			isReadingTerms  = false;
			havereadt = true;
			long tEnd = System.currentTimeMillis();
			if ((tEnd - tStart)/1000.0 >= (10)) {
				ShowTermYC.close();
				allButton[2].setVisible(false);
				allButton[1].setVisible(true);
			}
			else {
				popUp("There is no way you read that fast, keep reading\n"+(tEnd - tStart)/1000.0 +"/"+300+" secs", "Keep reading");
			}

		}

	}

	public static void popUp(String todis, String title) {
		JOptionPane.showMessageDialog((Component) null, todis,
				title, JOptionPane.INFORMATION_MESSAGE);
	}

	public int confirm(String todis) {
		return JOptionPane.showConfirmDialog((Component) null, todis,
				"Confirm", JOptionPane.YES_NO_OPTION);
	}
}
