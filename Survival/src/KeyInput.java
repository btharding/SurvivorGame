import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public static boolean[] arrowKeysDown = {false,false,false,false};

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			arrowKeysDown[0] = true;
		}
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			arrowKeysDown[3] = true;
		}
		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			arrowKeysDown[1] = true;
		}
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			arrowKeysDown[2] = true;
		}
		if(Game.gamestate == GameStates.Playing) {
			if(key == KeyEvent.VK_ENTER) {
				Game.gamestate = GameStates.Pause;
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			arrowKeysDown[0] = false;
		}				
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			arrowKeysDown[3] = false;
		}
		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			arrowKeysDown[1]=false;
		}
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			arrowKeysDown[2] = false;
		}
		if(key == KeyEvent.VK_SPACE) {
			new Breadcrumb(Game.player.getX()+16, Game.player.getY()+32);
			Player.food -= 2;
		}
		if(key == KeyEvent.VK_Z) {
			Game.player.eatDrink();
		}
		if(key == KeyEvent.VK_X) {
			Game.player.sleep();
		}
	}

}
