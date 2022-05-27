package me.derechtepilz.randomlearningmod.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CoolToolMaterial implements ToolMaterial {

    public static final CoolToolMaterial INSTANCE = new CoolToolMaterial();

    @Override
    public int getDurability() {
        return 2578;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
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
        return Ingredient.ofItems(ModItems.getOpItem());
    }
}
