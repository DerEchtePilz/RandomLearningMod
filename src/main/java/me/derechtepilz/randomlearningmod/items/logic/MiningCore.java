package me.derechtepilz.randomlearningmod.items.logic;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MiningCore extends Item {
    public MiningCore(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack itemStack) {
        return true;
    }
}
