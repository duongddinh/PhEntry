import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MainScreen extends Component{
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
