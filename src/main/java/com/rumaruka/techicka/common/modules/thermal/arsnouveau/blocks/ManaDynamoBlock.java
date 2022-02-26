package com.rumaruka.techicka.common.modules.thermal.arsnouveau.blocks;

import com.rumaruka.techicka.common.modules.thermal.arsnouveau.tiles.ManaDynamoTile;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ManaDynamoBlock extends ContainerBlock {


    public ManaDynamoBlock() {
        super(Properties.of(Material.METAL).noCollission().noDrops());

    }





    @Override
    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new ManaDynamoTile();
    }
}
