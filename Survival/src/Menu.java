import java.awt.Graphics;
import java.util.ArrayList;

public class Menu {
	public static ArrayList<Menu> menus = new ArrayList<>();
	private ArrayList<Button> buttons = new ArrayList<>();
	private GameStates state;
	
	
	public Menu(GameStates state) {
		this.state = state;
		menus.add(this);
	}
	public void addButton(Button button) {
		buttons.add(button);
	}
	
	public GameStates getState() {
		return this.state;
	}
	public ArrayList<Button> getButtons(){
		return this.buttons;
	}
	public void render(Graphics g) {
		for(int i =0; i<buttons.size(); i++) {
			buttons.get(i).render(g);
		}
	}

}
