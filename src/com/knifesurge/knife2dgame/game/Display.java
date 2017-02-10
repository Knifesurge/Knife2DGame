package com.knifesurge.knife2dgame.game;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

/**
 * Display Handler for Knife2DGame
 * @author Knifesurge
 *
 */
public class Display {

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final Dimension GAMEDIM = new Dimension(WIDTH, HEIGHT);
	public static final String NAME = "Knife's 2D Game";
	
	public static ArrayList<JFrame> windows = new ArrayList<JFrame>();
	
	private static Game gamer;
	
	public static JFrame create(String name, int width, int height, boolean resizable, Component relTo, int closeOp, Game game)
	{
		JFrame tmp;
		tmp = new JFrame(name);
		tmp.setMinimumSize(new Dimension(width, height));
		tmp.setMaximumSize(new Dimension(width, height));
		tmp.setPreferredSize(new Dimension(width, height));
		tmp.setResizable(resizable);
		gamer = game;
		if(windows.isEmpty())
			tmp.add(game);
		tmp.setDefaultCloseOperation(closeOp);
		tmp.setLocationRelativeTo(null);
		tmp.setVisible(Boolean.valueOf(true));
		windows.add(tmp);
		return tmp;
	}
	
	public static JFrame create(String name, int width, int height, boolean resizable, Component relTo, int closeOp, Canvas ui)
	{
		JFrame tmp;
		tmp = new JFrame(name);
		tmp.setMinimumSize(new Dimension(width, height));
		tmp.setMaximumSize(new Dimension(width, height));
		tmp.setPreferredSize(new Dimension(width, height));
		tmp.setResizable(resizable);
		tmp.add(ui);
		tmp.setDefaultCloseOperation(closeOp);
		tmp.setLocationRelativeTo(null);
		tmp.setVisible(Boolean.valueOf(true));
		windows.add(tmp);
		return tmp;
	}
	
	public static void dispose(String name)
	{
		System.out.println(">>Dispose of JFrame "+name);
		for(int i=0;i<windows.size();i++)
		{
			if(windows.get(i).getTitle().equals(name))
			{
				windows.remove(windows.get(i));
			}
		}
	}
}
