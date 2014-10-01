import javax.swing.JFrame;
import java.awt.Color;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeViewer {


	private static int numOfBases;
	private static Color groundColor;
	private static int[] color;

	public CityscapeViewer(int[] color) {
		this.numOfBases = 6;
		this.color = color;
		this.groundColor = new Color(color[0], color[1], color[2]);
	}

	public static void main() {
		JFrame frame = new JFrame();

		frame.setSize(800, 600);
		frame.setTitle("Missile Command");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CityscapeComponent component = new CityscapeComponent();

		frame.add(component);

		frame.setVisible(true);

		while (true) {
			component.repaint();
		}
	}
}
