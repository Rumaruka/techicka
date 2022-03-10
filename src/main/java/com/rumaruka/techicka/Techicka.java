package com.rumaruka.techicka;

import com.rumaruka.techicka.init.TArsNouveau;
import com.rumaruka.techicka.init.TBloodMagic;
import com.rumaruka.techicka.init.TBotania;
import com.rumaruka.techicka.init.TMekanism;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.rumaruka.techicka.Techicka.MODID;


@Mod(MODID)
public class Techicka {

    public static final String MODID = "techicka";

    public Techicka() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::clientSetup);
        if (ModList.get().isLoaded("botania")) {
            TBotania.setup();
        }
        if (ModList.get().isLoaded("ars_nouveau")) {
            TArsNouveau.setup();
        }
        if (ModList.get().isLoaded("bloodmagic")) {
            TBloodMagic.setup();
        }
        if (ModList.get().isLoaded("mekanism")) {
            TMekanism.setup();
        }




    }


    private void clientSetup(FMLClientSetupEvent event) {


        registerGuiFactories();
    }

    private void registerGuiFactories() {
        //ScreenManager.register(TBloodMagic.BLOOD_DYNAMO_CONTAINER.get(), DynamoBloodScreen::new);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }


}
