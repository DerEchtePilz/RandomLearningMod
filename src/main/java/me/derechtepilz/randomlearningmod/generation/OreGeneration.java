package me.derechtepilz.randomlearningmod.generation;

import me.derechtepilz.randomlearningmod.RandomLearningMod;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class OreGeneration {

	public static void generateOres() {
		BiomeModifications.addFeature(
			BiomeSelectors.foundInOverworld(),
			GenerationStep.Feature.UNDERGROUND_ORES,
			new PlacedFeatureBuilder<>(Identifier.of(RandomLearningMod.MOD_ID, "overworld_cobalt_ore"), Feature.ORE)
				.addTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COBALT_ORE.getDefaultState())                    // Replace stone
				.addTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_COBALT_ORE.getDefaultState())      // Replace deepslate
				.buildConfiguredFeature()
				.addPlacementModifier(CountPlacementModifier.of(3))                                                          // Three veins per chunk
				.addPlacementModifier(SquarePlacementModifier.of())                                                                 // Spread everything horizontally
				.addPlacementModifier(HeightRangePlacementModifier.trapezoid(
					YOffset.aboveBottom(69),                                                                                 // Generate ores starting at Y= 5
					YOffset.aboveBottom(85)                                                                                  // Generate ores stopping at Y=21
				))
				.toRegistryKey()
		);
	}
}
