package com.servent.redage.worldgen.features;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class RedAgeOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = createKey("zinc_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> zincOres = List.of(
                OreConfiguration.target(stone, RedAgeBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, RedAgeBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));
        FeatureUtils.register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(zincOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RedAge.MOD_ID, name));
    }
}
