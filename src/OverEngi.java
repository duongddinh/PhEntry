import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javafx.application.Platform;

public class OverEngi extends EssentialFunctions {
	private static final long serialVersionUID = 1L;
	public static long startTime;

	public static void main(String args[]) {
		Platform.setImplicitExit(false);
		startTime = System.currentTimeMillis();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
			wl.writeLog(e1.toString());
		}
		isNightMode();
		wl.writeLog("Night mode: " + isNightMode);
		if (Boolean.parseBoolean(isNightMode)) {
			UIManager.put("OptionPane.background", Color.DARK_GRAY);
			UIManager.put("Panel.background", Color.DARK_GRAY);
			UIManager.put("OptionPane.messageForeground", Color.WHITE);
		}
       
		CheckUpdate ccu= new CheckUpdate();
		try {
			ccu.checkup();
		} catch (Exception e) {
			e.printStackTrace();
			wl.writeLog(e.toString());
			popUp("Error occurs while loading update", "Update");
			ccu.closeUpWindow();
		}
		popUp("This is likely a parody", "disclaimer");
		popUp("Privacy Policy and terms of conditions are fake, \njust to make fun of things, shouldn't take things seriously", "Disclaimer");
		popUp("This is a hello world login program in the 33rd century", "Welcome");
       
		new SuperGoodUI();
	}



}
