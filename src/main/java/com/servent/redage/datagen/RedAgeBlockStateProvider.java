package com.servent.redage.datagen;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class RedAgeBlockStateProvider extends BlockStateProvider {
    public RedAgeBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RedAge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(RedAgeBlocks.ZINC_BLOCK);
        simpleBlockWithItem(RedAgeBlocks.RAW_ZINC_BLOCK);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
