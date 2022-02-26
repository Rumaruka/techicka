package com.rumaruka.techicka.common.modules.thermal.bloodmagic.inventory;

import cofh.core.inventory.container.TileContainer;
import cofh.lib.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.lib.tileentity.DynamoTileBase;
import com.rumaruka.techicka.init.TBloodMagic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BloodDynamoContainer extends TileContainer {
    public final DynamoTileBase tile;

    public BloodDynamoContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {
        super(TBloodMagic.BLOOD_DYNAMO_CONTAINER.get(), windowId, world, pos, inventory, player);
        this.tile = (DynamoTileBase) world.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());
        this.bindAugmentSlots(tileInv, 0, this.tile.augSize());
        this.bindPlayerInventory(inventory);
    }
}
