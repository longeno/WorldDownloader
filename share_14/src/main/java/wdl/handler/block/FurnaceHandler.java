/*
 * This file is part of World Downloader: A mod to make backups of your
 * multiplayer worlds.
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2520465
 *
 * Copyright (c) 2014 nairol, cubic72
 * Copyright (c) 2017-2019 Pokechu22, julialy
 *
 * This project is licensed under the MMPLv2.  The full text of the MMPL can be
 * found in LICENSE.md, or online at https://github.com/iopleke/MMPLv2/blob/master/LICENSE.md
 * For information about this the MMPLv2, see http://stopmodreposts.org/
 *
 * Do not redistribute (in modified or unmodified form) without prior permission.
 */
package wdl.handler.block;

import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class FurnaceHandler extends BaseFurnaceHandler<FurnaceTileEntity, FurnaceContainer> {
	public FurnaceHandler() {
		super(FurnaceTileEntity.class, FurnaceContainer.class, "container.furnace");
	}

	@Override
	protected TranslationTextComponent getMessage() {
		return new TranslationTextComponent("wdl.messages.onGuiClosedInfo.savedTileEntity.furnace");
	}
}
