import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class UserCredent {
	public static boolean loginS = false;
	public static String currentUser ="";
	public static boolean doDis = false;
	public static String line1 = "false";
	public static void createnew(String usercre, String pswwd) {
		currentUser = usercre;
		if(checkexistuser()) {
			String cheee = System.getProperty("user.dir")+"/usercre.txt";
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(cheee, true);
				bw = new BufferedWriter(fw);
				bw.write(usercre+"\n");
				bw.write(getHash(pswwd)+"\n");
				ControlPanel.popUp("Successfully created an account", "Nice!");
				ControlPanel.popUp("Logged in", "Log in successfully");
				doDis = true;
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
			if(ControlPanel.confirm("You already have an account, you cannot create new\n Do you want to remove current User can create new?")==0) {
				removeUser();
			}
		}

	}

	public static boolean checkexistuser() {
		BufferedReader reader;
		StringBuilder sb = null;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/usercre.txt"));
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

	private static String getFistLine(String name) {
		BufferedReader reader1 = null;
		String daline = "";
		try {
			reader1 = new BufferedReader(new FileReader(System.getProperty("user.dir")+name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			daline = reader1.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return daline;
	}

	public static void keepLogged() {
		line1 = getFistLine("/keepL.txt");
		if (Boolean.parseBoolean(line1)) {
			currentUser = getFistLine("/usercre.txt");
		}

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
		if (!username.equals(userCre[0]) ||!getHash(password).equals(userCre[1]) ){
			ControlPanel.popUp("Wrong username or password\nIf you don't have an account, you can register new account", "Log in failed successfully");
		} else {
			ControlPanel.popUp("Logged in", "Log in successfully");
			loginS = true;
			currentUser = userCre[0];
		}
	}

	private static void removeUser() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(System.getProperty("user.dir")+"/usercre.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.print("");
		writer.close();
		ControlPanel.popUp("Removed user", "removed successfully");

	}

	public static String getHash(String pssd) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest = md.digest(pssd.getBytes(StandardCharsets.UTF_8));
		return DatatypeConverter.printHexBinary(digest).toLowerCase();
	}

}
