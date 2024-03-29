package com.rumaruka.techicka.utils;

import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyFE extends EnergyStorage {
    public CustomEnergyFE(int capacity) {
        super(capacity);
    }

    public CustomEnergyFE(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public CustomEnergyFE(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public CustomEnergyFE(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void consumePower(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
    public int extractEnergyInternal(int maxExtract, boolean simulate) {
        int before = this.maxExtract;
        this.maxExtract = Integer.MAX_VALUE;

        int toReturn = this.extractEnergy(maxExtract, simulate);

        this.maxExtract = before;
        return toReturn;
    }
    public void generatePower(int energy) {
        this.energy += energy;
        if (this.energy > capacity) {
            this.energy = capacity;
        }
    }

}
