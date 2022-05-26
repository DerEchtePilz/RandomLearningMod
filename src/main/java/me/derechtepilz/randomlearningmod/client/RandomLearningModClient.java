package me.derechtepilz.randomlearningmod.client;

import me.derechtepilz.randomlearningmod.commands.TestCommand;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import me.derechtepilz.randomlearningmod.items.TestItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class RandomLearningModClient implements ClientModInitializer {

    public static final String MOD_ID = "randomlearningmod";

    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((dispatcher, bool) -> {
            TestCommand.register(dispatcher);
        });
        TestGameRule.registerRules();
        TestItems.registerItems();
    }
}
