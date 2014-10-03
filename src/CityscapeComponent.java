import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeComponent extends JComponent{
	private static int numOfBases;
	private static Color groundColor;

	public CityscapeComponent(int numOfBases, Color groundColor) {
		this.numOfBases = numOfBases;
		this.groundColor = groundColor;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Cityscape cityscape = new Cityscape(numOfBases, groundColor);

		cityscape.draw(g2);
	}
}
