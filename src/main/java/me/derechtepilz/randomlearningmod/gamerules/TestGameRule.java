package me.derechtepilz.randomlearningmod.gamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class TestGameRule {

    private static GameRules.Key<GameRules.BooleanRule> SHOULD_PIGS_FLY;
    private static GameRules.Key<GameRules.IntRule> DURATION_COMMAND;

    public static void registerRules() {
        SHOULD_PIGS_FLY = GameRuleRegistry.register("shouldPigsFly", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
        DURATION_COMMAND = GameRuleRegistry.register("durationCommand", GameRules.Category.MISC, GameRuleFactory.createIntRule(0));
    }

    public static GameRules.Key<GameRules.BooleanRule> getShouldPigsFly() {
        return SHOULD_PIGS_FLY;
    }

    public static GameRules.Key<GameRules.IntRule> getDurationCommand() {
        return DURATION_COMMAND;
    }
}
