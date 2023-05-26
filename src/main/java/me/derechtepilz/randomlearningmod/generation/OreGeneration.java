package me.derechtepilz.randomlearningmod.generation;

import me.derechtepilz.randomlearningmod.RandomLearningModClient;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.generation.ore.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class OreGeneration {
	public static void generateOres() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(RandomLearningModClient.MOD_ID, "overworld_cobalt_ore"), OVERWORLD_COBALT_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(RandomLearningModClient.MOD_ID, "overworld_cobalt_ore"), OVERWORLD_COBALT_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RandomLearningModClient.MOD_ID, "overworld_cobalt_ore")));
	}

	private static final ConfiguredFeature<?, ?> OVERWORLD_COBALT_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
		Feature.ORE,
		new OreFeatureConfig(
			List.of(
				OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COBALT_ORE.getDefaultState()),        // Stone should be replaced
				OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.COBALT_ORE.getDefaultState())     // Deepslate should be replaced
			),
			4 // Vein size should be four at maximum
		)
	);

	private static final PlacedFeature OVERWORLD_COBALT_ORE_PLACED_FEATURE = new PlacedFeature(
		RegistryEntry.of(OVERWORLD_COBALT_ORE_CONFIGURED_FEATURE),
		List.of(
			CountPlacementModifier.of(3), // Three veins per chunk
			SquarePlacementModifier.of(),        // Spread everything horizontally
			HeightRangePlacementModifier.trapezoid(
				YOffset.aboveBottom(69), // Generate ores starting at Y= 5
				YOffset.aboveBottom(85)  // Generate ores stopping at Y=21
			)
		)
	);



}
