package com.servent.redage.event;

import com.servent.redage.RedAge;
import com.servent.redage.enitity.RedAgeEntities;
import com.servent.redage.enitity.model.RedSlimeModel;
import com.servent.redage.enitity.renderer.RedSlimeRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RedAgeEventBusClientEvent {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RedSlimeModel.LAYER_LOCATION, RedSlimeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(RedAgeEntities.RED_SLIME.get(), RedSlimeRenderer::new);
    }
}
