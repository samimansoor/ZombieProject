package zombies.city;

import java.awt.Color;
import java.util.Random;

public abstract class Actor {

	protected Random rand;
	protected Color col;
	protected int x;
	protected int y;
	protected Direction dir;
	protected boolean z = false;
	protected boolean h = false;
	


	public Actor() {
		this.rand = new Random();
		this.x = 0;
		this.y = 0;
		this.dir = Direction.NORTH;
		this.col = Color.WHITE;
	}
	
	public Actor(int x, int y, Direction d, Color c) {
		this.rand = new Random();
		this.x = x;
		this.y = y;
		this.dir = d;
		this.col = c;
	}
	


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDir() {
		return dir;
	}

	public Color getColor() {
		return col;
	}
	
	
	public void initialize(City city) {
		// TODO Implement this method
		if (this.x < 0 || this.x > city.getWidth() || this.y < 0 || this.y > city.getHeight() || 
				city.getColor(x, y) != City.CITY_COLOR) {
			System.err.println("Invalid actor position: (x,y) = (" + x + "," + y + ")");
			return;
		}
		
		city.setColor(x, y, col);
	}
	

	public void update(City city) {}
	
	public void toZombie(City city) {
		z = true;
	}
	
	public void toHuman(City city) {
		h = true;
	}
	
	public boolean isZombie() {	
		return z;
	}
	
	public boolean isHuman() {
		return h;
	}
	
}