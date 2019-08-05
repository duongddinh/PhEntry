import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HidePopUpOPtion extends EssentialFunctions implements ActionListener{
	private static final long serialVersionUID = 1L;
	JFrame frameHide = new JFrame();
	JLabel instruc1[] = new JLabel[4];
	public HidePopUpOPtion() {
		frameHide = new JFrame("Hide pop Up options"); 
		allbocs[0] = new JCheckBox("Hide ALL popUp");
		allbocs[1] = new JCheckBox("Hide recommeded popUp");
		allbocs[2] = new JCheckBox("Hide \"Not show password\" recommendation popUp");
		allbocs[3] = new JCheckBox("Hide not recommended popUp");

		allbocs[0] .setSelected(hideAllP);
		allbocs[1] .setSelected(hideRP);
		allbocs[2] .setSelected(hideNSPP);
		allbocs[3] .setSelected(hideNRP);

		instruc1[0] = new JLabel("Note: hide all popUp will disable method call to ControlPanel.PopUp(str,str).");
		instruc1[1] = new JLabel("Otherwise, method call ControlPanel.PopUp(str,str) will be called depends on var bool.");
		instruc1[2] = new JLabel("You won't be able to hide start-up popUp because they are important.");
		instruc1[3] = new JLabel("Go to help if you need help (at main login screen).");

		JPanel panel = new JPanel();
		for(int i=0; i< allbocs.length; panel.add(allbocs[i++]));
		for(int i=0; i< allbocs.length; allbocs[i++].addActionListener(this));
		for(int i=0; i< instruc1.length; panel.add(instruc1[i++]));
		for(int i=0; i< instruc1.length; instruc1[i++].setForeground(Color.RED));
		frameHide.setResizable(false);
		frameHide.setSize(600, 200); 
		frameHide.setFocusable(true); 
		frameHide.setLocationRelativeTo(null);
		frameHide.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameHide.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				frameHide.dispose();
			}
		});
		frameHide.add(panel);
		frameHide.setVisible(true); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (allbocs[0].isSelected()) {
			hideAllP = true;
		} else {
			hideAllP = false;
		}
		if (allbocs[1].isSelected()) {
			hideRP =true;
			hideNSPP = true;
		} else {
			hideRP =false;
			if(allbocs[2].isSelected())
				hideNSPP = true;
			else 
				hideNSPP = false;

		}
		if (allbocs[2].isSelected()) {
			hideNSPP = true;
		} else {
			if (allbocs[1].isSelected())
				hideNSPP = true;

			else
				hideNSPP = false;

		}
		if (allbocs[3].isSelected()) {
			hideNRP = true;
		} else {
			hideNRP = false;

		}


	}
}
