import java.awt.Graphics;
import java.util.ArrayList;

public class Map {
	private static int mapWidth, mapHeight, numRooms;
	public static Room[][] map;
	public static ArrayList<ArrayList<Integer>> occupiedRooms = new ArrayList<>();//[x,y]
	private static ArrayList<ArrayList<Integer>> available = new ArrayList<>();//[x,y]
	
	public Map(int mapWidth, int mapHeight, int numRooms) {
		Map.mapWidth = mapWidth;
		Map.mapHeight = mapHeight;
		Map.numRooms = numRooms;
		Map.map = new Room[Map.mapHeight][Map.mapWidth];
		generateMap();
	}
	
	public static void generateMap() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(Game.random.nextInt(Map.mapWidth));
		temp.add(Game.random.nextInt(Map.mapHeight));
		Map.map[temp.get(1)][temp.get(0)] = new Room(new Tent(Game.WIDTH/2-25, Game.HEIGHT/2-35));
		Map.occupiedRooms.add(temp);
		addNeighbours(temp);
		while(Map.occupiedRooms.size()<=Map.numRooms) {
			System.out.println();
			temp = Map.available.get(Game.random.nextInt(Map.available.size()));
			Map.map[temp.get(1)][temp.get(0)] = new Room();
			Map.available.remove(temp);
			Map.occupiedRooms.add(temp);
			Map.addNeighbours(temp);
		}
		addBorders();
	}
	
	
	public static void addNeighbours(ArrayList<Integer> coords) {
		if(coords.get(0)!=0) {
			ArrayList<Integer> left = new ArrayList<>();
			left.add(coords.get(0)-1);
			left.add(coords.get(1));
			if(Map.occupiedRooms.contains(left)==false) {
				if(Map.available.contains(left)==false) {
					Map.available.add(left);
				}
			}
		}
		if(coords.get(0)!=Map.mapWidth-1) {
			ArrayList<Integer> right = new ArrayList<>();
			right.add(coords.get(0)+1);
			right.add(coords.get(1));
			if(Map.occupiedRooms.contains(right)==false) {
				if(Map.available.contains(right)==false) {
					Map.available.add(right);
				}
			}
		}
		if(coords.get(1)!=0) {
			ArrayList<Integer> up = new ArrayList<>();
			up.add(coords.get(0));
			up.add(coords.get(1)-1);
			if(Map.occupiedRooms.contains(up)==false) {
				if(Map.available.contains(up)==false) {
					Map.available.add(up);
				}
			}
		}
		if(coords.get(1)!=Map.mapHeight-1) {
			ArrayList<Integer> down = new ArrayList<>();
			down.add(coords.get(0));
			down.add(coords.get(1)+1);
			if(Map.occupiedRooms.contains(down)==false) {
				if(Map.available.contains(down)==false) {
					Map.available.add(down);
				}
			}
		}
	}
	
	public static void addBorders() {
		for(int i = 0; i < Map.occupiedRooms.size(); i++) {
			ArrayList<Integer> currentRoom = Map.occupiedRooms.get(i);
			boolean[] borders = {false,false,false,false};
			ArrayList<Integer> left = new ArrayList<Integer>();
			left.add(currentRoom.get(0)-1);
			left.add(currentRoom.get(1));
			if(Map.occupiedRooms.contains(left)==false) {
				borders[0] = true;
			}
			ArrayList<Integer> right = new ArrayList<Integer>();
			right.add(currentRoom.get(0)+1);
			right.add(currentRoom.get(1));
			if(Map.occupiedRooms.contains(right)==false) {
				borders[1] = true;
			}
			ArrayList<Integer> up = new ArrayList<Integer>();
			up.add(currentRoom.get(0));
			up.add(currentRoom.get(1)-1);
			if(Map.occupiedRooms.contains(up)==false) {
				borders[2] = true;
			}
			ArrayList<Integer> down = new ArrayList<Integer>();
			down.add(currentRoom.get(0));
			down.add(currentRoom.get(1)+1);
			if(Map.occupiedRooms.contains(down)==false) {
				borders[3] = true;
			}
			Map.map[currentRoom.get(1)][currentRoom.get(0)].setBorders(borders);
		}
	}
	
	public static void tick() {
		Map.map[Game.player.getRoomY()][Game.player.getRoomX()].tick();
	}
	
	public static void render(Graphics g) {
		Map.map[Game.player.getRoomY()][Game.player.getRoomX()].render(g);
	}
	
}
	
