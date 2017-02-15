package com.knifesurge.knife2dgame.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD extends GameObject{

	public HUD(int x, int y, ID id, Game g)
	{
		super(x, y, id, g);
		
		this.id = ID.UI;
		
		this.name = "HUD";
		this.width = Display.WIDTH;
		this.height = Display.HEIGHT;
	}

	public void tick() {}

	public void render(Graphics g) {
		try {
			g.setColor(this.id.getColor());
		} catch (NullPointerException e) {}
		finally {
			g.setColor(Color.blue);
		}
		//if(InputHandler.isMouseDown);
	}
	
	
}
