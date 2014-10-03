import javax.swing.JFrame;
import java.awt.Color;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeViewer {


	private static int numOfBases;
	private static Color groundColor;
	private static int[] color;
	private static int width;
	private static int height;

	public CityscapeViewer(int[] color) {
		this.numOfBases = 6;
		this.color = color;
		this.groundColor = new Color(color[0], color[1], color[2]);
		this.width = 800;
		this.height = 600;
	}

	public static void main() {
		JFrame frame = new JFrame();

		frame.setSize(width, height);
		frame.setTitle("Missile Command");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CityscapeComponent component = new CityscapeComponent(width, height, numOfBases, groundColor);

		frame.add(component);

		frame.setVisible(true);

		while (true) {
			component.repaint();
		}
	}
}
