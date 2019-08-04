import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BruteForce {
	private static Frame bobJFrame;

	public static void doingit() {
		boolean found = false;
		boolean ado = true;
		BufferedReader reader;
		FileDialog fd = new FileDialog(bobJFrame, "Choose a wordlist that ends with .txt", FileDialog.LOAD);
		fd.setDirectory("");
		fd.setFile("*.txt");
		fd.setFilenameFilter((dir, name) -> name.endsWith(".txt"));
		fd.setVisible(true);
		if (fd.getFile() == null) {
			ado = false;
		}
		if(ado) {
			try {
				reader = new BufferedReader(new FileReader(fd.getDirectory()+"/"+ fd.getFile()));
				String line = reader.readLine();
				if(UserCredent.getHash(line).equals(getPass())) {
					ControlPanel.popUp("The password is: "+ line, "Password found!!");
					reader.close();
					line=null;
					found = true;
				}
				while (line != null) {
					if(UserCredent.getHash(line).equals(getPass())) {
						ControlPanel.popUp("The password is: "+ line, "Password found!!");
						reader.close();
						return;
					}
					line = reader.readLine();


				}
				if(!found)
					ControlPanel.popUp("Cannot find the password in the dictionary you provided", "Password Not found!!");
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getPass() {
		BufferedReader reader;
		String password ="";
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/usercre.txt"));
			String line = reader.readLine();


			while (line != null) {
				password = line;
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return password;

	}


}


