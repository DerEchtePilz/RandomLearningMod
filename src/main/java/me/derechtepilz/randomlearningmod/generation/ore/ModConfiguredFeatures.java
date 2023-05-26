package me.derechtepilz.randomlearningmod.generation.ore;

import me.derechtepilz.randomlearningmod.RandomLearningModClient;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
	public static final List<OreFeatureConfig.Target> OVERWORLD_COBALT_ORES = List.of(
		OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COBALT_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.COBALT_ORE.getDefaultState())
	);
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> COBALT_ORE =
		ConfiguredFeatures.register(
			"cobalt_ore",
			Feature.ORE,
			new OreFeatureConfig(OVERWORLD_COBALT_ORES, 4)
		);

	public static void registerConfiguredFeatures() {
		System.out.println("Registering ModConfiguredFeatures for " + RandomLearningModClient.MOD_ID);
	}
}
