
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class CheckUpdate extends EssentialFunctions{
	private static final long serialVersionUID = 1L;
	private boolean stillqm = true;
	private String todis = "Checking for updates";
	private JFrame frameH; 
	private DrawCheck drc;
	private final Timer t;
	private boolean check = true;
	public CheckUpdate(){
		frameH = new JFrame("Checking update"); 
		drc= new DrawCheck(frameH);
		t = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//updating variables 
				drc.changec(todis);
				drc.repaint();
			}
		});
		t.start();
	}

	public void toRepaint(String todis) {
		drc.changec(todis);
		drc.repaint();
	}

	public void closeUpWindow() {
		frameH.setVisible(false);  
		frameH.dispose();
		stillqm = false;
	}

	public void checkup() throws Exception {

		frameH.getContentPane().add(BorderLayout.CENTER, drc); 
		frameH.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameH.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				stillqm = false;
				check = false;
				frameH.dispose();
			}
		});
		frameH.setResizable(false);
		frameH.setSize(300, 300); 	
		frameH.setLocationRelativeTo(null);
		frameH.setVisible(true);  

		while (stillqm) {
			try {
			checkhash();
			} catch(Exception e) {
				e.printStackTrace();
				wl.writeLog(e.toString());
			}
			toRepaint(todis);
			int cheee = drc.getVersion(); 
			BufferedReader br = null;
			StringBuilder fromcom = new StringBuilder();
			try {
				long tStart = System.currentTimeMillis();
				URL url = new URL(EssentialFunctions.getUpDateSource());
				br = new BufferedReader(new InputStreamReader(url.openStream()));
				String line;
				while (((line = br.readLine()) != null) &&check) {
					toRepaint(todis);
					long tEnd = System.currentTimeMillis();
					if ((tEnd - tStart)/1000.0 >= (10)) {
						todis = "Error checking update: Timed out!";
						System.out.println(todis);
						wl.writeLog(todis);
						popUp(todis, "Update");
						toRepaint(todis);
						closeUpWindow();
						return;
					}

					fromcom.append(line);
				}
				if (!check) {
					return;
				}
				t.stop();
			}catch (Exception e) {
				todis = "Error: Cannot connect to server!";
				System.out.println(todis);
				wl.writeLog(todis);
				popUp(todis,"Update");
				toRepaint(todis);
				closeUpWindow();
				return ;
			} finally {
				if (br != null) {
					br.close();
				}
			} 
			int c =Integer.valueOf(fromcom.toString());
			int d = cheee;
			if (c > d) {
				todis = "New version is available";
				System.out.println(todis + "current version: "+ d +"; newest version: "+ c);
				wl.writeLog(todis + "current version: "+ d +"; newest version: "+ c);
				toRepaint(todis);
				if (JOptionPane.showConfirmDialog((Component) null, "New version is available Do you want to update?\n new version:" +c+" your version: "+d,
						"Confirm", JOptionPane.YES_NO_OPTION) ==0) {
					todis = "Updating...";
					System.out.println("Updating");
					wl.writeLog("Updating");
					toRepaint(todis);
					updatedapro();

				} else
					closeUpWindow();
			}
			else {
				System.out.println("No new updates " + "current version: "+ d +"; newest version: "+ c);
				wl.writeLog("no new updates " + "current version: "+ d +"; newest version: "+ c);
				popUp("No new updates","Update");
				closeUpWindow();

			}

		}

	}

	private void checkhash() throws NoSuchAlgorithmException, IOException {
		
		InputStream in[] = new InputStream[2];
		in[0]=getClass().getResourceAsStream("TheGame.class");
		in[1]=getClass().getResourceAsStream("MainScreen.class");

		BufferedReader br = null;
		StringBuilder fromcom[] = new StringBuilder[2];
	    for(int i=0; i<fromcom.length;fromcom[i++] = new StringBuilder());
		URL url[] = new URL[2];
		
		url[0]= new URL(EssentialFunctions.getSuperGoodUIS());
		url[1]= new URL(EssentialFunctions.getMainScreen());
		for (int i =0; i< url.length; i++) {
			long tStart = System.currentTimeMillis();
			br = new BufferedReader(new InputStreamReader(url[i].openStream()));
			String line;
			while ((line = br.readLine()) != null) {	
				long tEnd = System.currentTimeMillis();
				if ((tEnd - tStart)/1000.0 >= (10)) {
					todis = "Error checking update: Timed out!";
					System.out.println(todis);
					wl.writeLog(todis);
					popUp(todis, "Error");
					toRepaint(todis);
					closeUpWindow();
					return;
				}
				fromcom[i].append(line);
			}

		}

		
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
		for (int i=0; i< in.length; i++) {
			if(!getFileChecksum(shaDigest, in[i]).equals(fromcom[i].toString())) {
				todis = "mismatched hash at "+ in[i] +"\n expected: "+fromcom[i]+  "\n reality:" + getFileChecksum(shaDigest, in[i]);
				System.out.println(todis);
				wl.writeLog(todis);
				popUp(todis, "Error");
			}
			else {
				todis = "hash matched "+ getFileChecksum(shaDigest, in[i]);
				System.out.println(todis);
				wl.writeLog(todis);
			}
		}


	}
	private String getFileChecksum(MessageDigest digest, InputStream fis) throws IOException{
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;
		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		};
		
		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< bytes.length ;i++)
		{
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	private void updatedapro() {
		try {
			URL updaterD = new URL(EssentialFunctions.getUpDaterSource());
			ReadableByteChannel ok = Channels.newChannel(updaterD.openStream());
			FileOutputStream okay = new FileOutputStream(System.getProperty("user.dir")+"Updater.jar");
			okay.getChannel().transferFrom(ok, 0, Long.MAX_VALUE);
			okay.close();
			ok.close();
			Runtime r= Runtime.getRuntime();
			r.exec("java -jar Updater.jar");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			wl.writeLog(e.toString());

		}

	}
}