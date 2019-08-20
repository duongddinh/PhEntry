import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class Update {
	private JFrame frame; 
	private final Timer t;
	private String todis = "Updating";

	UpdateInter ui = new UpdateInter();
	public Update() {
		frame = new JFrame("Checking update"); 
		ui= new UpdateInter();
		t = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//updating variables 
				ui.changec(todis);
				ui.repaint();
			}
		});
		t.start();
	}
	
public void update() {
	int fail = 1;
	frame.getContentPane().add(BorderLayout.CENTER, ui); 
	frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent evt) {
			frame.dispose();
		}
	});
	frame.setResizable(false);
	frame.setSize(300, 300); 	
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);  
	try {
		URL website = new URL("https://raw.githubusercontent.com/frychicken/PhEntry/master/JarFiles/LogInForm.jar");
		ReadableByteChannel ok = Channels.newChannel(website.openStream());
		FileOutputStream okay = new FileOutputStream(System.getProperty("user.dir")+"/LogInForm.jar");
		okay.getChannel().transferFrom(ok, 0, Long.MAX_VALUE);
		okay.close();
		ok.close();
	} catch (Exception e) {
		System.out.println("Update failed");
		todis = "update failed";
		fail =0;
		e.printStackTrace();
	}
	Runtime r= Runtime.getRuntime();
	try {
		r.exec("java -jar LogInForm.jar " + fail);
	} catch (IOException e) {
		e.printStackTrace();
	}
	todis = "Update completed";
	System.exit(0);
}
}
