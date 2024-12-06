package com.servent.redage.item;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RedAgeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedAge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REDAGE_TAB = TABS.register("redage_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.redage_tab"))
                    .icon(RedAgeItems.ZINC_INGOT.get()::getDefaultInstance)
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RedAgeItems.RAW_ZINC.get());
                        output.accept(RedAgeItems.ZINC_INGOT.get());
                        output.accept(RedAgeBlocks.ZINC_BLOCK.get());
                        output.accept(RedAgeBlocks.RAW_ZINC_BLOCK.get());
                        output.accept(RedAgeBlocks.ZINC_ORE.get());
                        output.accept(RedAgeBlocks.DEEPSLATE_ZINC_ORE.get());
                        output.accept(RedAgeBlocks.RED_LOG.get());
                        output.accept(RedAgeBlocks.RED_WOOD.get());
                        output.accept(RedAgeBlocks.STRIPPED_RED_LOG.get());
                        output.accept(RedAgeBlocks.STRIPPED_RED_WOOD.get());
                        output.accept(RedAgeBlocks.RED_LEAVES.get());
                        output.accept(RedAgeBlocks.RED_PLANKS.get());
                        output.accept(RedAgeBlocks.RED_SLAB.get());
                        output.accept(RedAgeBlocks.RED_STAIRS.get());
                        output.accept(RedAgeBlocks.RED_FENCE.get());
                        output.accept(RedAgeBlocks.RED_FENCE_GATE.get());
                        output.accept(RedAgeBlocks.RED_DOOR.get());
                        output.accept(RedAgeBlocks.RED_TRAPDOOR.get());
                        output.accept(RedAgeBlocks.RED_BUTTON.get());
                        output.accept(RedAgeBlocks.RED_PRESSURE_PLATE.get());
                        output.accept(RedAgeBlocks.RED_SAPLING.get());
                        output.accept(RedAgeItems.RED_SLIME_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
