package com.servent.redage.block;

import com.servent.redage.RedAge;
import com.servent.redage.block.custom.RedAgeLeavesBlock;
import com.servent.redage.block.custom.RedAgeLogBLock;
import com.servent.redage.block.custom.RedAgeStrippableLogBlock;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
            () -> new RedAgeStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG), STRIPPED_RED_LOG));

    public static final RegistryObject<Block> RED_WOOD = registerBlockItem("red_wood",
            () -> new RedAgeStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD), STRIPPED_RED_WOOD));

    public static final RegistryObject<Block> RED_LEAVES = registerBlockItem("red_leaves",
            () -> new RedAgeLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> RED_PLANKS = registerBlockItem("red_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> RED_SLAB = registerBlockItem("red_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> RED_STAIRS = registerBlockItem("red_stairs",
            () -> new StairBlock(RedAgeBlocks.RED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> RED_FENCE = registerBlockItem("red_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> RED_FENCE_GATE = registerBlockItem("red_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> RED_DOOR = registerBlockItem("red_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> RED_TRAPDOOR = registerBlockItem("red_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> RED_BUTTON = registerBlockItem("red_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<Block> RED_PRESSURE_PLATE = registerBlockItem("red_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));


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
