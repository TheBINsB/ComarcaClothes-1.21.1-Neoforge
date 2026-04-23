package net.elbin.comarcaclothes.clothes;

import net.elbin.comarcaclothes.ComarcaClothes;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModClothes {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ComarcaClothes.MOD_ID);

    public static final DeferredItem<Item> Dragon_Skull = ITEMS.register("dragonskull",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
