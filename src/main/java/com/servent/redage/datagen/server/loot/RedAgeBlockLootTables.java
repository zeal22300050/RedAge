package com.servent.redage.datagen.server.loot;

import com.servent.redage.block.RedAgeBlocks;
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
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RedAgeBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator; // 動画 4:36からスタート
    }
}
