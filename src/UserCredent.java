import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class UserCredent extends EssentialFunctions{
	private static final long serialVersionUID = 1L;

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
				popUp("Successfully created an account", "Nice!");
				popUp("Logged in", "Log in successfully");
				wl.writeLog("Created an account");
				doDis = true;
			} catch (IOException e2) {
				e2.printStackTrace();
				wl.writeLog(e2.toString());
				popUp("Task failed successfully", "Not Nice!");

			} finally {
				try {
					if (bw != null)
						bw.close();
					if (fw != null)
						fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					wl.writeLog(ex.toString());

				}
			}
		} else {
			if(confirm("You already have an account, you cannot create new\n Do you want to remove current User can create new?")==0) {
				removeUser();
			}
		}

	}

	public static boolean checkexistuser() {
		if((new File(System.getProperty("user.dir")+"/usercre.txt")).exists()) {
			return true;
		}
		return false;
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
			wl.writeLog(e.toString());

		}
		if (!username.equals(userCre[0]) ||!getHash(password).equals(userCre[1]) ){
			popUp("Wrong username or password\nIf you don't have an account, you can register new account", "Log in failed successfully");
		} else {
			popUp("Logged in", "Log in successfully");
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
			wl.writeLog(e.toString());

		}
		writer.print("");
		writer.close();
		wl.writeLog("Removed user");
		popUp("Removed user", "removed successfully");

	}

	public static String getHash(String pssd) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			wl.writeLog(e.toString());

		}
		byte[] digest = md.digest(pssd.getBytes(StandardCharsets.UTF_8));
		return DatatypeConverter.printHexBinary(digest).toLowerCase();
	}

}
