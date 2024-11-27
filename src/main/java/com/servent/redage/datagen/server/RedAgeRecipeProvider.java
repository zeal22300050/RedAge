package com.servent.redage.datagen.server;

import com.servent.redage.RedAge;
import com.servent.redage.block.RedAgeBlocks;
import com.servent.redage.item.RedAgeItems;
import com.servent.redage.item.RedAgeTabs;
import com.servent.redage.tag.RedAgeTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
import java.util.List;

public class RedAgeRecipeProvider extends RecipeProvider {
    public RedAgeRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
    // 精錬可能アイテムリスト
    private static final List<ItemLike> ZINC_SMELTABLE = List.of(RedAgeItems.RAW_ZINC.get(),
            RedAgeBlocks.ZINC_ORE.get(),
            RedAgeBlocks.DEEPSLATE_ZINC_ORE.get());

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, RedAgeItems.ZINC_INGOT.get(),RecipeCategory.BUILDING_BLOCKS, RedAgeBlocks.ZINC_BLOCK.get());
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, RedAgeItems.RAW_ZINC.get(),RecipeCategory.BUILDING_BLOCKS, RedAgeBlocks.RAW_ZINC_BLOCK.get());

        oreSmelting(pRecipeOutput, ZINC_SMELTABLE, RecipeCategory.MISC, RedAgeItems.ZINC_INGOT.get(), 1.0f, 200, "zinc");
        oreBlasting(pRecipeOutput, ZINC_SMELTABLE, RecipeCategory.MISC, RedAgeItems.ZINC_INGOT.get(), 1.0f, 100, "zinc");

        woodFromLogs(pRecipeOutput, RedAgeBlocks.RED_WOOD.get(), RedAgeBlocks.RED_LOG.get());
        woodFromLogs(pRecipeOutput, RedAgeBlocks.STRIPPED_RED_WOOD.get(), RedAgeBlocks.STRIPPED_RED_LOG.get());

        planksFromLog(pRecipeOutput, RedAgeBlocks.RED_PLANKS.get(), RedAgeTags.Items.RED_LOG, 4);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, RedAgeBlocks.RED_SLAB.get(), RedAgeBlocks.RED_PLANKS.get());
        stairs(pRecipeOutput, RedAgeBlocks.RED_STAIRS.get(), RedAgeBlocks.RED_PLANKS.get());
        fence(pRecipeOutput, RedAgeBlocks.RED_FENCE.get(), RedAgeBlocks.RED_PLANKS.get());
        fenceGate(pRecipeOutput, RedAgeBlocks.RED_FENCE_GATE.get(), RedAgeBlocks.RED_PLANKS.get());
        door(pRecipeOutput, RedAgeBlocks.RED_DOOR.get(), RedAgeBlocks.RED_PLANKS.get());
        trapdoor(pRecipeOutput, RedAgeBlocks.RED_TRAPDOOR.get(), RedAgeBlocks.RED_PLANKS.get());
        button(pRecipeOutput, RedAgeBlocks.RED_BUTTON.get(), RedAgeBlocks.RED_PLANKS.get());
        pressurePlate(pRecipeOutput, RedAgeBlocks.RED_PRESSURE_PLATE.get(), RedAgeBlocks.RED_PLANKS.get());
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput,
                            RedAge.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }

    protected static void nineBlockStorageRecipes(RecipeOutput pRecipeOutput, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9).requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pRecipeOutput);
    }

    private static void stairs(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        stairBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fence(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        fenceBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fenceGate(RecipeOutput pRecipeOutput, ItemLike pResult,
                                  ItemLike pIngredient) {
        fenceGateBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void door(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        doorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void trapdoor(RecipeOutput pRecipeOutput, ItemLike pResult,
                                 ItemLike pIngredient) {
        trapdoorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void button(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        buttonBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
}
