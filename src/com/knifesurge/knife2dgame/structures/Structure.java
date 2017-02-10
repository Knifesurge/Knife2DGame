package com.knifesurge.knife2dgame.structures;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.knifesurge.knife2dgame.game.Display;
import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.GameObject;
import com.knifesurge.knife2dgame.game.ID;
import com.knifesurge.knife2dgame.ui.StructureUI;

public abstract class Structure extends GameObject{

	public int health;
	public int maxHealth = health;
	public boolean isActive = false;
	public boolean isCrafter = false;
	
	public javax.swing.JFrame inventory;
	public StructureUI ui = new StructureUI(400, 400/16*9);
	
	public Structure(int x, int y, ID id, Game g) {
		super(x, y, id, g);
		this.width = 32;
		this.height = 32;
		this.name = "STRUCT_";
	}

	public void openInventory()
	{
		this.inventory = Display.create(this.inventoryName, 400, 400/16*9, false, null, javax.swing.JFrame.DISPOSE_ON_CLOSE, (java.awt.Canvas)ui);
		this.inventory.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.out.println(">>sWindow closing!");
				isActive = false;
				Display.dispose(Structure.inventoryName);
			}
		});
	}
	
	public void closeInventory()
	{
		
	}
	
	public void setActive(boolean b)
	{
		this.isActive = Boolean.valueOf(b);
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public void tick()
	{
		structureTick();
	}

	public void render(Graphics g)
	{
		structureRender(g);
	}

	protected abstract void structureTick();
	protected abstract void structureRender(Graphics g);
	
}
