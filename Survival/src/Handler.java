import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i<objects.size(); i++) {
			GameObject object = objects.get(i);
			object.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i<objects.size(); i++) {
			GameObject object = objects.get(i);
			if(object.getId() != ID.FlashLight) {
				object.render(g);
			}
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
}
