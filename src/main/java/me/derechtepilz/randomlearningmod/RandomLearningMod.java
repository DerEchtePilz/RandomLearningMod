package me.derechtepilz.randomlearningmod;

import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.commands.TestCommand;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import me.derechtepilz.randomlearningmod.generation.OreGeneration;
import me.derechtepilz.randomlearningmod.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Environment(EnvType.CLIENT)
public class RandomLearningMod implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID = "randomlearningmod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        // Register stuff
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            TestCommand.register(dispatcher, registryAccess);
        });
        TestGameRule.registerRules();
        // Blocks and Items are registered in DataGeneration.java
        OreGeneration.generateOres();
    }

	@Override
	public void onInitialize() {

	}
}
