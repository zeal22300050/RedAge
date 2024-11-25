package com.servent.redage.datagen.client;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RedAgeBlockStateProvider extends BlockStateProvider {
    public RedAgeBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RedAge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(RedAgeBlocks.ZINC_BLOCK);
        simpleBlockWithItem(RedAgeBlocks.RAW_ZINC_BLOCK);
        simpleBlockWithItem(RedAgeBlocks.ZINC_ORE);
        simpleBlockWithItem(RedAgeBlocks.DEEPSLATE_ZINC_ORE);

        logBlock((RotatedPillarBlock) RedAgeBlocks.RED_LOG.get());
        logBlock((RotatedPillarBlock) RedAgeBlocks.STRIPPED_RED_LOG.get());
        axisBlock((RotatedPillarBlock) RedAgeBlocks.RED_WOOD.get(),
                blockTexture(RedAgeBlocks.RED_LOG.get()),
                blockTexture(RedAgeBlocks.RED_LOG.get()));
        axisBlock((RotatedPillarBlock) RedAgeBlocks.STRIPPED_RED_WOOD.get(),
                blockTexture(RedAgeBlocks.STRIPPED_RED_LOG.get()),
                blockTexture(RedAgeBlocks.STRIPPED_RED_LOG.get()));
        item(RedAgeBlocks.RED_LOG);
        item(RedAgeBlocks.RED_WOOD);
        item(RedAgeBlocks.STRIPPED_RED_LOG);
        item(RedAgeBlocks.STRIPPED_RED_WOOD);
        redLeaves(RedAgeBlocks.RED_LEAVES);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                RedAge.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 呪われた葉ブロック
    private void redLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeTop(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                TextureMapping.getBlockTexture(block.get(), "_side"),
                TextureMapping.getBlockTexture(block.get(), "_top")
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }
}
