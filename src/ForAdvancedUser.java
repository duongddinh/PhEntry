import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ForAdvancedUser extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();;
	JButton ok;
	JTextField question1 = new JTextField(EssentialFunctions.getUpDateSource(),21);
	JTextField question0 = new JTextField(EssentialFunctions.getMainScreen(),21);
	JTextField question2 = new JTextField(EssentialFunctions.getSuperGoodUIS(), 21);
	JTextField question4 = new JTextField(EssentialFunctions.getUpDaterSource(), 21);
	JButton changeGame;
	JLabel instruc = new JLabel("Checking update source:");
	JLabel instruc1 = new JLabel("Checking Hash for MainScreen.class source");
	JLabel instruc2 = new JLabel("Checking Hash for TheGame.class source");
	JLabel instruc4 = new JLabel("Downloading Updater Source");
	JLabel instruc5 = new JLabel("Be careful of untrusted sources; the only trusted source (til now) is my github");

	public ForAdvancedUser() {
		frame = new JFrame("Advanced setup"); 
		try {
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ok = new JButton("Ok");
		changeGame = new JButton("Change game");

		if ( Boolean.parseBoolean(EssentialFunctions.getFistLine("/lang.txt"))) {
			instruc.setText("Comprobando la fuente de actualización");
			instruc1.setText("Comprobando hash para la fuente MainScreen.class");
			instruc2.setText("Comprobando hash para la fuente TheGame.class");
			instruc4.setText("Descargando la fuente Updater");
			instruc5.setText("Se cuidadoso con las fuentes no confiables; la única fuente confiable (hasta ahora) es mi github");
			changeGame.setText("Cambiar juego");
		} 

		instruc5.setForeground(Color.RED);
		panel.add(instruc);
		panel.add(question1);
		panel.add(instruc1);
		panel.add(question0);
		panel.add(instruc2);
		panel.add(question2);
		panel.add(instruc4);
		panel.add(question4);
		panel.add(ok);
		panel.add(instruc5);
		panel.add(changeGame);

		ok.addActionListener(this);
		changeGame.addActionListener(this);

		frame.setResizable(false);
		frame.setSize(600, 300); 
		frame.setFocusable(true); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				frame.dispose();
			}
		});
		frame.add(panel);
		frame.setVisible(true); 

	}

	public void newSource(String where, String namesource) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(System.getProperty("user.dir")+where);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		writer.print(namesource);
		writer.close();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if(s.equals("ok")) {
			newSource(question1.getText(), "/updateSource.txt");
			newSource(question0.getText(), "/MainScreen.txt");
			newSource(question2.getText(), "/TheGame.txt");
			newSource(question4.getText(), "/UpdaterSource.txt");
		}
		if (s.equals("Change game") || s.equals("Cambiar juego")) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://frychicken.github.io/PhEntry/docs/index.html");
					desktop.browse(uri);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
}
