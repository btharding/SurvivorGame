import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Button {
	public static ArrayList<Button> buttons = new ArrayList<>();
	private int x, y, width, height, textX, textY;
	private Font font;
	private String text;
	private GameStates action;
	private Menu menu;
	private Color bgCol, textCol;
	
	public Button(int x, int y, int width, int height, String text, int textX, int textY, Font font, Menu menu, GameStates action, Color bgCol, Color textCol) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.textX = textX;
		this.textY = textY;
		this.font = font;
		this.menu = menu;
		this.action = action;
		this.bgCol = bgCol;
		this.textCol = textCol;
		Button.buttons.add(this);
	}
	
	public void render(Graphics g) {
		if(Game.mouseX >= this.x && Game.mouseX <= this.x + this.width && Game.mouseY >= this.y && Game.mouseY <= this.y + this.height) {
			g.setColor(bgCol);
			g.fillRect(x-3, y-3, width+6, height+6);
			g.setColor(textCol);
			g.drawRect(x-3, y-3, width+6, height+6);
			g.setFont(font);
			g.drawString(text, textX, textY);
		}else {
			g.setColor(bgCol);
			g.fillRect(x, y, width, height);
			g.setColor(textCol);
			g.drawRect(x, y, width, height);
			g.setFont(font);
			g.drawString(text, textX, textY);
		}
	}
	
	public void click() {
		Game.gamestate = action;
	}
	
	public Menu getMenu() {
		return this.menu;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}

}
