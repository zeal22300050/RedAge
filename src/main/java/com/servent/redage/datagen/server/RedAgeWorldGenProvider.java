package com.servent.redage.datagen.server;

import com.servent.redage.RedAge;
import com.servent.redage.worldgen.biome.RedAgeBiomeModifiers;
import com.servent.redage.worldgen.features.RedAgeFeatures;
import com.servent.redage.worldgen.placement.RedAgePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RedAgeWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, RedAgeFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, RedAgePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, RedAgeBiomeModifiers::bootstrap);

    public RedAgeWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(RedAge.MOD_ID));
    }
}
