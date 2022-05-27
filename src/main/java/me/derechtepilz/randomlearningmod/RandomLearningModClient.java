package me.derechtepilz.randomlearningmod;

import me.derechtepilz.randomlearningmod.commands.TestCommand;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import me.derechtepilz.randomlearningmod.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

@Environment(EnvType.CLIENT)
public class RandomLearningModClient implements ClientModInitializer {

    public static final String MOD_ID = "randomlearningmod";

    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((dispatcher, bool) -> {
            TestCommand.register(dispatcher);
        });
        TestGameRule.registerRules();
        ModItems.registerItems();
    }
}
