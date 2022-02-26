package com.rumaruka.techicka;

import com.rumaruka.techicka.init.TBloodMagic;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public static ItemGroup TechickaGroup = new ItemGroup(Techicka.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TBloodMagic.BLOOD_DYNAMO.get());
        }
    };
}
