import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteLogF {
	static int cie =0;
	static int cef =0;
	public void writeLog(String wrr) {
		String cheee;
				cheee = System.getProperty("user.dir")+"/log.txt";
				BufferedWriter bw = null;
				FileWriter fw = null;
				try {
					fw = new FileWriter(cheee, true);
					bw = new BufferedWriter(fw);
					if (cie==0) {
				    DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime atm = LocalDateTime.now();  
					bw.write("===== Time execute: "+time.format(atm)+" ======\n");
					cie++;
					}
				    bw.write(wrr+"\n");
				} catch (IOException e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (bw != null)
							bw.close();
						if (fw != null)
							fw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

		 }
	}

