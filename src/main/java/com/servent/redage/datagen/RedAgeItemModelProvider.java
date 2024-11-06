package com.servent.redage.datagen;

import com.servent.redage.RedAge;
import com.servent.redage.item.RedAgeItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RedAgeItemModelProvider extends ItemModelProvider {

    public RedAgeItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RedAge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(RedAgeItems.RAW_ZINC.get());
        basicItem(RedAgeItems.ZINC_INGOT.get());

    }
}
