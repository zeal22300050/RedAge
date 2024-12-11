package com.servent.redage.worldgen.biome;

import com.servent.redage.block.RedAgeBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class RedAgeSurfaceRuleData {
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource RED =
            makeStateRule(Blocks.REDSTONE_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                // 呪われた森バイオームの地面を指定したブロックにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(RedAgeBiomes.RED_CURSED_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MUD)),
                // 呪われた森バイオームの天井を指定したブロックにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(RedAgeBiomes.RED_CURSED_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
