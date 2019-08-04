import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SuperGoodUI extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public static boolean Accepted = false;
	public static JCheckBox privacyP = new JCheckBox("I don't ACCEPT TERMS AND CONDITIONS AND PRIVACY POLICY");
	WriteLogF wl = new WriteLogF();
	public SuperGoodUI() {
		frame = new JFrame("Nice register UI");  
		frame.setResizable(false);
		frame.setSize(800, 800); 
		frame.setFocusable(true); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				wl.writeLog("Terminated by user");
				System.out.println("Terminated by user");
				long endTime = System.currentTimeMillis();
				long timenee =  ((endTime- OverEngi.startTime) /1000);
				System.out.println("Time executed: "+ timenee + " seconds");
				wl.writeLog("Time executed: " + timenee + " seconds");
				System.exit(0);
			}
		});
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				periodicPop();
			}
		};
		Timer timer = new Timer();
		long delay = 1;
		long intevalPeriod = 1 * 30000; 
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
		privacyP.setSelected(true);
		privacyP.addActionListener(this);
		frame.add(this);
		frame.add(new ControlPanel(), BorderLayout.NORTH);
		frame.add(privacyP, BorderLayout.SOUTH);
		frame.setVisible(true); 
	}


	private void periodicPop() {
		if(!HidePopUpOPtion.hideRP)
			if(Math.random() < 0.5) {
				ControlPanel.popUp("Remeber to rate this app 5 stars on the store!!!","Improtant");
			}
			else {
				ControlPanel.popUp("We don't use cookies, so you need to accept by clicking ok!!","Important");

			}

	}

	public void paint(Graphics g) {
           drawDabg(g);

	}
	
	private void drawDabg(Graphics g) {
		if(!ControlPanel.isReadingPrvacy) {
			try {
				Image icon = new ImageIcon(new URL("https://i.pinimg.com/originals/c4/dd/5d/c4dd5d671bb86d8551e9697c2d9ece06.gif")).getImage();
				g.drawImage(icon, 230, 200, this);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}	
	}


	@Override
	public void actionPerformed(ActionEvent e) {	
		if(privacyP.isSelected()) {
			if(!HidePopUpOPtion.hideRP)
				ControlPanel.popUp("You gotta accept the terms and conditions to continue", "About");
			Accepted = false;
		} else {
			if(!HidePopUpOPtion.hideRP)
				ControlPanel.popUp("Make sure you read the terms and conditions\n are you sure you accept it?", "About");
			Accepted = true;

		}		
	}



}
