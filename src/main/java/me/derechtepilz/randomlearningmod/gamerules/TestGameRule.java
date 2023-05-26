package me.derechtepilz.randomlearningmod.gamerules;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

@Environment(EnvType.CLIENT)
public class TestGameRule {

    public static GameRules.Key<GameRules.BooleanRule> SHOULD_PIGS_FLY;
    public static GameRules.Key<GameRules.IntRule> DURATION_COMMAND;

    public static void registerRules() {
        SHOULD_PIGS_FLY = GameRuleRegistry.register("shouldPigsFly", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
        DURATION_COMMAND = GameRuleRegistry.register("durationCommand", GameRules.Category.MISC, GameRuleFactory.createIntRule(0));
    }
}
