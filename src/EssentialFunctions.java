import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

abstract class EssentialFunctions extends JPanel {
	private static final long serialVersionUID = 1L;
	protected static boolean isReadingHelp = false;
	protected boolean havereadp = false;
	protected static boolean havereadh = false;
	protected boolean havereadt = false;
	protected static boolean isReadingPrvacy = false;
	protected static JButton allButton[] = new JButton[12];
	protected static boolean keepLogg = false;
	protected static boolean readterms = false;
	protected JCheckBox keepLogged = new JCheckBox("Keep Logged in");
	protected JCheckBox playsound = new JCheckBox("Play sound");
	protected JCheckBox darkmode = new JCheckBox("Dark-mode");
	protected static JFrame frame;
	protected static boolean Accepted = false;
	protected static boolean hideAllP = false;
	protected static boolean hideRP = false;
	protected static boolean hideNSPP = false;
	protected static boolean hideNRP = false;
	protected static boolean loginS = false;
	protected static String currentUser ="";
	protected static boolean doDis = false;
	protected static String line1 = "false";
	protected static String isNightMode = "false";
	protected static JCheckBox allbocs[] = new JCheckBox[4];
	protected static JCheckBox privacyP = new JCheckBox("I don't ACCEPT TERMS AND CONDITIONS AND PRIVACY POLICY");
	protected static WriteLogF wl = new WriteLogF();
	protected static void popUp(String todis, String title) {
		if (!HidePopUpOPtion.hideAllP) {
			JOptionPane.showMessageDialog((Component) null, todis,
					title, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	protected static int confirm(String todis) {
		return JOptionPane.showConfirmDialog((Component) null, todis,
				"Confirm", JOptionPane.YES_NO_OPTION);
	}
	protected static String getFistLine(String name) {
		BufferedReader reader1 = null;
		String daline = "false";
		String cheee = System.getProperty("user.dir")+name;
		try {
			FileWriter fw = new FileWriter(cheee, true);
             fw.close();
			reader1 = new BufferedReader(new FileReader(cheee));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			wl.writeLog(e.toString());

		} catch (IOException e) {
			e.printStackTrace();
			wl.writeLog(e.toString());

		}
		try {
			daline = reader1.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			wl.writeLog(e.toString());

		}
		try {
			reader1.close();
		} catch (IOException e) {
			e.printStackTrace();
			wl.writeLog(e.toString());
		}
		return daline;
	}
	protected static void isNightMode() {
		isNightMode = getFistLine("/nightmode.txt");
	}
}
