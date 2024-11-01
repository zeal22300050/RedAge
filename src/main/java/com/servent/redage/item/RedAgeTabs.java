package com.servent.redage.item;

import com.servent.redage.RedAge;
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
                    })
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
