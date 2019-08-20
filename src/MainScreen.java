import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MainScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {
		drawDabg(g);
	}
	private void drawDabg(Graphics g) {
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Nice1.gif"));
		g.drawImage(icon, 200, 100, this);
		this.repaint();
	}
}
