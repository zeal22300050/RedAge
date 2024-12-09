package com.servent.redage.datagen.server.loot;

import com.servent.redage.enitity.RedAgeEntities;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

import static net.minecraft.world.level.storage.loot.LootPool.lootPool;

public class CustomEntityLootProvider extends EntityLootSubProvider {
    protected CustomEntityLootProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.add(RedAgeEntities.RED_SLIME.get(), LootTable.lootTable().withPool(
                    lootPool().setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.REDSTONE)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))))
                        .when(LootItemEntityPropertyCondition.hasProperties(
                                LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.entity().subPredicate(SlimePredicate.sized(MinMaxBounds.Ints.exactly(1)))))
        ));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return RedAgeEntities.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }
}
