package ufogame;

import view.IBackground;

public class Background implements IBackground{

	private String sprite;
	
	public Background(String sprite) {
		super();
		this.sprite = sprite;
	}

	@Override
	public String getImagePath() {		
		return sprite;
	}

}
