package com.knifesurge.knife2dgame.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.knifesurge.knife2dgame.handlers.FileHandler;
import com.knifesurge.knife2dgame.pathfinding.Pathfinder;

public abstract class GameObject {

	public int x;
	public int y;
	public int destX = this.x;
	public int destY = this.y;
	protected int velX;
	protected int velY;
	protected int width;
	protected int height;
	public int speed = 0;
	public ID id;
	public boolean isAlive = false;
	public boolean isPathing = false;
	public Pathfinder finder = null;
	public FileHandler icon = new FileHandler();
	public BufferedImage image = null;
	public String name;
	protected static String inventoryName;
	protected Game game;
	
	public javax.swing.JFrame inventory;
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public GameObject(int x, int y, ID id, Game g)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.game = g;
	}
	
	public int clamp(int value, int max, int min)
	{
		if(value > max) return value = max;
		if(value < min) return value = min;
		return value;
	}
	
	public BufferedImage createSprite()
	{
		return icon.readImage("/res/sprites/" + name);
	}
	
	public void drawSprite(Graphics g)
	{
		g.drawImage(createSprite(), this.x - this.width / 2, this.y - this.height / 2, null);
	}

	public void setPathing(Boolean b) { this.isPathing = b.booleanValue(); }
	  
	public void setDestinaion(int x, int y) {
		setPathing(Boolean.valueOf(true));
		if (this.finder != null)
			this.finder.setDestination(x, y);
     }
	
	public String toString()
	{
		return this.name + " at (" + this.x + ", " + this.y + ")";
	}
	
	public boolean inBounds(int mouseX, int mouseY)
	{
		return ((mouseX >= this.x) && (mouseY >= this.y) && (mouseX < this.x + this.getWidth()) && (mouseY < this.y + this.getHeight()));
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
