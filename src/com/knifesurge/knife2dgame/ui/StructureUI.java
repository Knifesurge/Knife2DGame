package com.knifesurge.knife2dgame.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import com.knifesurge.knife2dgame.structures.Structure;

public class StructureUI extends Canvas{
	private static final long serialVersionUID = -4812254327728904843L;
	
	public int width, height;
	
	public StructureUI(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(100, 0, 10, Structure.inventory.getHeight());
	}
	
}
