package me.derechtepilz.randomlearningmod.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CobaltMaterial implements ToolMaterial {

    public static final CobaltMaterial INSTANCE = new CobaltMaterial();

    @Override
    public int getDurability() {
        return 2578;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() {
        return 6.0f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 40;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.OP_ITEM);
    }
}
