package me.derechtepilz.randomlearningmod.blocks;

import me.derechtepilz.randomlearningmod.RandomLearningMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class ModBlocks {

    public static final Block COBALT_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.5f), UniformIntProvider.create(1, 5));
	public static final Block DEEPSLATE_COBALT_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.5f), UniformIntProvider.create(1, 5));
    public static final Block COBALT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0f));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(RandomLearningMod.MOD_ID, "cobalt_ore"), COBALT_ORE);
	    Registry.register(Registry.BLOCK, new Identifier(RandomLearningMod.MOD_ID, "deepslate_cobalt_ore"), DEEPSLATE_COBALT_ORE);
        Registry.register(Registry.BLOCK, new Identifier(RandomLearningMod.MOD_ID, "cobalt_block"), COBALT_BLOCK);
    }
}
