package me.derechtepilz.randomlearningmod.items.logic;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnergyCore extends Item {
    public EnergyCore(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
