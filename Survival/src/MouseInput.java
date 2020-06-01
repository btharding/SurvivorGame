import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MouseInput implements MouseListener, MouseMotionListener{
	
	
	public void mouseClicked(MouseEvent e) {
		for(int i =0; i < Menu.menus.size(); i++) {
			Menu temp = Menu.menus.get(i);
			if(temp.getState() == Game.gamestate) {
				ArrayList<Button> buttons = temp.getButtons();
				for(int j = 0; j<buttons.size(); j++) {
					Button button = buttons.get(j);
					if(e.getX() >= button.getX() && e.getX() <= button.getX() + button.getWidth() && e.getY() >= button.getY() && e.getY() <= button.getY() + button.getHeight()) {
						button.click();
						return;
					}
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}
	
	public void mouseMoved(MouseEvent e) {
		Game.mouseX = e.getX();
		Game.mouseY = e.getY();
	}

}
