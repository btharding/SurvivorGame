import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Window extends Canvas{
	public static JFrame frame;

	private static final long serialVersionUID = 1877720651231192133L;
	
	public Window(int width, int height, String title, Game game) {
		Window.frame = new JFrame(title);	
		
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	exitGame();
		    }
		});
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();

	}
	
	public static void exitGame() {
		Game.running = false;;
        frame.dispose();
        System.exit(0);
	}
	
}