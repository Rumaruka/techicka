package com.rumaruka.techicka.init;

import cofh.core.util.ProxyUtils;
import cofh.lib.util.DeferredRegisterCoFH;
import com.rumaruka.techicka.ModSetup;
import com.rumaruka.techicka.common.modules.thermal.bloodmagic.blocks.BloodDynamoBlock;
import com.rumaruka.techicka.common.modules.thermal.bloodmagic.tiles.BloodDynamoTile;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.techicka.Techicka.MODID;


public class TBloodMagic {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);


    public static void setup() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    public static final RegistryObject<Block> BLOOD_DYNAMO = BLOCKS.register("blood_dynamo", BloodDynamoBlock::new);
    public static final RegistryObject<BlockItem> BLOOD_DYNAMO_ITEM = BLOCKITEMS.register("blood_dynamo", () -> new BlockItem(BLOOD_DYNAMO.get(), new Item.Properties().tab(ModSetup.TechickaGroup)));
    public static final RegistryObject<TileEntityType<BloodDynamoTile>> BLOOD_DYNAMO_TILE = TILES.register("blood_dynamo", () -> TileEntityType.Builder.of(BloodDynamoTile::new, BLOOD_DYNAMO.get()).build(null));



}
