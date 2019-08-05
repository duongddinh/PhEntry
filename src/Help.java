import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Help extends EssentialFunctions {

	private static final long serialVersionUID = 1L;
	private static JFrame frameHelp;
	JFXPanel jfxPanel;
	public Help() {
		jfxPanel = new JFXPanel();  
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
				webEngine.load("https://raw.githubusercontent.com/frychicken/PoolTableSimulator/master/README.MD");
				Worker<Void> worker = webEngine.getLoadWorker();
				ObservableList<Node> children = root.getChildren();
				progressBar.progressProperty().bind(worker.progressProperty());
				progressBar.setPrefSize(800, 10);
				children.addAll(browser,progressBar);                     
				jfxPanel.setScene(scene);  
			}  
		}); 
		setLayout(new BorderLayout());  
		add(jfxPanel, BorderLayout.CENTER);      
	}
	public  void showHelp() {

		SwingUtilities.invokeLater(new Runnable() {  
			@Override
			public void run() {  
				frameHelp = new JFrame("Help");  
				frameHelp.getContentPane().add(new Help());  
				frameHelp.setMinimumSize(new Dimension(800, 600));  
				frameHelp.setLocationRelativeTo(null);
				frameHelp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);  
				frameHelp.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent evt) {
						ControlPanel.havereadh = true;
						ControlPanel.isReadingHelp = false;
						ControlPanel.allButton[4].setVisible(false);
						ControlPanel.allButton[3].setVisible(true);
						frameHelp.dispose();
					}
				});
				frameHelp.setVisible(true);  
			}  
		});    

	}

	public static  void closeHelp(){
		frameHelp.dispose();
	}

}
