package me.derechtepilz.randomlearningmod;

import com.mojang.brigadier.CommandDispatcher;
import me.derechtepilz.randomlearningmod.blocks.ModBlocks;
import me.derechtepilz.randomlearningmod.commands.TestCommand;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import me.derechtepilz.randomlearningmod.generation.OreGeneration;
import me.derechtepilz.randomlearningmod.generation.ore.ModConfiguredFeatures;
import me.derechtepilz.randomlearningmod.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class RandomLearningModClient implements ClientModInitializer {

    public static final String MOD_ID = "randomlearningmod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        // Generate data here

        // Reload data

        // Register stuff
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            TestCommand.register(dispatcher, registryAccess);
        });
        // ModConfiguredFeatures.registerConfiguredFeatures();
        TestGameRule.registerRules();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        OreGeneration.generateOres();
    }
}
