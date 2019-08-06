import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.UIManager;

public class TheGame extends EssentialFunctions{

	private static final long serialVersionUID = 1L;
	public static Timer timer;
	private ActionListener animation;
	public boolean isDone = false;
	private int x = 1000;
	private int x2 = 10000;
	private int y = 100;
	private int y2 = 150;
	private int c;
	private int yjum = 370;
	private boolean fly = false;
	private static boolean check = true;
	private boolean inmotion = false;
	public TheGame() {
		animation = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				repaint();
			}
		};
		timer = new Timer(50, animation);
	}
	public int ranBiom() {
		x-=30;
		return x;	
	}

	public void moveTheTHing(KeyEvent event) { 
		int key = event.getKeyCode(); 
		if (key == KeyEvent.VK_SPACE  && !inmotion) {
			fly = true;
			check = true;
		}
	}
	public int randomBiomeDistance() {
		Random randomness = new Random();
		int rand = randomness.nextInt(500)+500;
		return rand;
	}

	public int ranBiomL() {
		Random randomness = new Random();
		int rand = randomness.nextInt(200)+100;
		return rand;
	}


	boolean cc = true;
	public void logic() {
		if (x + y  <=0 && c + x2 + y2 <=0) {
			y = ranBiomL();
			y2 = ranBiomL();
			cc = true;
			x =1000;
			x2 = 10000;
		}
		c = ranBiom();

		if ((x+y < 1000) && cc) {
			x2 = randomBiomeDistance();
			y2 = ranBiomL();
			cc =false;

		}

		if(((50 <= c +y && 50 >=c) || (50 <= (c+x2+y2) && c >=(c+x2) )) &&yjum == 370  ) 
			die();

		if (fly) {
			inmotion = true;
			if (yjum > 250 && check) {
				yjum -=10;
				if(yjum ==250)
					check = false;
			}
			else if (yjum >= 250) {
				yjum +=15;
				if(yjum == 370) {

					fly = false;
					inmotion = false;

				}
			}
		}
	}

	public void reset() {
		x = 1000;
		y = 100;
		y2 = 150;
		yjum = 370;
		fly = false;
		check = true;
		inmotion = false;
	}

	public void die() {
		timer.stop();
		isDone  = true;
		allButton[15].setVisible(true);

	}

	public void paint(Graphics g) {
		logic();
		g.setColor(Color.CYAN);
		g.fillRect(0, 400, 1000, 150);

		g.setColor(UIManager.getColor( "Panel.background" ));

		g.fillRect(c, 400, y, 150);
		g.fillRect(c + x2, 400, y2, 150);
		g.setColor(Color.RED);
		g.fillOval( 50, yjum , 30, 30);
		if (isDone) {
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 2F);
			g.setFont(newFont);
			g.drawString("You Died", 250, 150);
			g.drawString("Press \"Play Again\" button to play again", 240, 190);

		}

	}
}
