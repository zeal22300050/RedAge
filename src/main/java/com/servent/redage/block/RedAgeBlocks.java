package com.servent.redage.block;

import com.servent.redage.RedAge;
import com.servent.redage.block.custom.RedAgeLeavesBlock;
import com.servent.redage.block.custom.RedAgeLogBLock;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RedAgeBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RedAge.MOD_ID);

    public static final RegistryObject<Block> ZINC_BLOCK = registerBlockItem("zinc_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBlockItem("raw_zinc_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ZINC_ORE = registerBlockItem("zinc_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlockItem("deepslate_zinc_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final RegistryObject<Block> STRIPPED_RED_LOG = registerBlockItem("stripped_red_log",
            () -> new RedAgeLogBLock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_RED_WOOD = registerBlockItem("stripped_red_wood",
            () -> new RedAgeLogBLock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> RED_LOG = registerBlockItem("red_log",
            () -> new RedAgeLogBLock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> RED_WOOD = registerBlockItem("red_wood",
            () -> new RedAgeLogBLock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> RED_LEAVES = registerBlockItem("red_leaves",
            () -> new RedAgeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        RedAgeItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
