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

    public static final DeferredItem<Item> Mahoraga_aro = ITEMS.register("mahoraga_aro",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Pto = ITEMS.register("pto",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Gorro1 = ITEMS.register("gorro1",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Choppa = ITEMS.register("choppa",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Axolotl = ITEMS.register("axolotl",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Ribbon = ITEMS.register("ribbon",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Turtle = ITEMS.register("turtle",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Swamp = ITEMS.register("swamp",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Librarian = ITEMS.register("librarian",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Cono = ITEMS.register("cono",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Scara = ITEMS.register("scara",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Teemohat = ITEMS.register("teemohat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Ornntrain = ITEMS.register("ornntrain",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Chefhat = ITEMS.register("chefhat",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Caja = ITEMS.register("caja",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Caja2 = ITEMS.register("caja2",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Caja3 = ITEMS.register("caja3",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Crimson = ITEMS.register("crimson",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Warped = ITEMS.register("warped",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Mushroom = ITEMS.register("mushroom",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //face

    public static final DeferredItem<Item> Cartographer = ITEMS.register("cartographer",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Cigarro = ITEMS.register("cigarro",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //back

    public static final DeferredItem<Item> Quiver = ITEMS.register("quiver",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Wings = ITEMS.register("wings",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Katana = ITEMS.register("katana",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Foxtail1 = ITEMS.register("foxtail1",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Foxtail9 = ITEMS.register("foxtail9",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Backchest = ITEMS.register("backchest",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Magecape1 = ITEMS.register("magecape1",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    //torso

    public static final DeferredItem<Item> Bluetoga = ITEMS.register("bluetoga",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Greenshirt = ITEMS.register("greenshirt",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Royalpads = ITEMS.register("royalpads",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Royal1 = ITEMS.register("royal1",
            ()-> new Item(new Item.Properties().stacksTo(1)));


    //belt

    public static final DeferredItem<Item> Flotador = ITEMS.register("flotador",
            ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> Tojiworm = ITEMS.register("tojiworm",
            ()-> new Item(new Item.Properties().stacksTo(1)));


    //legs

    //feet

    //hands

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
