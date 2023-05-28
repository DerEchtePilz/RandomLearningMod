package me.derechtepilz.randomlearningmod.datageneration;

import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelGeneration extends FabricModelProvider {

	public ModelGeneration(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COBALT_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_BLOCK);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		// Register tools
		itemModelGenerator.register(ModItems.COBALT_SWORD, Models.HANDHELD);
		itemModelGenerator.register(ModItems.COBALT_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(ModItems.COBALT_AXE, Models.HANDHELD);
		itemModelGenerator.register(ModItems.COBALT_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(ModItems.COBALT_HOE, Models.HANDHELD);

		// Register "normal" items
		itemModelGenerator.register(ModItems.OP_ITEM, Models.GENERATED);
		itemModelGenerator.register(ModItems.ENERGY_CORE, Models.GENERATED);
		itemModelGenerator.register(ModItems.MINING_CORE, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_NETHERITE_INGOT, Models.GENERATED);
		itemModelGenerator.register(ModItems.COBALT_FRAGMENT, Models.GENERATED);
		itemModelGenerator.register(ModItems.COBALT_ORE, Models.GENERATED);
		itemModelGenerator.register(ModItems.DEEPSLATE_COBALT_ORE, Models.GENERATED);
		itemModelGenerator.register(ModItems.COBALT_BLOCK, Models.GENERATED);
	}

}
