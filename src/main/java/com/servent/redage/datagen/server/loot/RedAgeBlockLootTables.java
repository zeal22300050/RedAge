package com.servent.redage.datagen.server.loot;

import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class RedAgeBlockLootTables extends BlockLootSubProvider {
    protected RedAgeBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(RedAgeBlocks.ZINC_BLOCK.get());
        this.dropSelf(RedAgeBlocks.RAW_ZINC_BLOCK.get());
        this.add(RedAgeBlocks.ZINC_ORE.get(), block -> this.createOreDrop(block, RedAgeItems.RAW_ZINC.get()));
        this.add(RedAgeBlocks.DEEPSLATE_ZINC_ORE.get(), block -> this.createOreDrop(block, RedAgeItems.RAW_ZINC.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RedAgeBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
