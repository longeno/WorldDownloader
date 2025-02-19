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
package wdl.handler.block;

import net.minecraft.tileentity.TrappedChestTileEntity;

/**
 * Handles trapped chests, in versions where they are separate from regular
 * chests (1.13+).
 */
public class TrappedChestHandler extends BaseChestHandler<TrappedChestTileEntity> {
	public TrappedChestHandler() {
		super(TrappedChestTileEntity.class, "container.chest", "container.chestDouble");
	}
}
