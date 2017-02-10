package com.knifesurge.knife2dgame.handlers;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.knifesurge.knife2dgame.game.Display;
import com.knifesurge.knife2dgame.game.Game;
import com.knifesurge.knife2dgame.game.GameObject;
import com.knifesurge.knife2dgame.game.ID;
import com.knifesurge.knife2dgame.structures.Structure;

/**
 * Handler to all input taken in by the {@link Game Game}
 * @author Knifesurge
 *
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener{
	/* Mouse Buttons */
	/** Left Mouse Button **/ public static final int 	LMB = 0x1;
	/** Middle Mouse Button **/ public static final int MMB = 0x2;
	/** Right Mouse Button **/ public static final int 	RMB = 0x3;
	
	/* Number keys */
	/** Number Key 0 **/ public static final int 		KEY_0 = 0x30;
	/** Number Key 1 **/ public static final int 		KEY_1 = 0x31;
	/** Number Key 2 **/ public static final int 		KEY_2 = 0x32;
	/** Number Key 3 **/ public static final int 		KEY_3 = 0x33;
	/** Number Key 4 **/ public static final int 		KEY_4 = 0x34;
	/** Number Key 5 **/ public static final int 		KEY_5 = 0x35;
	/** Number Key 6 **/ public static final int 		KEY_6 = 0x36;
	/** Number Key 7 **/ public static final int 		KEY_7 = 0x37;
	/** Number Key 8 **/ public static final int 		KEY_8 = 0x38;
	/** Number Key 9 **/ public static final int 		KEY_9 = 0x39;
	
	/* Numpad Number Keys */
	/** Number Pad Key 0 **/ public static final int	NUM_0 = 0x60;
	/** Number Pad Key 1 **/ public static final int 	NUM_1 = 0x61;
	/** Number Pad Key 2 **/ public static final int 	NUM_2 = 0x62;
	/** Number Pad Key 3 **/ public static final int 	NUM_3 = 0x63;
	/** Number Pad Key 4 **/ public static final int 	NUM_4 = 0x64;
	/** Number Pad Key 5 **/ public static final int 	NUM_5 = 0x65;
	/** Number Pad Key 6 **/ public static final int 	NUM_6 = 0x66;
	/** Number Pad Key 7 **/ public static final int 	NUM_7 = 0x67;
	/** Number Pad Key 8 **/ public static final int 	NUM_8 = 0x68;
	/** Number Pad Key 9 **/ public static final int 	NUM_9 = 0x69;
	
	/*Standard Keyboard Keys */
	public static final int 							KEY_A = 0x41;
	public static final int 							KEY_B = 0x42;
	public static final int 							KEY_C = 0x43;
	public static final int 							KEY_D = 0x44;
	public static final int 							KEY_E = 0x45;
	public static final int 							KEY_F = 0x46;
	public static final int 							KEY_G = 0x47;
	public static final int 							KEY_H = 0x48;
	public static final int 							KEY_I = 0x49;
	public static final int 							KEY_J = 0x4A;
	public static final int 							KEY_K = 0x4B;
	public static final int 							KEY_L = 0x4C;
	public static final int 							KEY_M = 0x4D;
	public static final int 							KEY_N = 0x4E;
	public static final int 							KEY_O = 0x4F;
	public static final int 							KEY_P = 0x50;
	public static final int 							KEY_Q = 0x51;
	public static final int 							KEY_R = 0x52;
	public static final int 							KEY_S = 0x53;
	public static final int 							KEY_T = 0x54;
	public static final int 							KEY_U = 0x55;
	public static final int 							KEY_V = 0x56;
	public static final int 							KEY_W = 0x57;
	public static final int 							KEY_X = 0x58;
	public static final int 							KEY_Y = 0x59;
	public static final int 							KEY_Z = 0x5A;
	/* Function Keys */
	/** Function Key 1 **/  public static final int 	KEY_F1 = 0x70;
	/** Function Key 2 **/  public static final int 	KEY_F2 = 0x71;
	/** Function Key 3 **/  public static final int 	KEY_F3 = 0x72;
	/** Function Key 4 **/  public static final int 	KEY_F4 = 0x73;
	/** Function Key 5 **/  public static final int 	KEY_F5 = 0x74;
	/** Function Key 6 **/  public static final int 	KEY_F6 = 0x75;
	/** Function Key 7 **/  public static final int 	KEY_F7 = 0x76;
	/** Function Key 8 **/  public static final int 	KEY_F8 = 0x77;
	/** Function Key 9 **/  public static final int 	KEY_F9 = 0x78;
	/** Function Key 10 **/ public static final int 	KEY_F10= 0x79;
	/** Function Key 11 **/ public static final int 	KEY_F11= 0x7A;
	/** Function Key 12 **/ public static final int 	KEY_F12 = 0x7B;
	/** Function Key 13 **/ public static final int 	KEY_F13 = 0x7C;
	/** Function Key 14 **/ public static final int 	KEY_F14 = 0x7D;
	/** Function Key 15 **/ public static final int 	KEY_F15 = 0x7E;
	/** Function Key 16 **/ public static final int 	KEY_F16 = 0x7F;
	/** Function Key 17 **/ public static final int 	KEY_F17 = 0x80;
	/** Function Key 18 **/ public static final int 	KEY_F18 = 0x81;
	/** Function Key 19 **/ public static final int 	KEY_F19 = 0x82;
	/** Function Key 20 **/ public static final int 	KEY_F20 = 0x83;
	/** Function Key 21 **/ public static final int 	KEY_F21 = 0x84;
	/** Function Key 22 **/ public static final int 	KEY_F22 = 0x85;
	/** Function Key 23 **/ public static final int 	KEY_F23 = 0x86;
	/** Function Key 24 **/ public static final int 	KEY_F24 = 0x87;
	
	/* Other Useful Keys */
	/** Escape Key **/ public static final int 			KEY_ESC		= 0x1B;
	/** Enter Key **/ public static final int 			KEY_ENTER 	= 0x0D;
	/** Spacebar **/ public static final int 			KEY_SPACE 	= 0x20;
	/** Unknown Key **/ public static final int 		KEY_NONE 	= 0xFF;
	/** Caps Lock **/ public static final int 			KEY_CAPS 	= 0x14;
	/** Delete Key **/ public static final int 			KEY_DELETE	= 0x2E;
	/** Left Control Key **/ public static final int 	KEY_LCTRL 	= 0xA2;
	/** Left Alt Key**/ public static final int 		KEY_LALT 	= 0xA4;
	/** Left Shift Key **/ public static final int 		KEY_LSHIFT 	= 0xA0;
	/** Left Windows Key **/ public static final int 	KEY_LWIN 	= 0x5B;
	/** Plus / Equals Key **/ public static final int	KEY_OEM_PLUS= 0xBB;
	/** Tab Key **/ public static final int				KEY_TAB 	= 0x09;
	
	/* Arrow Keys */
	/** Left Arrow Key **/ public static final int 		KEY_LEFT = 0x25;
	/** Up Arrow Key **/ public static final int 		KEY_UP 	 = 0x26;
	/** Right Arrow Key **/ public static final int 	KEY_RIGHT= 0x27;
	/** Down Arrow Key **/ public static final int 		KEY_DOWN = 0x28;
	
	/* Other variables */
	public static int mouseLocationX;
	public static int mouseLocationY;
	public static boolean isMouseDown = false;
	
	private Game game;
	
	public InputHandler(Game game)
	{
		this.game = game;
		this.game.addKeyListener(this);
		this.game.addMouseListener(this);
		this.game.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int button = e.getButton();
		if(button == RMB)
		{
			System.out.println("Right Clicked at " + e.getPoint().x + ", " + e.getPoint().y);
			for(GameObject go : Game.handler.object)
			{
				Point point = e.getPoint();
				if(go.id != ID.UI)	//Filter out the User Interface as we only want entities
					if(go.inBounds(point.x, point.y))	//Clicked inside a GameObject
					{
						System.out.println(go.name.toUpperCase() + " was right-clicked");
						if(go.id == ID.Structure)	//If what we clicked is a structure
						{
							for(int i=0;i<Game.handler.object.size();i++)	//Loop through all of the Game Objects
							{
								Structure tmp;
								if(Game.handler.object.get(i).id == ID.Structure)	//If it is a Structure
									tmp = (Structure) Game.handler.object.get(i);
								else	//If it is anything else
									continue;
								if(tmp.isActive)
								{
									tmp.inventory.requestFocus();
									tmp.inventory.toFront();
									tmp.inventory.repaint();
								}
								else if(!tmp.isActive)
								{
									tmp.setActive(Boolean.valueOf(true));
									tmp.openInventory();
								}
							}
						}
					}
			}
		}
		else if(button == LMB)
		{
			System.out.println("Left Clicked at " + e.getPoint().x + ", " + e.getPoint().y);
			for(GameObject go : Game.handler.object)
			{
				Point point = e.getPoint();
				if(go.id != ID.UI)	//Filter out the User Interface as we only want entities
					if(go.inBounds(point.x, point.y))	//Clicked inside a GameObject
					{
						System.out.println(go.name.toUpperCase() + " was left-clicked");
					}
			}
		}
		else if(button == MMB)
		{
			System.out.println("Middle Clicked at " + e.getPoint().x + ", " + e.getPoint().y);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KEY_W)
		{
			game.player.above = true;
		}
		if(keyCode == KEY_A)
		{
			game.player.left = true;
		}
		if(keyCode == KEY_S)
		{
			game.player.below = true;
		}
		if(keyCode == KEY_D)
		{
			game.player.right = true;
		}
		if(keyCode == KEY_E)
		{
			game.player.openInventory();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KEY_W)
		{
			game.player.above = false;
		}
		if(keyCode == KEY_A)
		{
			game.player.left = false;
		}
		if(keyCode == KEY_S)
		{
			game.player.below = false;
		}
		if(keyCode == KEY_D)
		{
			game.player.right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
