import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1930825029999864569L;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int WIDTH_BORDER = 14;
	public static final int HEIGHT_BORDER = 37;
	public static final String TITLE = "Survivor";

	
	public static Thread gameThread;
	static boolean running = false;
	
	public static Loader loader = new Loader();
	public static Random random = new Random();
	public static Handler handler = new Handler();
	public static Map map= new Map(10,10,75);
	public static Player player = new Player(Game.WIDTH/2,Game.HEIGHT/2);
	public static int day = 0;
	public static DialogueBox dialogueBox = new DialogueBox();
	public static Window window;
	public static int animTimer = 0;
	public static int mouseX, mouseY = 0;
	public static GameStates gameState;
	public static Mask mask = new Mask();
	public static String message = "";
	public static int timer = 12000;
	public static StartMenu startMenu = new StartMenu();
	public static InstructionsMenu instructionsMenu = new InstructionsMenu();
	public static PauseMenu pauseMenu = new PauseMenu();
	public static DeadMenu deadMenu = new DeadMenu();
	public static GameStates gamestate = GameStates.Reset;
	public static boolean isNight = false;

	public static void main(String[] args){
		new Game();		
	}	
	
	public Game() {
		this.addKeyListener(new KeyInput());
		this.addMouseListener(new MouseInput());
		this.addMouseMotionListener(new MouseInput());
		window = new Window(WIDTH+WIDTH_BORDER, HEIGHT+HEIGHT_BORDER, TITLE, this);
	}
	
	public synchronized void start() {
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
		this.requestFocus();
	}
	
	public synchronized void stop() {
		try {
			gameThread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		//int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
				//frames ++;
			
				if(System.currentTimeMillis() - timer >1000) {
					timer += 1000;
					//frames = 0;
				}
			}
		}
		stop();
	}
	
	private void tick() {
		if(gamestate == GameStates.Playing) {
			timer --;
			if(timer ==0) {
				timer = 12000;
				isNight = !isNight;
				if(!isNight) {
					Game.day++;
				}
			}
			if(animTimer > 9) {
				animTimer = 0;
			}
			animTimer++;
			handler.tick();
			Map.tick();
			if(isNight) {
				Mask.tick();
			}
		}else if(gamestate == GameStates.Exit) {
			Window.exitGame();
		}
	}
	
	private void render() {
		if(running) {
			BufferStrategy bs = this.getBufferStrategy();
			if(bs == null) {
				this.createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			if(gamestate == GameStates.Start) {
				startMenu.render(g);
			}else if(gamestate == GameStates.Instructions) {
				instructionsMenu.render(g);
			}else if(gamestate == GameStates.Pause) {
				pauseMenu.render(g);
			}else if(gamestate == GameStates.Dead) {
				deadMenu.render(g);
			}else {
				Map.render(g);
				handler.render(g);
				
				if(isNight) {
					Mask.render(g);
				}
				
				dialogueBox.render(g);
			}
			g.dispose();
			bs.show();
		}
	}


}
