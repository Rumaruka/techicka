package com.rumaruka.techicka.common.modules.thermal.bloodmagic.blocks;

import com.rumaruka.techicka.common.modules.thermal.bloodmagic.tiles.BloodDynamoTile;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import javax.annotation.Nullable;

public class BloodDynamoBlock extends ContainerBlock {


    public BloodDynamoBlock() {
        super(Properties.of(Material.METAL).noCollission().noDrops());

    }

    @Override
    public ActionResultType use(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (!level.isClientSide) {
            BloodDynamoTile tile = (BloodDynamoTile) level.getBlockEntity(pos);
            ItemStack heldItem = player.getItemInHand(hand);

            if (!player.isCrouching()) {
                if (!heldItem.isEmpty()) {


                    if (heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null).isPresent()) {
                        FluidUtil.interactWithFluidHandler(player, hand, tile.bloodTank);
                        return ActionResultType.SUCCESS;
                    }
                }
            }

        }
        return ActionResultType.SUCCESS;
    }


    @Override
    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new BloodDynamoTile();
    }
}
