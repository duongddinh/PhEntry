import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;

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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Help extends EssentialFunctions {

	private static final long serialVersionUID = 1L;
	JFXPanel jfxPanel;
	static JPanel panel;
	public Help() {
		jfxPanel = new JFXPanel();  
		panel = new JPanel();
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
				webEngine.load("https://null0verflow.xyz/hackathon/docs/index.html");
				Worker<Void> worker = webEngine.getLoadWorker();
				ObservableList<Node> children = root.getChildren();
				progressBar.progressProperty().bind(worker.progressProperty());
				progressBar.setPrefSize(800, 10);
				children.addAll(browser,progressBar);                     
				jfxPanel.setScene(scene);  
			}  
		}); 
		panel.setLayout(new BorderLayout());  
		panel.add(jfxPanel, BorderLayout.CENTER);      
	}
	public  void showHelp() {

		SwingUtilities.invokeLater(new Runnable() {  
			@Override
			public void run() {  
				frame.getContentPane().add(panel,BorderLayout.CENTER);  
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);  
		        frame.revalidate();
		        frame.repaint();	
			}  
		});    

	}

	public static  void closeHelp(){
		frame.getContentPane().remove(panel);  
        frame.revalidate();
        frame.repaint();	
        }

}
