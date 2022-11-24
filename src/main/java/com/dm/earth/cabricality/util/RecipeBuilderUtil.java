package com.dm.earth.cabricality.util;

import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;

public class RecipeBuilderUtil {
	public static ShapedRecipe donutRecipe(Identifier id, Item center, Item other, Item output, int count) {
		return VanillaRecipeBuilders.shapedRecipe("OOO", "OXO", "OOO").ingredient('X', Ingredient.ofItems(center))
				.ingredient('O', Ingredient.ofItems(other)).output(new ItemStack(output, count)).build(id, "");
	}
}
