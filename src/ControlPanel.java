
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ControlPanel extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField psswd;
	public static JButton allButton[] = new JButton[12];
	private long tStart;
	private long tStart2;
	public static boolean isReadingPrvacy = false;
	private boolean isReadingTerms = false;
	public static boolean isReadingHelp = false;
	public boolean havereadp = false;
	public static boolean havereadh = false;
	public boolean havereadt = false;
	private JLabel currentUser = new JLabel();
	private JLabel aboutPassord = new JLabel("Password must contain more than 8 characters, sepcial characters, capital letters, number");

	private JCheckBox cb = new JCheckBox("Not show password");
	public JCheckBox keepLogged = new JCheckBox("Keep Logged in");
	public JCheckBox playsound = new JCheckBox("Play sound");

	private boolean soundfx = false;
	public static boolean keepLogg = false;
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
		allButton[9] = new JButton("Auto-Generate password");
		allButton[10] = new JButton("Hide popUp");
		allButton[11] = new JButton("Forget password");

		for(int i=0; i< allButton.length; allButton[i++].addActionListener(this));
		for(int i=0; i< allButton.length; allButton[i++].setOpaque(true));
		cb.setOpaque(true);
		keepLogged.setOpaque(true);
		playsound.setOpaque(true);

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
		keepLogged.addActionListener(this);
		playsound.addActionListener(this);

		this.setPreferredSize(new Dimension(50,190));
		this.setBackground(new Color(0, 0, 139));  
		this.add(username);
		this.add(psswd);
		this.add(cb);
		this.add(keepLogged);
        this.add(aboutPassord);
		for(int i=0; i<allButton.length; this.add(allButton[i++]));
		this.add(playsound);
		allButton[2].setVisible(false);
		allButton[4].setVisible(false);
		allButton[6].setVisible(false);
		allButton[8].setVisible(false);
		UserCredent.keepLogged();
		keepLogged.setSelected(Boolean.parseBoolean(UserCredent.line1));
		if (Boolean.parseBoolean(UserCredent.line1)) {
			loggedIN();
		}

	}

	private void changeColor() {
		cb.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		cb.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));

		keepLogged.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		keepLogged.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));

		playsound.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		playsound.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));


		for (int i=0; i< allButton.length; allButton[i++].setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));
		for (int i=0; i< allButton.length; allButton[i++].setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));

		currentUser.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		currentUser.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		aboutPassord.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}

	public boolean checkNumInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isDigit(c)){
				return true;
			}
		}
		if(!HidePopUpOPtion.hideNRP)
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
		if(!HidePopUpOPtion.hideNRP)
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
		if(!HidePopUpOPtion.hideNRP)
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
		if(!HidePopUpOPtion.hideNRP)
			popUp("Atleast a upper case charater is required","password is not secured");

		return false;
	}

	public  void loggedIN() {
		allButton[0].setVisible(false);
		allButton[7].setVisible(false);
		allButton[8].setVisible(true);
		username.setVisible(false);
		psswd.setVisible(false);
		cb.setVisible(false);
		allButton[9].setVisible(false);
		keepLogged.setVisible(false);
		currentUser = new JLabel("Welcome back, "+UserCredent.currentUser);
		this.add(currentUser);
		SuperGoodUI.privacyP.setVisible(false);
		UserCredent.doDis = false;
		aboutPassord.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if(keepLogged.isSelected()) {
			if(soundfx) {
				PlaySound.play();
			}
			
			keepLogg = true;
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(System.getProperty("user.dir")+"/keepL.txt");
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			writer.print(keepLogg);
			writer.close();
		} else {
			keepLogg = false;
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(System.getProperty("user.dir")+"/keepL.txt");
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			writer.print(keepLogg);
			writer.close();
		}
		
		if(playsound.isSelected()) {
			soundfx = true;
		} else {
			soundfx = false;
		}
		
		if(cb.isSelected()) {
			
			if(soundfx) {
				PlaySound.play();
			}
			
			psswd.setEchoChar('*');
		} else {
			if (!HidePopUpOPtion.hideNSPP) {
				popUp("Showing password may potentially get your password stolen\ncheck the option if you don't want to take a risk!","Warning");
			}
			psswd.setEchoChar((char) 0);
		}
		if (s.equals("Register because I don't have an account") ) {
			
			if(soundfx) {
				PlaySound.play();
			}
			
			if (confirm("Are you not want to register?\nyou will have to remember your password and username\nfurthermore, it will cost you few bytes storage!") == 0) {
				if (havereadh && havereadp && havereadt) {
					if (String.valueOf(psswd.getPassword()).length() >=8 && checkNumInPass() && checkSpecialInPass()&& checkLowerCInPass() && checkUpperCInPass() && SuperGoodUI.Accepted) {
						UserCredent.createnew(username.getText(),String.valueOf(psswd.getPassword()));

						if(UserCredent.doDis) {
							loggedIN();
						}


					} else {
						if (String.valueOf(psswd.getPassword()).length() <8 ) {
							if(!HidePopUpOPtion.hideNRP)
								popUp("Your password needs atleast 8 characters","Password is not secured!!");
						}
						if (!SuperGoodUI.Accepted) {
							if(!HidePopUpOPtion.hideNRP)
								popUp("Accept terms and condition to continue","Need to accept");

						}
						if(!HidePopUpOPtion.hideRP)
							popUp("Your password is not strong enough\nMake sure your password meets the criteria","password is not secured");
					}

				} else {
					if(!HidePopUpOPtion.hideNRP)
						popUp("You haven't read help/terms and conditions/privacy policy\nTherefore, you can't continue\n We want to make sure you understand everything", "warning");
				}
			}
		}

		if(s.equals("Auto-Generate password")) {
			if(soundfx) {
				PlaySound.play();
			}
			new AutoGenQuestion();
		}

		if(s.equals("Hide popUp")) {
			if(soundfx) {
				PlaySound.play();
			}
			new HidePopUpOPtion();
		}
		
		if(s.equals("Forget password")) {
			
			if(soundfx) {
				PlaySound.play();
			}
			
			if(confirm("There is nothing we can do to restore your password since it is stored at your local device\nYou should register a new account\nDo you want to Brutefore to find your password?\nRead help at the main screen to learn more about bruteforcing")==0)
			BruteForce.doingit();
		}

		if(s.equals("Read terms and conditions")&&!isReadingHelp) {
			if(soundfx) {
				PlaySound.play();
			}
			if (!isReadingPrvacy) {
				isReadingTerms  = true;
				tStart = System.currentTimeMillis();
				ShowTermYC.doit();
				allButton[2].setVisible(true);
				allButton[1].setVisible(false);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("dude, keep reading.", "Keep reading");}
		}
		if(s.equals("help")) {
			if(soundfx) {
				PlaySound.play();
			}
			isReadingHelp = true;
			if (!isReadingPrvacy &&!isReadingTerms) {
				Help welp = new Help();
				welp.showHelp();
				allButton[4].setVisible(true);
				allButton[3].setVisible(false);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("You haven't done reading yet!", "Keep reading");}
		}
		if(s.equals("Close Help")) {
			if(soundfx) {
				PlaySound.play();
			}
			havereadh = true;
			isReadingHelp = false;
			Help.closeHelp();
			allButton[4].setVisible(false);
			allButton[3].setVisible(true);
		}
		if (s.equals("Log in because I already have an account as I created it")) {
			if(soundfx) {
				PlaySound.play();
			}
			UserCredent.login(username.getText(),String.valueOf(psswd.getPassword()));
			if (UserCredent.loginS) {
				loggedIN();
			}
		}
		if (s.equals("Privacy policy") && !isReadingHelp) {
			if(soundfx) {
				PlaySound.play();
			}
			if (!isReadingTerms) {
				isReadingPrvacy = true;
				tStart2 = System.currentTimeMillis();
				ShowPrivacyPo.doit();
				allButton[5].setVisible(false);
				allButton[6].setVisible(true);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("dude, keep reading", "Keep reading");}

		}
		if (s.equals("Close Privacy policy")) {
			if(soundfx) {
				PlaySound.play();
			}
			havereadp = true;
			isReadingPrvacy = false;
			long tEnd2 = System.currentTimeMillis();
			if ((tEnd2 - tStart2)/1000.0 >= (10)) {
				ShowPrivacyPo.close();
				allButton[5].setVisible(true);
				allButton[6].setVisible(false);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("There is no way you read that fast, keep reading\n"+(tEnd2 - tStart2)/1000.0 +"/"+300+" secs", "Keep reading");

			}

		}

		if (s.equals("Log out because I don't want to log in anymore")) {
			if(soundfx) {
				PlaySound.play();
			}
			allButton[0].setVisible(true);
			allButton[7].setVisible(true);
			allButton[8].setVisible(false);
			username.setVisible(true);
			psswd.setVisible(true);
			cb.setVisible(true);
			allButton[9].setVisible(true);
			keepLogged.setVisible(true);
			this.remove(currentUser);
			UserCredent.loginS=false;
			SuperGoodUI.privacyP.setVisible(true);
			aboutPassord.setVisible(true);
		}
		if(s.equals("Close Terms Conditions")) {
			if(soundfx) {
				PlaySound.play();
			}
			isReadingTerms  = false;
			havereadt = true;
			long tEnd = System.currentTimeMillis();
			if ((tEnd - tStart)/1000.0 >= (10)) {
				ShowTermYC.close();
				allButton[2].setVisible(false);
				allButton[1].setVisible(true);
			}
			else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("There is no way you read that fast, keep reading\n"+(tEnd - tStart)/1000.0 +"/"+300+" secs", "Keep reading");
			}

		}

	}

	public static void popUp(String todis, String title) {
		if (!HidePopUpOPtion.hideAllP) {
			JOptionPane.showMessageDialog((Component) null, todis,
					title, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static int confirm(String todis) {
		return JOptionPane.showConfirmDialog((Component) null, todis,
				"Confirm", JOptionPane.YES_NO_OPTION);
	}
}
