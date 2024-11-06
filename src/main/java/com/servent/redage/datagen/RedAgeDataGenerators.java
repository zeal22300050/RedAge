package com.servent.redage.datagen;

import com.servent.redage.RedAge;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.xml.crypto.Data;

@Mod.EventBusSubscriber(modid = RedAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedAgeDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new RedAgeItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new RedAgeBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

    }
}
