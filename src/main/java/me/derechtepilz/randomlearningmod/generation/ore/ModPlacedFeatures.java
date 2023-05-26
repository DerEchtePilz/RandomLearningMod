package me.derechtepilz.randomlearningmod.generation.ore;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> COBALT_ORE_PLACED =
	    PlacedFeatures.register(
			"cobalt_ore_placed",
		    ModConfiguredFeatures.COBALT_ORE,
		    ModOreFeatures.modifiersWithCount(
				1,
			    HeightRangePlacementModifier.trapezoid(
					YOffset.aboveBottom(69), // -64 + 69 =  5
				    YOffset.aboveBottom(85)  // -64 + 85 = 21
			    )
		    )
	    );
}
