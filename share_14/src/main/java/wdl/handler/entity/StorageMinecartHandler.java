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
package wdl.handler.entity;

import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import wdl.handler.HandlerException;

public class StorageMinecartHandler extends EntityHandler<ChestMinecartEntity, ChestContainer> {

	public StorageMinecartHandler() {
		super(ChestMinecartEntity.class, ChestContainer.class);
	}

	@Override
	public ITextComponent copyData(ChestContainer container, ChestMinecartEntity minecart, boolean riding) throws HandlerException {
		for (int i = 0; i < minecart.getSizeInventory(); i++) {
			Slot slot = container.getSlot(i);
			if (slot.getHasStack()) {
				minecart.setInventorySlotContents(i, slot.getStack());
			}
		}

		return new TranslationTextComponent("wdl.messages.onGuiClosedInfo.savedEntity.storageMinecart");
	}

}
