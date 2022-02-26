package com.rumaruka.techicka.common.modules.thermal.bloodmagic.tiles;

import com.rumaruka.techicka.init.TBloodMagic;
import com.rumaruka.techicka.utils.CustomEnergyFE;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BloodDynamoTile extends TileEntity implements ITickableTileEntity, ICapabilityProvider {

    public FluidTank bloodTank;
    public CustomEnergyFE energy = new CustomEnergyFE(1000, 100);
    public boolean markedForUpdate = false;
    public int tickDelay = 10;

    public BloodDynamoTile() {
        super(TBloodMagic.BLOOD_DYNAMO_TILE.get());
        bloodTank = new FluidTank(2000) {
            @Override
            protected void onContentsChanged() {
                if (!level.isClientSide) {
                    setChanged();
                    markedForUpdate = true;
                }
            }
        };
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
            int fluidAmount = bloodTank.getFluidAmount();
            boolean flag = level.hasNeighborSignal(getBlockPos()) || level.hasNeighborSignal(getBlockPos().above());


            if (bloodTank.getFluid().getFluid() == BloodMagicBlocks.LIFE_ESSENCE_FLUID.get() && fluidAmount > 9&&flag) {
                bloodTank.drain(100, IFluidHandler.FluidAction.EXECUTE);
                energy.generatePower(10);
                markedForUpdate = true;

            }


        }
    }




    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);
    private final LazyOptional<IFluidHandler> fluid = LazyOptional.of(() -> bloodTank);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return fluid.cast();
        }

        return super.getCapability(cap, side);
    }


}
