package com.knifesurge.knife2dgame.entities;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.knifesurge.knife2dgame.game.Display;
import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.ID;
import com.knifesurge.knife2dgame.pathfinding.Pathfinder;
import com.knifesurge.knife2dgame.ui.PlayerUI;

/**
 * Class that represents the player that the user will be using in game. <br>
 * Extends {@link Entity Entity}.
 * @author Knifesurge
 */
public class Player extends Entity{

	public boolean invenOpen = false;
	
	public PlayerUI ui = new PlayerUI(400, 400*16/9);
	
	public Player(int x, int y, ID id, Game g) {
		super(x, y, id, g);
		this.width = 16;
		this.height = 16;
		
		this.velX = 2;
		this.velY = 2;
		
		this.name += "Player";
		this.inventoryName = this.name+" Inventory";
		this.speed = 2;
		this.id = ID.Player;
		setPathing(Boolean.valueOf(false));
		this.finder = new Pathfinder(this);
	}

	public void openInventory()
	{
		this.inventory = Display.create(this.inventoryName, 400, 400/16*9, false, null, javax.swing.JFrame.DISPOSE_ON_CLOSE, (java.awt.Canvas)ui);
		System.out.println(this.inventoryName);
		System.out.println(name);
		this.inventory.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.out.println("Window closing!");
				invenOpen = false;
				Display.dispose(Player.inventoryName);
			}
		});
	}
	
	protected void entityTick()
	{
		if(this.above) this.dy = -this.speed;
		if(this.below) this.dy = this.speed;
		if(this.left) this.dx = -this.speed;
		if(this.right) this.dx = this.speed;
		
		x += dx;
		y += dy;
		
		dx = 0;
		dy = 0;
	}

	protected void entityRender(Graphics g)
	{
		g.setColor(this.id.getColor());
		g.fillOval(this.x - this.width / 2, this.y - this.height / 2, this.width, this.height);
	}
	
}
