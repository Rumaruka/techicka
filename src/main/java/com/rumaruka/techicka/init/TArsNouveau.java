package com.rumaruka.techicka.init;

import com.rumaruka.techicka.ModSetup;
import com.rumaruka.techicka.common.modules.thermal.arsnouveau.blocks.ManaDynamoBlock;
import com.rumaruka.techicka.common.modules.thermal.arsnouveau.tiles.ManaDynamoTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.techicka.Techicka.MODID;

public class TArsNouveau {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);


    public static void setup(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
    public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TechickaGroup)));
    public static final RegistryObject<TileEntityType<ManaDynamoTile>> MANA_DYNAMO_TILE = TILES.register("mana_dynamo", () -> TileEntityType.Builder.of(ManaDynamoTile::new, MANA_DYNAMO.get()).build(null));



}
