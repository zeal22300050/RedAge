package com.servent.redage.datagen.client;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, RedAge.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(RedAgeItems.RAW_ZINC, "亜鉛原石");
        addItem(RedAgeItems.ZINC_INGOT, "亜鉛インゴット");
        addBlock(RedAgeBlocks.RAW_ZINC_BLOCK, "亜鉛原石ブロック");
        addBlock(RedAgeBlocks.ZINC_BLOCK, "亜鉛ブロック");
        addBlock(RedAgeBlocks.ZINC_ORE, "亜鉛鉱石");
        addBlock(RedAgeBlocks.DEEPSLATE_ZINC_ORE, "深層亜鉛鉱石");
        addBlock(RedAgeBlocks.STRIPPED_RED_LOG, "樹皮を剥いだ紅の原木");
        addBlock(RedAgeBlocks.STRIPPED_RED_WOOD, "樹皮を剥いだ紅の木");
        addBlock(RedAgeBlocks.RED_LOG, "紅の原木");
        addBlock(RedAgeBlocks.RED_WOOD, "紅の木");
        addBlock(RedAgeBlocks.RED_LEAVES, "紅の葉");
        add("creativetabs.redage_tab", "RedAge");
    }
}
