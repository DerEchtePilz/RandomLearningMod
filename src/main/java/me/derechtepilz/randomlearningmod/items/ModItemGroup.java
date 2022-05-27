package me.derechtepilz.randomlearningmod.items;

import me.derechtepilz.randomlearningmod.RandomLearningModClient;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup EPIC_ITEMS = FabricItemGroupBuilder.create(
            new Identifier(RandomLearningModClient.MOD_ID, "epic_items"))
            .icon(() -> new ItemStack(ModItems.getOpItem()))
            .appendItems(stacks -> {
                stacks.add(ModItems.getOpItem().getDefaultStack());
                stacks.add(ModItems.getMiningCore().getDefaultStack());
                stacks.add(ModItems.getEnergyCore().getDefaultStack());
                stacks.add(ModItems.getSuperNetheriteIngot().getDefaultStack());
                stacks.add(ModItems.getCobaltSword().getDefaultStack());
                stacks.add(ModItems.getCobaltFragment().getDefaultStack());
            })
            .build();
}
