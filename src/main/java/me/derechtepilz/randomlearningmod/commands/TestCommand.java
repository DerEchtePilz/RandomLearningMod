package me.derechtepilz.randomlearningmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.GameRules;

@Environment(EnvType.CLIENT)
public class TestCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("pilz")
                .executes((context) -> execute(context, null))
                .then(CommandManager.argument("item", ItemStackArgumentType.itemStack())
                        .executes((context) -> execute(context, ItemStackArgumentType.getItemStackArgument(context, "item")))));
    }

    private static int execute(CommandContext<ServerCommandSource> context, ItemStackArgument itemStackArgument) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        ServerPlayerEntity playerEntity = source.getPlayer();
        if (itemStackArgument != null) {
            ItemStack item = itemStackArgument.createStack(1, true);
            playerEntity.sendMessage(Text.of("You executed the command /test and provided the item: " + item.getName().getString()), false);
        } else {
            playerEntity.sendMessage(Text.of("You executed /test without arguments!"), false);
            ServerWorld world = source.getWorld();
            GameRules.Key<GameRules.BooleanRule> booleanRuleKey = TestGameRule.getShouldPigsFly();
            playerEntity.sendMessage(Text.of("And for your information: The value of the game rule " + booleanRuleKey.getName() + " is " + source.getWorld().getGameRules().getBoolean(TestGameRule.getShouldPigsFly())), false);
        }
        return 0;
    }
}
