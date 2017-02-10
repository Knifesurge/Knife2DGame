package com.knifesurge.knife2dgame.entities;

import java.awt.Graphics;

import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.GameObject;
import com.knifesurge.knife2dgame.game.ID;

public abstract class Entity extends GameObject{

	public boolean left = false;
	public boolean right = false;
	public boolean above = false;
	public boolean below = false;
	protected int dx;
	protected int dy;
	
	public Entity(int x, int y, ID id, Game g)
	{
		super(x, y, id, g);
		
		this.width = 16;
		this.height = 16;
		this.name = "ENT_";
	}
	
	public void tick()
	{
		entityTick();
	}
	
	public void render(Graphics g)
	{
		entityRender(g);
	}
	
	
	protected abstract void entityRender(Graphics g);
	protected abstract void entityTick();
	
}
