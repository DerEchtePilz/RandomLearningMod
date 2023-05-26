package me.derechtepilz.randomlearningmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.derechtepilz.randomlearningmod.commands.arguments.MapArgument;
import me.derechtepilz.randomlearningmod.commands.arguments.MapArgumentType;
import me.derechtepilz.randomlearningmod.gamerules.TestGameRule;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.GameRules;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Environment(EnvType.CLIENT)
public class TestCommand {

	@SuppressWarnings("unchecked")
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
		dispatcher.register(CommandManager.literal("pilz")
			.executes((context) -> executeRandom(context, null))
			.then(CommandManager.argument("item", ItemStackArgumentType.itemStack(registryAccess))
				.executes((context) -> executeRandom(context, ItemStackArgumentType.getItemStackArgument(context, "item")))
			)
			.then(CommandManager.literal("register")
				.then(CommandManager.argument("name", StringArgumentType.word())
					.then(CommandManager.argument("map", new MapArgumentType<>(
							s -> s,
							ArgumentTypes::valueOf,
							List.of(),
							List.of(Arrays.stream(ArgumentTypes.values()).map(Enum::name).toArray(String[]::new)),
							false
						).multiplePairs())
						.executes((context) -> executeRegister(context, StringArgumentType.getString(context, "name"), (MapArgument<String, ArgumentTypes>) MapArgumentType.getMapArgument(context, "map")))
					)
				)
			)
		);
	}

	private static int executeRandom(CommandContext<ServerCommandSource> context, ItemStackArgument itemStackArgument) throws CommandSyntaxException {
		ServerCommandSource source = context.getSource();
		ServerPlayerEntity playerEntity = source.getPlayer();
		if (itemStackArgument != null) {
			ItemStack item = itemStackArgument.createStack(1, true);
			playerEntity.sendMessage(Text.of("You executed the command /test and provided the item: " + item.getName().getString()), false);
		} else {
			playerEntity.sendMessage(Text.of("You executed /test without arguments!"), false);
			ServerWorld world = source.getWorld();
			GameRules.Key<GameRules.BooleanRule> booleanRuleKey = TestGameRule.SHOULD_PIGS_FLY;
			playerEntity.sendMessage(Text.of("And for your information: The value of the game rule " + booleanRuleKey.getName() + " is " + source.getWorld().getGameRules().getBoolean(TestGameRule.SHOULD_PIGS_FLY)), false);
		}
		return 0;
	}

	private static int executeRegister(CommandContext<ServerCommandSource> context, String name, MapArgument<String, ArgumentTypes> mapArgument) throws CommandSyntaxException {
		LinkedHashMap<String, ArgumentTypes> arguments = mapArgument.getResults();
		ServerPlayerEntity player = context.getSource().getPlayer();
		player.sendMessage(Text.of(arguments.toString()));
		return 1;
	}
}
