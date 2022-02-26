package com.rumaruka.techicka.common.modules.thermal;

import com.hollingsworth.arsnouveau.api.mana.AbstractManaTile;
import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import com.rumaruka.techicka.init.TArsNouveau;
import com.rumaruka.techicka.utils.CustomEnergyFE;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaDynamoTile extends AbstractManaTile implements ITickableTileEntity, ICapabilityProvider {


    public CustomEnergyFE energy = new CustomEnergyFE(1000, 100);
    public boolean markedForUpdate = false;
    public int tickDelay = 10;
    public int maxMana = 1000;
    public ManaDynamoTile() {
        super(TArsNouveau.MANA_DYNAMO_TILE.get());

    }

    @Override
    public void tick() {
        if (!level.isClientSide) {

            if (markedForUpdate) {


                tickDelay--;
                if (tickDelay == 0) {
                    tickDelay = 10;
                    markedForUpdate = false;

                    level.blockUpdated(getBlockPos(), level.getBlockState(getBlockPos()).getBlock());
                }
            }

            boolean flag = level.hasNeighborSignal(getBlockPos()) || level.hasNeighborSignal(getBlockPos().above());
                if( ManaUtil.hasManaNearby(this.worldPosition, this.level, 2, 200) ){
                    ManaUtil.takeManaNearbyWithParticles(this.worldPosition, this.level, 2, 200);
                    energy.generatePower(10);
                    markedForUpdate = true;
                }



            }



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


    @Override
    public int getTransferRate() {
        return getMaxMana();
    }




    @Override
    public int getMaxMana() {
        return maxMana;
    }


}
