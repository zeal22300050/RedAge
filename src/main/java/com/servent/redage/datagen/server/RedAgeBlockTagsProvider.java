package com.servent.redage.datagen.server;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.tag.RedAgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RedAgeBlockTagsProvider extends BlockTagsProvider {

    public RedAgeBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RedAge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // 採掘可能ツール設定
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(RedAgeBlocks.ZINC_BLOCK.get(),
                RedAgeBlocks.RAW_ZINC_BLOCK.get(),
                RedAgeBlocks.ZINC_ORE.get(),
                RedAgeBlocks.DEEPSLATE_ZINC_ORE.get());

        // ツールレベル設定
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(RedAgeBlocks.ZINC_BLOCK.get(),
                RedAgeBlocks.RAW_ZINC_BLOCK.get(),
                RedAgeBlocks.ZINC_ORE.get(),
                RedAgeBlocks.DEEPSLATE_ZINC_ORE.get());

        this.tag(RedAgeTags.Blocks.RED_LOG)
                .add(RedAgeBlocks.RED_LOG.get())
                .add(RedAgeBlocks.RED_WOOD.get())
                .add(RedAgeBlocks.STRIPPED_RED_LOG.get())
                .add(RedAgeBlocks.STRIPPED_RED_WOOD.get());

        this.tag(BlockTags.LOGS)
                .add(RedAgeBlocks.RED_LOG.get())
                .add(RedAgeBlocks.STRIPPED_RED_LOG.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(RedAgeBlocks.RED_LOG.get())
                .add(RedAgeBlocks.RED_WOOD.get())
                .add(RedAgeBlocks.STRIPPED_RED_LOG.get())
                .add(RedAgeBlocks.STRIPPED_RED_WOOD.get());

        this.tag(BlockTags.LEAVES)
                .add(RedAgeBlocks.RED_LEAVES.get());
    }
}
