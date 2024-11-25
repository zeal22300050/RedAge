package com.servent.redage.datagen.client;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, RedAge.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(RedAgeItems.RAW_ZINC, "Raw Zinc");
        addItem(RedAgeItems.ZINC_INGOT, "Zinc Ingot");
        addBlock(RedAgeBlocks.RAW_ZINC_BLOCK, "Raw Zinc Block");
        addBlock(RedAgeBlocks.ZINC_BLOCK, "Zinc Block");
        addBlock(RedAgeBlocks.ZINC_ORE, "Zinc Ore");
        addBlock(RedAgeBlocks.DEEPSLATE_ZINC_ORE, "Deepslate Zinc Ore");
        addBlock(RedAgeBlocks.STRIPPED_RED_LOG, "Stripped Red Log");
        addBlock(RedAgeBlocks.STRIPPED_RED_WOOD, "Stripped Red Wood");
        addBlock(RedAgeBlocks.RED_LOG, "Red Log");
        addBlock(RedAgeBlocks.RED_WOOD, "Red Wood");
        addBlock(RedAgeBlocks.RED_LEAVES, "Red Leaves");
        add("creativetabs.redage_tab", "RedAge");
    }
}
