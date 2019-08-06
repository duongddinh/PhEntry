
import java.awt.*;
import javax.swing.JFrame;
public class DrawCheck extends Component {
	private String todis = "Checking for updates";
	private static final long serialVersionUID = 1L;
	public static int x = 10;
	private double f;
	public static double strin=1;
	private String display;
	private String msg[] = new String[8];
	private int f2 =(int)(Math.random() * ((7 - 0) + 1)) + 0;
	public DrawCheck(JFrame frame) {

	}
	@Override
	public void paint(Graphics g) {
		g.drawString(todis, 80,150);
		g.setColor(Color.BLACK);

		g.drawString((int)strin + "%", 140, 210);
		g.setColor(Color.BLACK);
		g.drawRect(105, 180, 90, 10);
		g.setColor(Color.BLUE);
		g.fillRect(105, 180, x, 10);

		drawdouknow(g);
	}
	public void changec(String todis) {
		this.todis = todis;
		x++; 
		f = x;
		if (strin >100) {
			x = 10;
		}
		if (strin == 50 ) {
			f2 = (int)(Math.random() * ((7 - 0) + 1)) + 0;
		}

		strin = (double)(f/90)*100; 
		strin = Math.ceil(strin);

		msg[0] = "You can click \"help\" in the setup menu to get help";
		msg[1] = "Sometimes, the program does something not expected";
		msg[2] = "ProgrammerHumor hackathon!";
		msg[3] = "Array starts at 0!";
		msg[4] = "If you still see this, the program might crash lol";
		msg[5] = "You might wanna close this because it is taking too long";
		msg[6] = "If this stucks at 13% then close this window :v";
		msg[7] = "Log is at"+System.getProperty("user.dir");

		display = msg[f2];
	}

	private void drawdouknow(Graphics f) {


		f.setFont(new Font("default", Font.ITALIC, 10));
		f.setColor(Color.BLACK);
		f.drawString(display, 20,120);
	}
	public int getVersion() {
		return 1; 
	}
}
