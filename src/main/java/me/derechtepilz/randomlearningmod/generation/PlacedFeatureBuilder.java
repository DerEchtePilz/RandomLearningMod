package me.derechtepilz.randomlearningmod.generation;

import net.minecraft.block.BlockState;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.ArrayList;
import java.util.List;

public class PlacedFeatureBuilder<FC extends FeatureConfig> {

	private final Identifier identifier;
	private final Feature<FC> feature;
	private final List<OreFeatureConfig.Target> targets = new ArrayList<>();
	private int veinSize = 4;

	public PlacedFeatureBuilder(Identifier identifier, Feature<FC> feature) {
		this.identifier = identifier;
		this.feature = feature;
	}

	public PlacedFeatureBuilder<FC> addTarget(RuleTest test, BlockState state) {
		targets.add(OreFeatureConfig.createTarget(test, state));
		return this;
	}

	public PlacedFeatureBuilder<FC> setVeinSize(int veinSize) {
		this.veinSize = veinSize;
		return this;
	}

	public PlacedFeatureConfigurator buildConfiguredFeature() {
		ConfiguredFeature<?, ?> configuredFeature = new ConfiguredFeature<>((Feature<FeatureConfig>) feature, new OreFeatureConfig(targets, veinSize));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, identifier, configuredFeature);
		return new PlacedFeatureConfigurator(configuredFeature);
	}

	public class PlacedFeatureConfigurator {

		private final RegistryEntry<ConfiguredFeature<?, ?>> registryEntry;
		private final List<PlacementModifier> placementModifiers = new ArrayList<>();

		public PlacedFeatureConfigurator(ConfiguredFeature<?, ?> configuredFeature) {
			registryEntry = RegistryEntry.of(configuredFeature);
		}

		public PlacedFeatureConfigurator addPlacementModifier(PlacementModifier modifier) {
			placementModifiers.add(modifier);
			return this;
		}

		public RegistryKey<PlacedFeature> toRegistryKey() {
			PlacedFeature placedFeature = new PlacedFeature(registryEntry, placementModifiers);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, identifier, placedFeature);
			return RegistryKey.of(Registry.PLACED_FEATURE_KEY, identifier);
		}

	}

}
