/*
 * This file is part of World Downloader: A mod to make backups of your
 * multiplayer worlds.
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2520465
 *
 * Copyright (c) 2014 nairol, cubic72
 * Copyright (c) 2018 Pokechu22, julialy
 *
 * This project is licensed under the MMPLv2.  The full text of the MMPL can be
 * found in LICENSE.md, or online at https://github.com/iopleke/MMPLv2/blob/master/LICENSE.md
 * For information about this the MMPLv2, see http://stopmodreposts.org/
 *
 * Do not redistribute (in modified or unmodified form) without prior permission.
 */
package wdl.gui.widget;

/**
 * A Button class that works across versions.
 */
public abstract class WDLButton extends ExtButton {
	public WDLButton(int x, int y, int widthIn, int heightIn, String buttonText) {
		super(x, y, widthIn, heightIn, buttonText);
	}

	/**
	 * Performs the action of this button when it has been clicked.
	 */
	public abstract void performAction();

	@Override
	public void beforeDraw() { }

	@Override
	public void midDraw() { }

	@Override
	public void afterDraw() { }

	@Override
	public void mouseDown(int mouseX, int mouseY) {
		this.performAction();
	}

	@Override
	public void mouseDragged(int mouseX, int mouseY) { }

	@Override
	public void mouseUp(int mouseX, int mouseY) { }
}
