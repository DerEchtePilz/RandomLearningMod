package me.derechtepilz.randomlearningmod.items;

import me.derechtepilz.randomlearningmod.client.RandomLearningModClient;
import me.derechtepilz.randomlearningmod.items.logic.OPItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class TestItems {

    private static final Item OP_ITEM = new OPItem(new FabricItemSettings().fireproof().rarity(Rarity.EPIC).maxCount(1).group(ItemGroup.MISC));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(RandomLearningModClient.MOD_ID, "op_item"), OP_ITEM);
    }

    public static Item getOpItem() {
        return OP_ITEM;
    }
}
