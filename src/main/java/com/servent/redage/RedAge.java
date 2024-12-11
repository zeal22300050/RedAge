package com.servent.redage;

import com.mojang.logging.LogUtils;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.enitity.RedAgeEntities;
import com.servent.redage.item.RedAgeItems;
import com.servent.redage.item.RedAgeTabs;
import com.servent.redage.loot.RedAgeLootModifiers;
import com.servent.redage.worldgen.biome.RedAgeOverworldRegion;
import com.servent.redage.worldgen.biome.RedAgeSurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(RedAge.MOD_ID)
public class RedAge {
    public static final String MOD_ID = "redage";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RedAge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // アイテムをイベントバスに登録
        RedAgeItems.register(modEventBus);
        // クリエイティブタブをバスに登録
        RedAgeTabs.register(modEventBus);
        // ブロックをバスに追加
        RedAgeBlocks.register(modEventBus);
        // GlobalLootModifierを登録
        RedAgeLootModifiers.register(modEventBus);
        // エンティティの登録
        RedAgeEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new RedAgeOverworldRegion(new ResourceLocation(RedAge.MOD_ID, "overworld"), 5));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, RedAgeSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(RedAgeItems.RAW_ZINC);
            event.accept(RedAgeItems.ZINC_INGOT);
            event.accept(RedAgeBlocks.ZINC_BLOCK);
            event.accept(RedAgeBlocks.RAW_ZINC_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
