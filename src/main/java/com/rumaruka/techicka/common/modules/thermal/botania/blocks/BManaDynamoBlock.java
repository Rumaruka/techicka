package com.rumaruka.techicka.common.modules.thermal.botania.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.rumaruka.techicka.common.modules.thermal.botania.tiles.BManaDynamoTile;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import vazkii.botania.api.wand.IWandHUD;

import javax.annotation.Nullable;

public class BManaDynamoBlock extends ContainerBlock   {
    public BManaDynamoBlock() {
        super(Properties.of(Material.METAL).noCollission().noDrops());

    }


    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new BManaDynamoTile();
    }


}
