/*
 * This file is part of World Downloader: A mod to make backups of your
 * multiplayer worlds.
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2520465
 *
 * Copyright (c) 2014 nairol, cubic72
 * Copyright (c) 2017-2018 Pokechu22, julialy
 *
 * This project is licensed under the MMPLv2.  The full text of the MMPL can be
 * found in LICENSE.md, or online at https://github.com/iopleke/MMPLv2/blob/master/LICENSE.md
 * For information about this the MMPLv2, see http://stopmodreposts.org/
 *
 * Do not redistribute (in modified or unmodified form) without prior permission.
 */
package wdl.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

/**
 * Extendible button, to deal with changing method signatures between versions.
 * The actual implementation is {@link WDLButton}, and methods are declared in {@link IExtButton}.
 */
abstract class ExtButton extends GuiButton implements IExtButton {
	/**
	 * @deprecated Do not use; use {@link #setMessage} instead.
	 */
	@Deprecated
	protected static final Void message = null;
	/**
	 * @deprecated Do not use; use {@link #setEnabled} instead.
	 */
	@Deprecated
	protected static final Void active = null;

	public ExtButton(int x, int y, int widthIn, int heightIn, String buttonText) {
		super(-1, x, y, widthIn, heightIn, buttonText);
	}

	private boolean dragging;

	@Override
	public final boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		boolean result = super.mousePressed(mc, mouseX, mouseY);
		if (result) {
			dragging = true;
			this.mouseDown(mouseX, mouseY);
		}
		return result;
	}

	@Override
	public final void mouseReleased(int mouseX, int mouseY) {
		super.mouseReleased(mouseX, mouseY);
		dragging = false;
		this.mouseUp(mouseX, mouseY);
	}

	@Override
	public final void render(Minecraft mc, int mouseX, int mouseY,
			float partialTicks) {
		if (this.dragging) {
			this.mouseDragged(mouseX, mouseY);
		}
		this.beforeDraw();
		super.render(mc, mouseX, mouseY, partialTicks);
		this.afterDraw();
	}

	@Override
	protected final void renderBg(Minecraft mc, int mouseX, int mouseY) {
		super.renderBg(mc, mouseX, mouseY);
		this.midDraw();
	}

	@Override
	public void setMessage(String message) {
		super.message = message;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.active = enabled;
	}

	@Override
	public boolean isEnabled() {
		return super.active;
	}
}
