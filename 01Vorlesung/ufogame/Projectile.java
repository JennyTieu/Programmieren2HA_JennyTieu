package ufogame;

import view.IGameObject;

/**
 * Projectile is an object which moves from the start point to the top edge. 
 * The position is defined by the x and y coordinate. The size is set with width and height.
 * The projectile can by displayed with a sprite.
 * You have the possibility to mark the projectile as collided.
 * 
 * @author Stephi
 *
 */
public class Projectile implements IGameObject {

	private int x;
	private int y;
	private int width;
	private int height;
	private boolean isCollided;
	private int speed;
	private String sprite;
	
	/**
	 * Creates a projectile at the specific x / y position and the size (width x height). A projectile moves with the given speed step by step to the top edge.
	 * You can set an sprite as jpg or png.
	 * @param x	start coordinate 
	 * @param y start coordinate 
	 * @param width of the projectile
	 * @param height of the projectile
	 * @param speed defined how fast or slowly the projectile should move
	 * @param sprite image of the projectile
	 */
	public Projectile(int x, int y, int width, int height, int speed, String sprite) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.sprite = sprite;
	}

	public void move() {
		y = y - speed;
	}
	
	public boolean isCollided() {
		return isCollided;
	}

	public void setCollided(boolean isCollided) {
		this.isCollided = isCollided;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getImagePath() {
		return sprite;
	}
	
	
	
	
}
