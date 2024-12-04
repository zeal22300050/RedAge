package com.servent.redage.enitity;

import com.servent.redage.RedAge;
import com.servent.redage.enitity.custom.RedSlime;
import com.servent.redage.enitity.model.RedSlimeModel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RedAgeEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RedAge.MOD_ID);

    public static final RegistryObject<EntityType<RedSlime>> RED_SLIME =
            ENTITY_TYPES.register("red_slime", () -> EntityType.Builder.of(RedSlime::new, MobCategory.MONSTER).build("red_slime"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
