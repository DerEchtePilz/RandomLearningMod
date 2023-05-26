package me.derechtepilz.randomlearningmod.items.logic;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SuperNetheriteIngot extends Item {
    public SuperNetheriteIngot(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
