package me.derechtepilz.randomlearningmod.client;

import me.derechtepilz.randomlearningmod.commands.TestCommand;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class RandomLearningModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((dispatcher, bool) -> {
            TestCommand.register(dispatcher);
        });
    }
}
