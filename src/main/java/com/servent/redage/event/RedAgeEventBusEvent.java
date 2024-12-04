package com.servent.redage.event;

import com.servent.redage.RedAge;
import com.servent.redage.enitity.RedAgeEntities;
import com.servent.redage.enitity.custom.RedSlime;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedAgeEventBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RedAgeEntities.RED_SLIME.get(), RedSlime.createAttributes().build());
    }
}
