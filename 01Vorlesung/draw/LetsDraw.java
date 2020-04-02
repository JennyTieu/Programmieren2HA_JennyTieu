package draw;

import java.awt.Color;

import ufogame.Ship;
import view.GameFrameWork;
import view.Oval;
import view.Rectangle;

public class LetsDraw {

	public static void main(String[] args) {
		GameFrameWork frameWork = new GameFrameWork();
		frameWork.setSize(1000, 800);
		frameWork.setBackgroundColor(new Color(0, 180, 200));
		frameWork.addRectangle(new Rectangle(100, 100, 400, 200, new Color(255, 255, 255)));
		frameWork.addOval(new Oval(200, 200, 30, 50, new Color(0, 255, 0)));
		Ship ship = new Ship(600, 600, 200, 200, "01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);
	}
	
	
	
}
