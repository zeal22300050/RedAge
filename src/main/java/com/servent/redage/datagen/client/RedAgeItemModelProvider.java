package com.servent.redage.datagen.client;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RedAgeItemModelProvider extends ItemModelProvider {

    public RedAgeItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RedAge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(RedAgeItems.RAW_ZINC.get());
        basicItem(RedAgeItems.ZINC_INGOT.get());

        itemWithBlock(RedAgeBlocks.RED_SLAB);
        itemWithBlock(RedAgeBlocks.RED_STAIRS);
        itemWithBlock(RedAgeBlocks.RED_FENCE_GATE);
        itemWithBlock(RedAgeBlocks.RED_PRESSURE_PLATE);
        basicItem(RedAgeBlocks.RED_DOOR.get().asItem());
        trapdoor(RedAgeBlocks.RED_TRAPDOOR);
        fence(RedAgeBlocks.RED_FENCE, RedAgeBlocks.RED_PLANKS);
        button(RedAgeBlocks.RED_BUTTON, RedAgeBlocks.RED_PLANKS);
        sapling(RedAgeBlocks.RED_SAPLING);

        withExistingParent(RedAgeItems.RED_SLIME_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        RedAge.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        RedAge.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RedAge.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RedAge.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RedAge.MOD_ID,"block/" + block.getId().getPath()));
    }

}
