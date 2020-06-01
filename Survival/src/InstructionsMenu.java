import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class InstructionsMenu extends Menu{

	public InstructionsMenu() {
		super(GameStates.Instructions);
		addButton(new Button(Game.WIDTH/2 - 100, 350, 200, 50, "RETURN", Game.WIDTH/2 - 65, 385, new Font("Arial", Font.BOLD, 30),this,GameStates.Start, Color.black, Color.white));
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("Try to survive", Game.WIDTH/2 - 125, 50);
		g.setFont(new Font("Arial", Font.ITALIC, 20));
		g.drawString("Explore the map to find food and water", Game.WIDTH/2 - 175, 150);
		g.drawString("and return to your shelter by the end of the night", Game.WIDTH/2 - 225, 175);
		g.drawString("Don't get lost, press space to drop a trail of breadcrumbs", 55, 225);
		g.drawString("Press Enter to pause at any time", Game.WIDTH/2 - 150, 275);
	}

}
