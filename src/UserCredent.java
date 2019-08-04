import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserCredent {
	public static boolean loginS = false;
	public static void createnew(String usercre, String pswwd) {
		if(checkexistuser()) {
			String cheee = System.getProperty("user.dir")+"/usercre.txt";
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(cheee, true);
				bw = new BufferedWriter(fw);
				bw.write(usercre+"\n");
				bw.write(pswwd+"\n");
				ControlPanel.popUp("Successfully created an account", "Nice!");
				ControlPanel.popUp("Logged in", "Log in successfully");

			} catch (IOException e2) {
				e2.printStackTrace();
				ControlPanel.popUp("Task failed successfully", "Not Nice!");

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
		} else {
			ControlPanel.popUp("You already have an account, you cannot create new", "Action can't be done");
		}

	}

	public static boolean checkexistuser() {
		BufferedReader reader;
		StringBuilder sb = null;
		try {
			reader = new BufferedReader(new FileReader(
					System.getProperty("user.dir")+"/usercre.txt"));
			sb = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(sb.equals(null)||String.valueOf(sb).equals("")||String.valueOf(sb).equals(" ")) {
			return true;
		}
		return false;
	}

	public static void login(String username, String password) {
		BufferedReader reader;
		String userCre[] = new String[2];
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/usercre.txt"));
			String line = reader.readLine();
			userCre[0] = line;

			while (line != null) {
				userCre[1] = line;
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!username.equals(userCre[0]) ||!password.equals(userCre[1]) ){
			ControlPanel.popUp("Wrong username or password\nIf you don't have an account, you can register new account", "Log in failed successfully");
		} else {
			ControlPanel.popUp("Logged in", "Log in successfully");
			loginS = true;
		}
	}



}
