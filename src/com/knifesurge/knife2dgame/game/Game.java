package com.knifesurge.knife2dgame.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.knifesurge.knife2dgame.entities.Player;
import com.knifesurge.knife2dgame.handlers.Handler;
import com.knifesurge.knife2dgame.handlers.InputHandler;
import com.knifesurge.knife2dgame.pathfinding.Grid;
import com.knifesurge.knife2dgame.structures.BasicFactory;

/**
 * Main Class for Knife2DGame
 * @author Knifesurge
 *
 */
public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 94563L;
	private boolean running = false;
	public int tickCount = 0;
	
	public static final int WIDTH = Display.WIDTH;
	public static final int HEIGHT = Display.HEIGHT;
	
	public static InputHandler IH;
	public static Handler handler;
	private HUD hud;
	public Player player;
	public BasicFactory basicFactory;
	private static Thread thread = null;

	public javax.swing.JFrame display;
	
	public static int mLocX;
	public static int mLocY;
	
	public static Grid mainGrid = new Grid(WIDTH, HEIGHT);
	
	public static BufferedImage image = new BufferedImage(Display.WIDTH, Display.HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public synchronized void start()
	{
		if(running) return;
		running = true;
		thread = new Thread(this, "MAIN_GAME_THREAD");
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running) return;
		try{
			running = false;
			thread.join();
		} catch (Exception e){e.printStackTrace();}
		
	}
	
	private void init()
	{
		System.out.println("Init Start");
		
		display = Display.create(Display.NAME, WIDTH, HEIGHT, false, null, javax.swing.JFrame.EXIT_ON_CLOSE, this);
		IH = new InputHandler(this);
		handler = new Handler();
		hud = new HUD(0, 0, ID.UI, this);
		player = new Player(WIDTH/2, HEIGHT/2, ID.Player, this);
		basicFactory = new BasicFactory(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Structure, this);
		
		handler.addObject(basicFactory);
		handler.addObject(player);
		handler.addObject(hud);
		
		System.out.println("Init Stop");
	}
	
	public void run()
	{
		System.out.println("Start run");
		long lastTime = System.nanoTime();
		double nsPerTick = 1.0E9D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		init();

		this.requestFocus();

		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while(delta >= 1)
			{
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			
			try { 
				Thread.sleep(2);
			} catch (Exception e) {e.printStackTrace();}
			
			if(shouldRender)
			{
				frames++;
				render();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000)
			{
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				//System.out.println(player.toString());
				//System.out.println(basicFactory.toString());
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void tick()
	{
		tickCount++;
		handler.tick();
		hud.tick();
		player.tick();
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g.setColor(new Color(0, 123, 12));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//renderBackground(g);
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	/*
	public void renderBackground(Graphics g) {
	     ImageIcon backgroundIcon = new ImageIcon(getClass().getClassLoader().getResource("res/Background.png"));
	     g.drawImage(createSprite(backgroundIcon), 0, 0, null);
   }
	  
   public BufferedImage createSprite(ImageIcon i)
   {
     Icon icon = i;
     BufferedImage bi = new BufferedImage(clamp(icon.getIconWidth(), WIDTH, WIDTH), clamp(icon.getIconHeight(), HEIGHT, HEIGHT), BufferedImage.TYPE_INT_RGB);
     
     Graphics g = bi.createGraphics();
     
     icon.paintIcon(null, g, 0, 0);
     g.dispose();
     return bi;
   }
	
		
	 public int clamp(int value, int max, int min)
	 {
	      if (value > max) {
	        return value = max;
	      }
	      if (value < min) {
	        return value = min;
	      }
	      return value;
	    }
	 */
	public static void main(String[] args)
	{
		new Game().start();
	}
	
}
