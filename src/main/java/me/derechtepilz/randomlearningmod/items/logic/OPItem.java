package me.derechtepilz.randomlearningmod.items.logic;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class OPItem extends Item {
    public OPItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack itemStack) {
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        BlockPos blockPos = context.getBlockPos();
        world.breakBlock(blockPos, true, player);
        ItemStack stack = context.getStack();
        if (player == null) {
            return ActionResult.FAIL;
        }
        MinecraftServer server = world.getServer();
        if (server == null) {
            return ActionResult.FAIL;
        }
        ServerWorld serverWorld = server.getWorld(world.getRegistryKey());
        if (serverWorld == null) {
            return ActionResult.FAIL;
        }
        ServerPlayerEntity serverPlayer = new ServerPlayerEntity(server, serverWorld, player.getGameProfile());
        stack.damage(1, new Random(), serverPlayer);
        return ActionResult.PASS;
    }
}
