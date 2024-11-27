package com.servent.redage.worldgen.placement;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.worldgen.features.RedAgeFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class RedAgePlacement {
    public static final ResourceKey<PlacedFeature> ORE_ZINC = createKey("ore_zinc");

    public static final ResourceKey<PlacedFeature> RED_TREE = createKey("red_tree");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, ORE_ZINC, configuredFeatures.getOrThrow(RedAgeFeatures.ZINC_ORE_KEY),
                commonOrePlacement(90, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(112))));

        PlacementUtils.register(context, RED_TREE, configuredFeatures.getOrThrow(RedAgeFeatures.RED_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(10, 0.1f, 1), // ２つ目の引数は1を割り切れる数にする
                        RedAgeBlocks.RED_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(RedAge.MOD_ID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
