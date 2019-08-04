import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;

import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JPanel;
import javafx.concurrent.Worker;

public class Help extends JPanel {
	private static final long serialVersionUID = 1L;
	private static JFXPanel jfxPanel;  

	public static void showHelp() {
		PlatformImpl.startup(new Runnable() {  
			@Override
			public void run() {
				ProgressBar progressBar = new ProgressBar();
				jfxPanel = new JFXPanel();  
				Stage stage = new Stage();  
				Group root = new Group();  
				Scene scene = new Scene(root,80,20);  
				stage.setScene(scene);  
				WebView browser = new WebView();
				WebEngine webEngine = browser.getEngine();
				webEngine.load("https://raw.githubusercontent.com/frychicken/PoolTableSimulator/master/README.MD");
				Worker<Void> worker = webEngine.getLoadWorker();
				progressBar.progressProperty().bind(worker.progressProperty());
				ObservableList<Node> children = root.getChildren();
				children.addAll(browser, progressBar);                     
				jfxPanel.setScene(scene);  
				SuperGoodUI.frame.getContentPane().add(jfxPanel, BorderLayout.CENTER);
				SuperGoodUI.frame.setLocationRelativeTo(null);
				SuperGoodUI.frame.setVisible(true);	
				SuperGoodUI.frame.revalidate();
				SuperGoodUI.frame.repaint();
			}  
		});    

	}

	public static void closeHelp() {
		SuperGoodUI.frame.getContentPane().remove(jfxPanel);
		SuperGoodUI.frame.setLocationRelativeTo(null);
		SuperGoodUI.frame.setVisible(true);	
		SuperGoodUI.frame.revalidate();
		SuperGoodUI.frame.repaint();

	}

}
