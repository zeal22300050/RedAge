package com.servent.redage.worldgen.features;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class RedAgeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = createKey("zinc_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_TREE_KEY = createKey("red_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> zincOres = List.of(
                OreConfiguration.target(stone, RedAgeBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, RedAgeBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(zincOres, 9));
        FeatureUtils.register(context, RED_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(RedAgeBlocks.RED_LOG.get()),
                        new StraightTrunkPlacer(5,3,4),
                        BlockStateProvider.simple(RedAgeBlocks.RED_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(1,0,2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RedAge.MOD_ID, name));
    }
}
