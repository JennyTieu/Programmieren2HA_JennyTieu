package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener {

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private int points=0;
	private int shootCount=10;
	private GameFrameWork frameWork = new GameFrameWork();

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("01Vorlesung\\assets\\space14.jpg"));
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);
		frameWork.addMessage(new Message("Score: "+points+" /5",8*screenWidth/10,screenHeight/10,20,Color.white));
		frameWork.addMessage(new Message("Shots left: "+shootCount,8*screenWidth/10,2*screenHeight/10,20,Color.pink));
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
	
		// create a projectile
		if(shootCount>0) {
			shootCount-=1;
			Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
					ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
					"01Vorlesung\\assets\\projectile06.png");
			projectiles.add(projectile);
	
			frameWork.addGameObject(projectile);
			frameWork.removeMessage();
			frameWork.addMessage(new Message("Score: "+points+" /5",8*screenWidth/10,screenHeight/10,20,Color.white));
			frameWork.addMessage(new Message("Shots left: "+shootCount,8*screenWidth/10,2*screenHeight/10,20,Color.pink));
		}

		//System.out.println(projectiles.size());

//		for(int i = 0; i < 1000; i++) {
//			projectiles.add(projectile);
//		}
//		
//		for(Projectile p : projectiles) {
//			System.out.println(p.getImagePath());
//		}
		// Variante Array
		// projectiles[0] = projectile;

		// projectiles.get(0).getWidth();
		// Variante Array
		// projectiles[0].getWidth();

		// projectiles.size();
		// Variante Array
		// projectiles.lenght
	}

	@Override
	public void tick(long elapsedTime) {

		for (Ufo ufo : ufos) {
			if(ufo.isCollided()==true) {
				frameWork.removeGameObject(ufo);
				ufo.move();
				
			}
			
			else {
				ufo.move();
			}
			
		}
		
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
			if(p.isCollided()) {
				frameWork.removeGameObject(p);
				projectiles.remove(p);
				break;
	
			}
			else {
				p.move();
			}
        }
		//Aufgabe1: Entfernt die Projektile aus Liste, wenn wenn Projektil aus Bildschirm fliegt
		if(projectiles.size()>=1) {
			if (projectiles.get(0).getY() <0) {
				frameWork.removeGameObject(projectiles.get(0));
				projectiles.remove(0);
			}		
		}

		
		for (Ufo ufo : ufos) {
			for (Projectile p: projectiles) {
				if(checkCollision(ufo, p)==true) {
					ufo.setCollided(true);
					p.setCollided(true);
					//Aufgabe 3: Punktestand
					points++;
					frameWork.removeMessage();
					frameWork.addMessage(new Message("Score: "+points+" /5",8*screenWidth/10,screenHeight/10,20,Color.white));
					frameWork.addMessage(new Message("Shots left: "+shootCount,8*screenWidth/10,2*screenHeight/10,20,Color.pink));
				}
			}
		}
		checkGame();
	}
	
	public void checkGame() {
		if((shootCount==0&&projectiles.size()==0&&points<5)) {
			frameWork.removeTick(this);
			frameWork.addMessage(new Message("GAME OVER",screenWidth/6,screenHeight/3,100,Color.red));
		}
		else if(points==5) {
			frameWork.removeTick(this);
			frameWork.addMessage(new Message("YOU WIN!",2*screenWidth/8,screenHeight/3,100,Color.green));

		}

	}
	
	

	//Aufgabe 2:
	public boolean checkCollision(Ufo ufo, Projectile p) {
		if(p.getX()<ufo.getX()+ufo.getWidth() && p.getY()<ufo.getY()+ufo.getHeight() && p.getX()+ufo.getWidth()>ufo.getX() && p.getY()+ufo.getHeight()>ufo.getY()&&!p.isCollided()&&!ufo.isCollided()) {
			return true;
		}
		else {
			return false;
		}
	}



	
	


	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
