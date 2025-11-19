package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.registry.ModBlocks
import com.lumi.computers_plus_plus.registry.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.crafting.ShapelessRecipe
import net.neoforged.neoforge.common.conditions.IConditionBuilder
import java.util.concurrent.CompletableFuture

class Recipes : RecipeProvider, IConditionBuilder {

    constructor(output: PackOutput, future: CompletableFuture<HolderLookup.Provider>)
            : super(output, future) {}


    override fun buildRecipes(output: RecipeOutput) {

        ShapedRecipeBuilder.shaped(
            RecipeCategory.BUILDING_BLOCKS,
            ModBlocks.SILICON_BLOCK.item.get())
            
            .define('S', ModItems.SILICON.get())
            
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            
            .unlockedBy("has_silicon", has(ModItems.SILICON))
            .save(output);

        ShapelessRecipeBuilder.shapeless(
            RecipeCategory.MISC,
            ModItems.SILICON.get(),
            9)
            .requires(ModBlocks.SILICON_BLOCK.item.get())
            .unlockedBy("has_silicon_block", has(ModItems.SILICON.get()))
            .save(output)
        
    }
}
