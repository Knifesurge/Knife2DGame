package com.knifesurge.knife2dgame.handlers;

import java.awt.Graphics;
import java.util.LinkedList;

import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.GameObject;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		try {
			for(GameObject o : this.object)
			{
				o.tick();
				containToMap(o);
			}
		} catch (Exception e) {}
	}
	
	public void render(Graphics g)
	{
		for (int i = 0; i < this.object.size(); i++)
		{
			GameObject temp = (GameObject)this.object.get(i);
			temp.render(g);
		}
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	public void containToMap(GameObject o)
	{
		o.x = o.clamp(o.x, Game.WIDTH - o.getWidth() / 2, 5 + o.getWidth() / 2);
		o.y = o.clamp(o.y, Game.HEIGHT - o.getHeight(), 5 + o.getWidth() / 2);
	}
	
	
}
