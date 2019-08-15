
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ControlPanel extends EssentialFunctions  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField psswd;
	private long tStart;
	private long tStart2;
	private boolean isReadingTerms = false;
	private JLabel currentUserA = new JLabel();
	private JLabel aboutPassord = new JLabel("Password must contain more than 8 characters, sepcial characters, capital letters, number");
	private JCheckBox cb = new JCheckBox("Not show password");
	public static boolean nightmode = false;
	private boolean soundfx = false;
	private boolean initialCD = false;
	private BrowseLoggedIn bb = new BrowseLoggedIn();
	private TheGame ng = new TheGame();

	public ControlPanel() {
		if( Boolean.parseBoolean(getFistLine("/lang.txt"))) {
			allButton[0] = new JButton("Registrar porque no tengo una cuenta");
			allButton[1] = new JButton("Leer los términos y condiciones");
			allButton[2] = new JButton("Cerrar los términos y condiciones");
			allButton[3] = new JButton("Ayuda");
			allButton[4] = new JButton("Cerrar Ayuda");
			allButton[5] = new JButton("Política de privacidad");
			allButton[6] = new JButton("Cerrar Política de privacidad");
			allButton[7] = new JButton("Iniciar sesión porque tengo una cuenta");
			allButton[8] = new JButton("Cerrar sesión porque no quiero iniciar sesión nunca más");
			allButton[9] = new JButton("Autogenerar contraseña");
			allButton[10] = new JButton("Esconder popUp");
			allButton[11] = new JButton("Olvido de contraseña");
			allButton[12] = new JButton("Para usuarios avanzados");
			allButton[13] = new JButton("Juega en el lugar porque no tenemos conexión a internet.");
			allButton[14] = new JButton("Salir del juego");
			allButton[15] = new JButton("Jugar de nuevo");
			allButton[16] = new JButton("Crédito");
			allButton[17] = new JButton("Cambiar idioma");
			allButton[18] = new JButton("Realimentación/Reportar un error");
			username = new JTextField("Escriba el nombre por favor", 30);
			psswd = new JPasswordField("Escribir la contraseña", 30);
			aboutPassord.setText("La contraseña debe contener más de 8 caracteres, letras mayúsculas y números");
			cb.setText("No mostrar la contraseña");
			playsound.setText("Reproducir sonido");
			darkmode.setText("Modo oscuro ");
			privacyP.setText("No acepto los términos y condiciones y Política de privacidad");
			keepLogged.setText("Mantenerme conectado");
		} else {
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
			allButton[12] = new JButton("For Advanced User");
			allButton[13] = new JButton("Play game instead because I don't have internet connection.");
			allButton[14] = new JButton("Quit Game");
			allButton[15] = new JButton("Play Again");
			allButton[16] = new JButton("Credit");
			allButton[17] = new JButton("Change Language");
			allButton[18] = new JButton("Feedback/Report bug");
			username = new JTextField("Type in the name please", 30);
			psswd = new JPasswordField("Type in the password", 30);
		}

		for(int i=0; i< allButton.length; allButton[i++].addActionListener(this));
		for(int i=0; i< allButton.length; allButton[i++].setOpaque(true));
		cb.setOpaque(true);
		keepLogged.setOpaque(true);
		playsound.setOpaque(true);
		darkmode.setOpaque(true);

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
		darkmode.addActionListener(this);

		
		//this.setLayout(null);
		/*
		username.setBounds(20, 10, 200, 30);
		psswd.setBounds(220, 10, 200, 30);
        keepLogged.setBounds(420, 12, 150, 25);
		cb.setBounds(580, 12, 180, 25);
*/
		this.add(username);
		this.add(psswd);
        this.add(keepLogged);
		this.add(cb);
/*		
		allButton[15].setBounds(20, 70, 300, 30);
		allButton[14].setBounds(350, 70, 300, 30);
*/
		this.add(allButton[15]);
		this.add(allButton[14]);
		
		//aboutPassord.setBounds(100, 40, 600, 25);
		this.add(aboutPassord);

		//allButton[0].setBounds(20, 70, 300, 30);
		this.add(allButton[0]);

		/*
		allButton[7].setBounds(350, 70, 400, 30);
		allButton[8].setBounds(350, 70, 400, 30);
*/
		this.add(allButton[7]);
		this.add(allButton[8]);
		
		//allButton[9].setBounds(20, 110, 200, 30);
		this.add(allButton[9]);
		
		//allButton[3].setBounds(230, 110, 90, 30);
		//allButton[4].setBounds(230, 110, 90, 30);

		this.add(allButton[3]);
		this.add(allButton[4]);

		//allButton[11].setBounds(350, 110, 200, 30);
		//allButton[10].setBounds(560, 110, 190, 30);
		//allButton[13].setBounds(190, 150, 400, 30);
		
		this.add(allButton[11]);
		this.add(allButton[10]);
		this.add(allButton[13]);
		
		//allButton[1].setBounds(20, 190, 200, 30);
		//allButton[2].setBounds(20, 190, 200, 30);

		this.add(allButton[1]);
		this.add(allButton[2]);

		
		//allButton[5].setBounds(230, 190, 150, 30);
		//allButton[6].setBounds(230, 190, 150, 30);

		this.add(allButton[5]);
		this.add(allButton[6]);

		
		//allButton[17].setBounds(390, 190, 150, 30);
		//allButton[18].setBounds(550, 190, 200, 30);
        
		this.add(allButton[17]);
		this.add(allButton[12]);
		this.add(allButton[18]);
		
		this.add(playsound);
		this.add(darkmode);

		//playsound.setBounds(200, 230, 100, 30);
        //darkmode.setBounds(320, 230, 120, 30);
		//allButton[16].setBounds(460, 230, 100, 30);
		this.add(allButton[16]);

		
		
		this.setPreferredSize(new Dimension(50,280));
		this.setBackground(new Color(0, 0, 139));  
	//	this.add(username);
	//	this.add(psswd);
	//	this.add(cb);
	//	this.add(keepLogged);
	//	this.add(aboutPassord);
		//for(int i=0; i<allButton.length; this.add(allButton[i++]));
	//	this.add(playsound);
	//	this.add(darkmode);

		allButton[2].setVisible(false);
		allButton[4].setVisible(false);
		allButton[6].setVisible(false);
		allButton[8].setVisible(false);
		allButton[14].setVisible(false);
		allButton[15].setVisible(false);
		if (oneplz ==0) {
			oneplz = 1;
			frame.add(ms);
		}
		UserCredent.keepLogged();
		initialCD = Boolean.parseBoolean(isNightMode);
		darkmode.setSelected(Boolean.parseBoolean(isNightMode));
		keepLogged.setSelected(Boolean.parseBoolean(line1));
		if (Boolean.parseBoolean(line1)) {
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

		darkmode.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		darkmode.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));

		for (int i=0; i< allButton.length; allButton[i++].setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));
		for (int i=0; i< allButton.length; allButton[i++].setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)))));

		currentUserA.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		currentUserA.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		aboutPassord.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}

	public boolean checkNumInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isDigit(c)){
				return true;
			}
		}
		if(!HidePopUpOPtion.hideNRP) {
			if( Boolean.parseBoolean(getFistLine("/lang.txt")))
				popUp("Al menos se requiere un numero","La contraseña no es segura");

			else
				popUp("Atleast a number is required","password is not secured");
		}

		return false;
	}

	public boolean checkSpecialInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(String.valueOf(c).matches("[^a-z A-Z0-9]")){
				return true;
			}
		}
		if(!HidePopUpOPtion.hideNRP) {
			if( Boolean.parseBoolean(getFistLine("/lang.txt")))
				popUp("Al menos se requiere un carácter especial","La contraseña no es segura");

			else

				popUp("Atleast a special charater is required","password is not secured");
		}
		return false;

	}

	public boolean checkLowerCInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isLowerCase( c )){
				return true;
			}
		}
		if(!HidePopUpOPtion.hideNRP) {
			if( Boolean.parseBoolean(getFistLine("/lang.txt")))

				popUp("Al menos se requiere una minúscula","La contraseña no es segura");

			else

				popUp("Atleast a lower case charater is required","password is not secured");


		}
		return false;

	}

	public boolean checkUpperCInPass() {
		char[] chars = String.valueOf(psswd.getPassword()).toCharArray();
		for(char c : chars){
			if(Character.isUpperCase( c )){
				return true;
			}
		}
		if(!HidePopUpOPtion.hideNRP) {
			if( Boolean.parseBoolean(getFistLine("/lang.txt")))
				popUp("Al menos se requiere una mayúscula","La contraseña no es segura");

			else

				popUp("Atleast a upper case charater is required","password is not secured");
		}
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
		currentUserA = new JLabel("Welcome back, "+ currentUser);
		this.add(currentUserA);
		privacyP.setVisible(false);
		doDis = false;
		aboutPassord.setVisible(false);
		wl.writeLog("Logged in as: "+ currentUser);
		bb.doingit();
		frame.remove(ms);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if(soundfx) {
			PlaySound ps = new PlaySound();
			ps.play();

		}

		if(darkmode.isSelected()) {
			nightmode = true;
			WriteInfo("/nightmode.txt", nightmode);
		}
		else {
			nightmode = false;
			WriteInfo("/nightmode.txt", nightmode);
		}

		if (nightmode != initialCD) {
			restart();
		}

		if(keepLogged.isSelected()) {
			keepLogg = true;
			WriteInfo("/keepL.txt", keepLogg);

		} else {
			keepLogg = false;
			WriteInfo("/keepL.txt", keepLogg);

		}

		if(playsound.isSelected()) {
			soundfx = true;
		} else {
			soundfx = false;
		}



		if(cb.isSelected()) {

			psswd.setEchoChar('*');
		} else {
			if (!HidePopUpOPtion.hideNSPP) {
				if( Boolean.parseBoolean(getFistLine("/lang.txt")))
					popUp("Mostrar la contraseña puede causar que te roben la contraseña\nRevisa las opciones si tu no quieres correr un riesgo","La contraseña no es segura");

				else

					popUp("Showing password may potentially get your password stolen\ncheck the option if you don't want to take a risk!","Warning");
			}
			psswd.setEchoChar((char) 0);
		}
		if (e.getSource() == allButton[0] ) {

			if (confirm("Are you not want to register?\nyou will have to remember your password and username\nfurthermore, it will cost you few bytes storage!") == 0) {
				if (havereadh && havereadp && havereadt) {
					if (String.valueOf(psswd.getPassword()).length() >=8 && checkNumInPass() && checkSpecialInPass()&& checkLowerCInPass() && checkUpperCInPass() && SuperGoodUI.Accepted) {
						UserCredent.createnew(username.getText(),String.valueOf(psswd.getPassword()));
						if(doDis) {
							loggedIN();
						}

					} else {
						if (String.valueOf(psswd.getPassword()).length() <8 ) {
							if(!hideNRP)
								popUp("Your password needs atleast 8 characters","Password is not secured!!");
						}
						if (!Accepted) {
							if(!hideNRP)
								popUp("Accept terms and condition to continue","Need to accept");

						}
						if(!hideRP)
							popUp("Your password is not strong enough\nMake sure your password meets the criteria","password is not secured");
					}

				} else {
					if(!hideNRP)
						popUp("You haven't read help/terms and conditions/privacy policy\nTherefore, you can't continue\n We want to make sure you understand everything", "warning");
				}
			}
		}

		if(e.getSource() == allButton[18]) {
			Desktop desktop = Desktop.getDesktop();
			String message = "mailto:bob@null0verflow.xyz?subject=feedback";
			URI uri = URI.create(message);
			try {
				desktop.mail(uri);
			} catch (IOException e1) {
				e1.printStackTrace();
				wl.writeLog(e1.toString());
			}
		}

		if(e.getSource() == allButton[15]) {
			allButton[15].setVisible(false);
			ng.isDone = false;
			ng.reset();
			TheGame.timer.start();
			frame.revalidate();
			frame.repaint();
		}

		if(e.getSource() == allButton[14]) {
			allButton[0].setVisible(true);
			allButton[1].setVisible(true);
			allButton[3].setVisible(true);
			allButton[5].setVisible(true);
			allButton[7].setVisible(true);
			allButton[9].setVisible(true);
			allButton[11].setVisible(true);
			allButton[12].setVisible(true);
			allButton[13].setVisible(true);
			allButton[14].setVisible(false);
			aboutPassord.setVisible(true);
			frame.getContentPane().remove(ng); 	
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);  
			frame.revalidate();
			frame.repaint();
			frame.add(ms);

		}
		if(e.getSource() == allButton[13]) {
			for(int i=0; i< allButton.length; allButton[i++].setVisible(false));
			allButton[14].setVisible(true);
			allButton[10].setVisible(true);
			allButton[16].setVisible(true);
			allButton[17].setVisible(true);
			allButton[18].setVisible(true);
			aboutPassord.setVisible(false);
			ng.isDone = false;
			ng.reset();

			frame.remove(ms);
			frame.getContentPane().add(BorderLayout.CENTER, ng); 	
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);  
			frame.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent event) {
					ng.moveTheTHing(event);
					if(soundfx) {
						PlaySound ps = new PlaySound();
						ps.play();

					}
				}
			});
			if (!ng.isDone)
				TheGame.timer.start();
			if (isReadingHelp)
				Help.closeHelp();

			bb.remove();
			if(isReadingPrvacy)
				ShowPrivacyPo.close();
			if(isReadingTerms)
				ShowTermYC.close();
			frame.revalidate();
			frame.repaint();
		}



		if(e.getSource() == allButton[16]) {
			new Credit();
		}

		if(e.getSource() == allButton[17]) {
			new SelectLang();
		}
		if(e.getSource() == allButton[12]) {

			new ForAdvancedUser();

		}

		if(e.getSource() == allButton[9]) {

			new AutoGenQuestion();
		}

		if(e.getSource() == allButton[10]) {

			new HidePopUpOPtion();
		}

		if(e.getSource() == allButton[11]) {
			if(confirm("There is nothing we can do to restore your password since it is stored at your local device\nYou should register a new account\nDo you want to Brutefore to find your password?\nRead help at the main screen to learn more about bruteforcing")==0)
				BruteForce.doingit();
		}

		if(e.getSource() == allButton[1]&&!isReadingHelp) {
			if (!isReadingPrvacy) {
				frame.remove(ms);
				isReadingTerms  = true;
				tStart = System.currentTimeMillis();
				ShowTermYC.doit();
				allButton[2].setVisible(true);
				allButton[1].setVisible(false);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("dude, keep reading.", "Keep reading");}
		}
		if(e.getSource() == allButton[3]) {
			isReadingHelp = true;
			if (!isReadingPrvacy &&!isReadingTerms) {
				frame.remove(ms);
				Help welp = new Help();
				welp.showHelp();
				allButton[4].setVisible(true);
				allButton[3].setVisible(false);
			} else {
				if(!HidePopUpOPtion.hideNRP)
					popUp("You haven't done reading yet!", "Keep reading");}
		}
		if(e.getSource() == allButton[4]) {
			frame.add(ms);
			havereadh = true;
			isReadingHelp = false;
			Help.closeHelp();
			allButton[4].setVisible(false);
			allButton[3].setVisible(true);
		}
		if (s.equals("Log in because I already have an account as I created it")) {

			UserCredent.login(username.getText(),String.valueOf(psswd.getPassword()));
			if (UserCredent.loginS) {
				loggedIN();
			}
		}
		if (e.getSource() == allButton[5]&& !isReadingHelp) {

			if (!isReadingTerms) {
				isReadingPrvacy = true;
				tStart2 = System.currentTimeMillis();
				ShowPrivacyPo.doit();
				allButton[5].setVisible(false);
				allButton[6].setVisible(true);
				frame.remove(ms);
			} else {
				if(!hideNRP)
					popUp("dude, keep reading", "Keep reading");}

		}
		if (e.getSource() == allButton[6]) {

			havereadp = true;
			isReadingPrvacy = false;
			long tEnd2 = System.currentTimeMillis();
			if ((tEnd2 - tStart2)/1000.0 >= (10)) {
				ShowPrivacyPo.close();
				allButton[5].setVisible(true);
				allButton[6].setVisible(false);
				frame.add(ms);

			} else {
				if(!hideNRP)
					popUp("There is no way you read that fast, keep reading\n"+(tEnd2 - tStart2)/1000.0 +"/"+300+" secs", "Keep reading");

			}

		}

		if (e.getSource() == allButton[8]) {
			allButton[0].setVisible(true);
			allButton[7].setVisible(true);
			allButton[8].setVisible(false);
			username.setVisible(true);
			psswd.setVisible(true);
			cb.setVisible(true);
			allButton[9].setVisible(true);
			keepLogged.setVisible(true);
			this.remove(currentUserA);
			loginS=false;
			privacyP.setVisible(true);
			aboutPassord.setVisible(true);
			wl.writeLog("Logged out");
			bb.remove();
			frame.add(ms);
		}
		if(e.getSource() == allButton[2]) {
			isReadingTerms  = false;
			havereadt = true;
			long tEnd = System.currentTimeMillis();
			if ((tEnd - tStart)/1000.0 >= (10)) {
				ShowTermYC.close();
				allButton[2].setVisible(false);
				allButton[1].setVisible(true);
				frame.add(ms);
			}
			else {
				if(!hideNRP)
					popUp("There is no way you read that fast, keep reading\n"+(tEnd - tStart)/1000.0 +"/"+300+" secs", "Keep reading");
			}

		}

	}


}
