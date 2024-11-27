package com.servent.redage.tag;

import com.servent.redage.RedAge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RedAgeTags {
    public static class Blocks {
        public static final TagKey<Block> RED_LOG = tag("red_log");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RedAge.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> RED_LOG = tag("red_log");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RedAge.MOD_ID, name));
        }
    }
}
