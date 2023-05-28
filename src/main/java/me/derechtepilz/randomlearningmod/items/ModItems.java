package me.derechtepilz.randomlearningmod.items;

import me.derechtepilz.randomlearningmod.RandomLearningMod;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.items.logic.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class ModItems {

	/*
	 * AttackSpeed  = 4 + toolAttackSpeed
	 * AttackDamage = materialAttackDamage + toolAttackDamage + 1
	 */

    // Usable items
    public static final Item OP_ITEM = new OPItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.EPIC_ITEMS));

    // Normal items
    public static final Item SUPER_NETHERITE_INGOT = new SuperNetheriteIngot(new FabricItemSettings().fireproof().rarity(Rarity.RARE).group(ModItemGroup.EPIC_ITEMS));
    public static final Item MINING_CORE = new MiningCore(new FabricItemSettings().fireproof().rarity(Rarity.RARE).maxCount(1).group(ModItemGroup.EPIC_ITEMS));
    public static final Item ENERGY_CORE = new EnergyCore(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1).group(ModItemGroup.EPIC_ITEMS));
    public static final Item COBALT_FRAGMENT = new Item(new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));

    // Food items

    // Tools
	public static final PickaxeItem COBALT_PICKAXE = new PickaxeItem(CobaltMaterial.INSTANCE, -5, -3.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));
	public static final AxeItem COBALT_AXE = new AxeItem(CobaltMaterial.INSTANCE, 11, -3.3f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));
	public static final ShovelItem COBALT_SHOVEL = new ShovelItem(CobaltMaterial.INSTANCE, -5, -1.5f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));
	public static final HoeItem COBALT_HOE = new HoeItem(CobaltMaterial.INSTANCE, -5, 0.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));

    // Weapons
    public static final SwordItem COBALT_SWORD = new LongSwordItem(CobaltMaterial.INSTANCE, 10, -3.1f, new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.EPIC_ITEMS));

    // Block items
    public static final Item COBALT_ORE = new BlockItem(ModBlocks.COBALT_ORE, new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));
	public static final Item DEEPSLATE_COBALT_ORE = new BlockItem(ModBlocks.DEEPSLATE_COBALT_ORE, new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));
	public static final Item COBALT_BLOCK = new BlockItem(ModBlocks.COBALT_BLOCK, new FabricItemSettings().group(ModItemGroup.EPIC_ITEMS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "op_item"), OP_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_sword"), COBALT_SWORD);
		Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_pickaxe"), COBALT_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_axe"), COBALT_AXE);
		Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_shovel"), COBALT_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_hoe"), COBALT_HOE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_fragment"), COBALT_FRAGMENT);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "super_netherite_ingot"), SUPER_NETHERITE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "mining_core"), MINING_CORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "energy_core"), ENERGY_CORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_ore"), COBALT_ORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "deepslate_cobalt_ore"), DEEPSLATE_COBALT_ORE);
        Registry.register(Registry.ITEM, new Identifier(RandomLearningMod.MOD_ID, "cobalt_block"), COBALT_BLOCK);
    }

	public static class HoeItem extends net.minecraft.item.HoeItem {

		public HoeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
			super(toolMaterial, attackDamage, attackSpeed, settings);
		}

		public ItemStack getDefaultStack() {
			return new ItemStack(this);
		}

	}

}
