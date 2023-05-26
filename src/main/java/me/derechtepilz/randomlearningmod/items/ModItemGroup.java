package me.derechtepilz.randomlearningmod.items;

import me.derechtepilz.randomlearningmod.RandomLearningModClient;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup EPIC_ITEMS = FabricItemGroupBuilder.create(
            new Identifier(RandomLearningModClient.MOD_ID, "epic_items"))
            .icon(() -> new ItemStack(ModItems.OP_ITEM))
            .appendItems(stacks -> {
                stacks.add(ModItems.OP_ITEM.getDefaultStack());
                stacks.add(ModItems.MINING_CORE.getDefaultStack());
                stacks.add(ModItems.ENERGY_CORE.getDefaultStack());
                stacks.add(ModItems.SUPER_NETHERITE_INGOT.getDefaultStack());
                stacks.add(ModItems.COBALT_SWORD.getDefaultStack());
                stacks.add(ModItems.COBALT_FRAGMENT.getDefaultStack());
                stacks.add(ModItems.COBALT_ORE.getDefaultStack());
				stacks.add(ModItems.COBALT_BLOCK.getDefaultStack());
            })
            .build();
}
