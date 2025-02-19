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
package wdl.handler.block;

import static wdl.versioned.VersionedFunctions.customName;

import org.junit.Test;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.DispenserContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.util.math.BlockPos;
import wdl.handler.HandlerException;

public class DispenserTest extends AbstractBlockHandlerTest<DispenserTileEntity, DispenserContainer, DispenserHandler> {

	public DispenserTest() {
		super(DispenserTileEntity.class, DispenserContainer.class, DispenserHandler.class);
	}

	@Test
	public void testDispenser() throws HandlerException {
		BlockPos pos = new BlockPos(0, 0, 0);
		makeMockWorld();
		placeBlockAt(pos, Blocks.DISPENSER);
		DispenserTileEntity te = makeBlockEntity(pos);
		te.setInventorySlotContents(0, new ItemStack(Blocks.TNT));
		te.setInventorySlotContents(8, new ItemStack(Blocks.TNT));

		runHandler(pos, makeClientContainer(pos));
		checkAllTEs();
	}

	@Test
	public void testCustomName() throws HandlerException {
		assumeCustomNamesNotBroken();
		BlockPos pos = new BlockPos(0, 0, 0);
		makeMockWorld();
		placeBlockAt(pos, Blocks.DISPENSER);
		DispenserTileEntity te = makeBlockEntity(pos);
		te.setCustomName(customName("Something"));

		runHandler(pos, makeClientContainer(pos));
		checkAllTEs();
	}

	@Test
	public void testCustomNameVanilla() throws HandlerException {
		assumeCustomNamesNotBroken();
		assumeMixinsApplied();

		BlockPos pos = new BlockPos(0, 0, 0);
		makeMockWorld();
		placeBlockAt(pos, Blocks.DISPENSER);
		DispenserTileEntity te = makeBlockEntity(pos);
		te.setCustomName(customName("Dispenser"));

		runHandler(pos, makeClientContainer(pos));
		checkAllTEs();
	}
}
