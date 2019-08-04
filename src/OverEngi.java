
public class OverEngi {
	public static long startTime;

	public static void main(String args[]) {
		startTime = System.currentTimeMillis();

		CheckUpdate ccu= new CheckUpdate();
		try {
			ccu.checkup();
		} catch (Exception e) {
			e.printStackTrace();
			ccu.popUp("Error occurs while loading update");
			ccu.closeUpWindow();
		}
		ControlPanel.popUp("This is likely a parody", "disclaimer");
		ControlPanel.popUp("Privacy Policy and terms of conditions are fake, \njust to make fun of things, shouldn't take things seriously", "Disclaimer");
		ControlPanel.popUp("This is a hello world login program in the 33rd century", "Welcome");

		new SuperGoodUI();
	}



}
