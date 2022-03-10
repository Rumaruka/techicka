package com.rumaruka.techicka.init;

import com.rumaruka.techicka.ModSetup;
import com.rumaruka.techicka.common.modules.thermal.botania.blocks.BManaDynamoBlock;
import com.rumaruka.techicka.common.modules.thermal.botania.tiles.BManaDynamoTile;
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

public class TBotania {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);


    public static void setup() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    public static RegistryObject<Block> BOTANIA_DYNAMO_MANA_BLOCK = BLOCKS.register("bmana_dynamo", BManaDynamoBlock::new);
    public static final RegistryObject<BlockItem> BOTANIA_DYNAMO_MANA_BLOCK_ITEM = BLOCKITEMS.register("bmana_dynamo", () -> new BlockItem(BOTANIA_DYNAMO_MANA_BLOCK.get(), new Item.Properties().tab(ModSetup.TechickaGroup)));

    public static RegistryObject<TileEntityType<BManaDynamoTile>> BOTANIA_DYNAMO_MANA_TILE = TILES.register("bmana_dynamo", () -> TileEntityType.Builder.of(BManaDynamoTile::new, BOTANIA_DYNAMO_MANA_BLOCK.get()).build(null));


}
