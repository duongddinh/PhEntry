import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Main extends JFrame implements ActionListener{
    static ChangeInterf ui = new ChangeInterf();
	private static final long serialVersionUID = 1L;
	static JTextField txtboc;
	static JTextField txtboc2;
	private static Frame bobJFrame;
	private final Timer t;
	static JFrame frame;
	static JFrame frame1;
	String todis = "Changing...";
	public Main() {
		frame1 = new JFrame("Update jar"); 
		ui= new ChangeInterf();
		ui.changec(todis);
		frame1.getContentPane().add(BorderLayout.CENTER, ui); 
		frame1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame1.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				frame.dispose();
			}
		});
		frame1.setResizable(false);
		frame1.setSize(300, 300); 	
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);  
		
		t = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//updating variables 
				ui.changec(todis);
				ui.repaint();
			}
		});
		t.start();
	}
	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String jaf ="";
		String jaf2="";
		String jaf1="";
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		FileDialog fd = new FileDialog(bobJFrame, "Choose a .java", FileDialog.LOAD);
		fd.setDirectory("");
		fd.setFile("*.java");
		fd.setFilenameFilter((dir, name) -> name.endsWith(".java"));
		fd.setVisible(true);
		jaf2 =fd.getDirectory();
		jaf1 = fd.getFile();	 
		if (jaf1 == null) {
			System.exit(0);
		}
		
		FileDialog fd2 = new FileDialog(bobJFrame, "Choose a .jar", FileDialog.LOAD);
		fd2.setDirectory("");
		fd2.setFile("*.jar");
		fd2.setFilenameFilter((dir, name) -> name.endsWith(".jar"));
		fd2.setVisible(true);
		jaf =fd2.getDirectory();
		if (jaf == null) {
			System.exit(0);
		}
		File f1 = new File(jaf2+jaf1);
		File f2 = new File(jaf+"TheGame.java");
		f1.renameTo(f2);

		frame = new JFrame("Game Change");

		txtboc = new JTextField("javac TheGame.java EssentialFunctions.java WriteLogF.java MainScreen.java HidePopUpOPtion.java");  
		txtboc2 = new JTextField("jar uf LogInForm.jar TheGame.class TheGame$1.class");  

		JLabel lblLabel = new JLabel("Enter your command to compile (if you don't know, leave it as it is)");
		JLabel lblLabel2 = new JLabel("ie jar uf  LogInForm.jar TheGame.class TheGame$1.class st.class st.class");

		final URI uri = new URI("https://github.com/frychicken/PhEntry/tree/master/src");
		JButton button2 = new JButton();
		button2.setText("important dependencie(s): EssentialFunctions, WriteLogF");
		button2.setHorizontalAlignment(SwingConstants.LEFT);
		button2.setBorderPainted(false);
		button2.setOpaque(false);
		button2.setForeground(Color.RED);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.setToolTipText("Go to website");
		HashMap<TextAttribute, Object> textAttrMap = new HashMap<TextAttribute, Object>();
		textAttrMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button2.setFont(button2.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		button2.setFont(button2.getFont().deriveFont(textAttrMap));
		button2.setBackground(Color.lightGray);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		final URI uri2 = new URI("https://frychicken.github.io/PhEntry/docs/index.html");
		JButton button3 = new JButton();
		button3.setText("help");
		button3.setHorizontalAlignment(SwingConstants.LEFT);
		button3.setBorderPainted(false);
		button3.setOpaque(false);
		button3.setForeground(Color.BLUE);
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.setToolTipText("? - Display help");
		HashMap<TextAttribute, Object> textAttrMap2 = new HashMap<TextAttribute, Object>();
		textAttrMap2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button3.setFont(button3.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		button3.setFont(button3.getFont().deriveFont(textAttrMap2));
		button3.setBackground(Color.lightGray);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri2);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		JButton  button = new JButton("Okay");
		Main loen = new Main(); 
		button.addActionListener(loen); 
		JPanel panel = new JPanel(); 
		panel.add(lblLabel);
		panel.add(txtboc);
		panel.add(txtboc2);
		panel.add(lblLabel2);
		panel.add(button2);
		panel.add(button3);
		panel.add(button);
		frame.add(panel);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);       
		
	}
	public void actionPerformed(ActionEvent e) { 	
		String s = e.getActionCommand(); 
		if (s.equals("Okay") ) { 
			frame.setVisible(false);
			Runtime r= Runtime.getRuntime();
			try {
				Process proc1 = r.exec(txtboc.getText());
				BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
				BufferedReader stdError1 = new BufferedReader(new InputStreamReader(proc1.getErrorStream()));
				String s2 = null;
				while ((s2 = stdInput1.readLine()) != null) {
					todis = s2;
				    System.out.println(s2);
				}

				while ((s2 = stdError1.readLine()) != null) {
					todis = s2;
				    System.out.println(s2);
				}
				Thread.sleep(2000);
				Process proc  = r.exec(txtboc2.getText());
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
				String s1 = null;
				while ((s1 = stdInput.readLine()) != null) {
					todis = s1;
				    System.out.println(s1);
				}

				while ((s1 = stdError.readLine()) != null) {
					todis = s1;
				    System.out.println(s1);
				}
				
				System.out.println("Done");
				ChickenIsNotFood();
				r.exec("java -jar LogInForm.jar");
				System.exit(0);
			} catch (IOException ez) {
				ez.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public int ChickenIsNotFood() throws Exception {
		return JOptionPane.showConfirmDialog((Component) null, "Done\n " + todis,
				"Done", JOptionPane.CLOSED_OPTION);
	}
}
