package ufogame;

import view.IGameObject;

/**
 * Ship is an object which is centered at a specific coordinate. 
 * The position is defined by the x and y coordinate. The size is set with width and height.
 * The ship can by displayed with a sprite.
 * 
 * @author Stephi
 *
 */
public class Ship implements IGameObject {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private String sprite;
	

	/**
	 * Creates an ship at the specific x / y position and the size (width x height). 
	 * You can set an sprite as jpg or png.
	 * @param x	start coordinate 
	 * @param y start coordinate 
	 * @param width of the ship
	 * @param height of the ship
	 * @param sprite image of the ship
	 */
	public Ship(int x, int y, int width, int height, String sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public String getImagePath() {
		return sprite;
	}
	
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	
}
