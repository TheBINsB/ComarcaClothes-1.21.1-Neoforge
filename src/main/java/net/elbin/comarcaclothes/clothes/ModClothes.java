package net.elbin.comarcaclothes.clothes;

import net.elbin.comarcaclothes.ComarcaClothes;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModClothes {

    //head
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ComarcaClothes.MOD_ID);

    public static final DeferredItem<Item> Dragon_Skull = ITEMS.register("dragonskull",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Christmas_Hat = ITEMS.register("christmas_hat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CaptainHat = ITEMS.register("captainhat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CowboyHat = ITEMS.register("cowboyhat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Crown = ITEMS.register("crown",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Horns = ITEMS.register("horns",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Sombrero = ITEMS.register("sombrero",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Pickelhaube = ITEMS.register("pickelhaube",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Wizardhat = ITEMS.register("wizardhat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Piratehat = ITEMS.register("piratehat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Tophat = ITEMS.register("tophat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Doubletophat = ITEMS.register("doubletophat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Kasahat = ITEMS.register("kasahat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Pumpkinhat = ITEMS.register("pumpkinhat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //back

    public static final DeferredItem<Item> Quiver = ITEMS.register("quiver",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Wings = ITEMS.register("wings",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Katana = ITEMS.register("katana",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //torso

    public static final DeferredItem<Item> Bluetoga = ITEMS.register("bluetoga",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //legs

    //feet

    //hands

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
