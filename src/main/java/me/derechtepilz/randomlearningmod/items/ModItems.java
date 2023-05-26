package me.derechtepilz.randomlearningmod.items;

import me.derechtepilz.randomlearningmod.RandomLearningModClient;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.items.logic.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class ModItems {

    // Usable items
    public static final Item OP_ITEM = new OPItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.EPIC_ITEMS));

    // Normal items
    public static final Item SUPER_NETHERITE_INGOT = new SuperNetheriteIngot(new FabricItemSettings().fireproof().rarity(Rarity.RARE).group(ModItemGroup.EPIC_ITEMS));
    public static final Item MINING_CORE = new MiningCore(new FabricItemSettings().fireproof().rarity(Rarity.RARE).maxCount(1).group(ModItemGroup.EPIC_ITEMS));
    public static final Item ENERGY_CORE = new EnergyCore(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1).group(ModItemGroup.EPIC_ITEMS));
    public static final Item COBALT_FRAGMENT = new Item(new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));

    // Food items

    // Tools

    // Weapons
    public static final SwordItem COBALT_SWORD = new LongSwordItem(CoolToolMaterial.INSTANCE, 10, -3.1f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));

    // Block items
    public static final Item COBALT_ORE = new BlockItem(ModBlocks.COBALT_ORE, new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));
	public static final Item COBALT_BLOCK = new BlockItem(ModBlocks.COBALT_BLOCK, new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "op_item"), OP_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "cobalt_sword"), COBALT_SWORD);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "cobalt_fragment"), COBALT_FRAGMENT);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "super_netherite_ingot"), SUPER_NETHERITE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "mining_core"), MINING_CORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "energy_core"), ENERGY_CORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "cobalt_ore"), COBALT_ORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "cobalt_block"), COBALT_BLOCK);
    }

    public Item getOpItem() {
        return OP_ITEM;
    }

    public Item getCobaltSword() {
        return COBALT_SWORD;
    }

    public Item getSuperNetheriteIngot() {
        return SUPER_NETHERITE_INGOT;
    }

    public Item getMiningCore() {
        return MINING_CORE;
    }

    public Item getEnergyCore() {
        return ENERGY_CORE;
    }

    public Item getCobaltFragment() {
        return COBALT_FRAGMENT;
    }

    public Item getCobaltOre() {
        return COBALT_ORE;
    }
}
