package me.derechtepilz.randomlearningmod.items.logic;

import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
        return ActionResult.PASS;
    }
}
