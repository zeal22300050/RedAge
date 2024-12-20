package com.servent.redage.worldgen.biome;

import com.servent.redage.RedAge;
import com.servent.redage.worldgen.placement.RedAgePlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class RedAgeBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ZINC_ORE = createKey("add_zinc_ore");

    public static final ResourceKey<BiomeModifier> ADD_RED_TREE = createKey("add_red_tree");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ZINC_ORE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(RedAgePlacement.ORE_ZINC)),
                        GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RED_TREE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                        HolderSet.direct(placedFeatures.getOrThrow(RedAgePlacement.RED_TREE)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(RedAge.MOD_ID, name));
    }
}
