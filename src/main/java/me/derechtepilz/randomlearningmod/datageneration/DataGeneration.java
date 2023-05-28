package me.derechtepilz.randomlearningmod.datageneration;

import me.derechtepilz.randomlearningmod.RandomLearningMod;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGeneration implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		ModBlocks.registerBlocks();
		ModItems.registerItems();

		fabricDataGenerator.addProvider(ModelGeneration::new);
	}

	@Override
	public String getEffectiveModId() {
		return RandomLearningMod.MOD_ID;
	}

}
