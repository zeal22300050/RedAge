package com.servent.redage.datagen;

import com.servent.redage.RedAge;
import com.servent.redage.datagen.client.ENUSLanguageProvider;
import com.servent.redage.datagen.client.JAJPLanguageProvider;
import com.servent.redage.datagen.client.RedAgeBlockStateProvider;
import com.servent.redage.datagen.client.RedAgeItemModelProvider;
import com.servent.redage.datagen.server.RedAgeRecipeProvider;
import com.servent.redage.datagen.server.loot.RedAgeLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedAgeDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // アイテムのモデルファイル
        generator.addProvider(event.includeClient(), new RedAgeItemModelProvider(packOutput, existingFileHelper));
        // ブロックのモデルファイル
        generator.addProvider(event.includeClient(), new RedAgeBlockStateProvider(packOutput, existingFileHelper));
        // 翻訳データ
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        // レシピ
        generator.addProvider(event.includeServer(), new RedAgeRecipeProvider(packOutput));

        // ルートテーブル
        generator.addProvider(event.includeServer(), RedAgeLootTables.create(packOutput));
    }
}