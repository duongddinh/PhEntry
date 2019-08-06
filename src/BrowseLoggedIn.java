import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.javafx.application.PlatformImpl;

import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class BrowseLoggedIn extends EssentialFunctions{

	private static final long serialVersionUID = 1L;
	JFXPanel jfxPanel;
	JPanel panel1;
	public  BrowseLoggedIn() {
		jfxPanel = new JFXPanel();  
		panel1 = new JPanel();
		PlatformImpl.startup(new Runnable() {  
			@Override
			public void run() {  
				ProgressBar progressBar = new ProgressBar();
				Stage stage = new Stage();  
				Group root = new Group();  
				Scene scene = new Scene(root,80,20);  
				stage.setScene(scene);  
				WebView browser = new WebView();
				WebEngine webEngine = browser.getEngine();
				webEngine.load("https://null0verflow.xyz/hackathon/index.html?username="+getFistLine("/usercre.txt")+"&password=thisisnotapass");
				Worker<Void> worker = webEngine.getLoadWorker();
				ObservableList<Node> children = root.getChildren();
				progressBar.progressProperty().bind(worker.progressProperty());



				progressBar.setPrefSize(800, 10);
				children.addAll(browser,progressBar);                     
				jfxPanel.setScene(scene);  
			}  
		}); 
		panel1.setLayout(new BorderLayout());  
		panel1.add(jfxPanel, BorderLayout.CENTER);      
	}

	public void doingit() {
		SwingUtilities.invokeLater(new Runnable() {  
			@Override
			public void run() {  
				frame.getContentPane().add(panel1, BorderLayout.CENTER);  
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);  
				frame.revalidate();
				frame.repaint();
			}  
		}); 


	}

	public void remove() {
		frame.getContentPane().remove(panel1);  
		frame.revalidate();
		frame.repaint();

	}


}
