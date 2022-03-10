package com.rumaruka.techicka.event;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber
public class TDataGen {


    @SubscribeEvent
    public static void onData(GatherDataEvent event){
        DataGenerator data = event.getGenerator();

    }
}
