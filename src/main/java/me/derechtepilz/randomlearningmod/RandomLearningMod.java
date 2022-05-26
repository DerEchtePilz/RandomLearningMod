package me.derechtepilz.randomlearningmod;

import me.derechtepilz.randomlearningmod.commands.TestCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class RandomLearningMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, bool) -> {
            TestCommand.register(dispatcher);
        });
    }
}
