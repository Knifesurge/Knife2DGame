package com.knifesurge.knife2dgame.structures;

import java.awt.Graphics;

import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.ID;

public class BasicFactory extends Structure{

	
	
	public BasicFactory(int x, int y, ID id, Game g) {
		super(x, y, id, g);
		
		this.width = 32;
		this.height = 32;
		this.name += "BasicFactory";
		this.inventoryName = this.name+" Inventory";
	}

	protected void structureTick()
	{
		
	}

	protected void structureRender(Graphics g)
	{
		g.setColor(this.id.getColor());
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
