package ufogame;

import view.IGameObject;

/**
 * Ufo is an object which moves from the upper left corner to the upper right corner. 
 * The position is defined by the x and y coordinate. The size is set with width and height.
 * The ufo can by displayed with a sprite.
 * You have the possibility to mark the ufo as collided.
 * 
 * @author Stephi
 *
 */
public class Ufo implements IGameObject {

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	private String sprite;
	private boolean isCollided;
	
	/**
	 * Creates an ufo at the specific x / y position and the size (width x height). An ufo moves with the given speed from the left edge to the right edge.
	 * You can set an sprite as jpg or png.
	 * @param x	start coordinate 
	 * @param y start coordinate 
	 * @param width of the ufo
	 * @param height of the ufo
	 * @param speed defined how fast or slowly the ufo should move
	 * @param sprite image of the ufo
	 */
	public Ufo(int x, int y, int width, int height, int speed, String sprite) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.sprite = sprite;
	}

	/**
	 * Moves the ufo. The x coordinate is increased by speed.
	 */
	public void move() {
		x = x + speed;
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

	public int getSpeed() {
		return speed;
	}

	public String getImagePath() {
		return sprite;
	}
	
	
}
