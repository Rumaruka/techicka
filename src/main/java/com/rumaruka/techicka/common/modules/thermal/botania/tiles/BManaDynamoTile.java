package com.rumaruka.techicka.common.modules.thermal.botania.tiles;

import com.google.common.base.Predicates;
import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.rumaruka.techicka.init.TArsNouveau;
import com.rumaruka.techicka.init.TBotania;
import com.rumaruka.techicka.utils.CustomEnergyFE;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import vazkii.botania.api.BotaniaAPIClient;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.IManaBlock;
import vazkii.botania.api.mana.IManaPool;
import vazkii.botania.api.mana.IManaReceiver;
import vazkii.botania.api.subtile.TileEntityFunctionalFlower;
import vazkii.botania.common.block.tile.TileMod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BManaDynamoTile extends TileEntityFunctionalFlower implements ITickableTileEntity, ICapabilityProvider {

    public CustomEnergyFE energy = new CustomEnergyFE(1000, 10);
    public boolean markedForUpdate = false;
    public int tickDelay = 10;
    public int maxMana = 1000;
    TileEntity linkedPool = null;

    public BManaDynamoTile() {
        super(TBotania.BOTANIA_DYNAMO_MANA_TILE.get());

    }

    @Override
    public void tickFlower() {
        super.tickFlower();

    }

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }


        return super.getCapability(cap, side);
    }


}
