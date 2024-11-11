package com.servent.redage.datagen.server;

import com.servent.redage.RedAge;
import com.servent.redage.item.RedAgeItems;
import com.servent.redage.loot.AddItemModifier;
import com.servent.redage.loot.ReplaceItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class RedAgeGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public RedAgeGlobalLootModifierProvider(PackOutput output) {
        super(output, RedAge.MOD_ID);
    }

    @Override
    protected void start() {
        // 荒廃したポータルのチェスト
        add("zinc_ingot_from_ruined_portal", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()
        }, RedAgeItems.ZINC_INGOT.get()));

        // ゾンビドロップ
        add("zinc_ingot_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, RedAgeItems.ZINC_INGOT.get()));

        // スニッファーの掘り出し物
        add("zinc_ingot_from_sniffer_digging", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build()
        }, RedAgeItems.ZINC_INGOT.get(), 0.5f));

        // 怪しげな砂
        add("zinc_ingot_from_sus_sand", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build()
        }, RedAgeItems.ZINC_INGOT.get(), 0.5f));
    }
}
