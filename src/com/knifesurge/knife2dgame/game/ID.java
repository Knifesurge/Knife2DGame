package com.knifesurge.knife2dgame.game;

import java.awt.Color;

public enum ID {

	Player {
		@Override
		public Color getColor() {
			return Color.blue;
		}
	}, Enemy {
		@Override
		public Color getColor() {
			return Color.red;
		}
	}, UI {
		@Override
		public Color getColor()
		{
			return null;
		}
	}, Structure {
		@Override
		public Color getColor()
		{
			return Color.yellow;
		}
	};
	
	private ID() {}
	
	public abstract Color getColor();
}
