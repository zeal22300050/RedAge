package com.servent.redage.item;

import com.servent.redage.RedAge;
import com.servent.redage.enitity.RedAgeEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class RedAgeItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RedAge.MOD_ID);

    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_SLIME_SPAWN_EGG = ITEMS.register("red_slime_spawn_egg", () -> new ForgeSpawnEggItem(RedAgeEntities.RED_SLIME, Color.MAGENTA.getRGB(), Color.RED.getRGB(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
