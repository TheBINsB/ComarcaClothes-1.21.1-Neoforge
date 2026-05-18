package net.elbin.comarcaclothes.tab;

import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ClothesCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ComarcaClothes.MOD_ID);

    public static final Supplier<CreativeModeTab> COMARCA_CLOTHES = CREATIVE_MODE_TAB.register("comarca_clothes_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModClothes.Dragon_Skull.get()))
                    .title(Component.translatable("creativetab.comarcaclothes.clothes"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Head
                      output.accept(ModClothes.Dragon_Skull);
                      output.accept(ModClothes.Christmas_Hat);
                      output.accept(ModClothes.CaptainHat);
                      output.accept(ModClothes.CowboyHat);
                      output.accept(ModClothes.Crown);
                      output.accept(ModClothes.Horns);
                      output.accept(ModClothes.Sombrero);
                      output.accept(ModClothes.Pickelhaube);
                      output.accept(ModClothes.Wizardhat);
                      output.accept(ModClothes.Piratehat);
                      output.accept(ModClothes.Tophat);
                      output.accept(ModClothes.Doubletophat);
                      output.accept(ModClothes.Kasahat);
                      output.accept(ModClothes.Pumpkinhat);
                      output.accept(ModClothes.Mahoraga_aro);
                      output.accept(ModClothes.Pto);
                      output.accept(ModClothes.Gorro1);
                      output.accept(ModClothes.Choppa);
                      output.accept(ModClothes.Axolotl);
                      output.accept(ModClothes.Ribbon);
                      output.accept(ModClothes.Turtle);
                      output.accept(ModClothes.Swamp);
                      output.accept(ModClothes.Librarian);
                      output.accept(ModClothes.Cono);
                      output.accept(ModClothes.Scara);
                      output.accept(ModClothes.Teemohat);
                      output.accept(ModClothes.Ornntrain);
                      output.accept(ModClothes.Chefhat);
                      output.accept(ModClothes.Caja);
                      output.accept(ModClothes.Caja2);
                      output.accept(ModClothes.Caja3);
                      output.accept(ModClothes.Crimson);
                      output.accept(ModClothes.Warped);
                      output.accept(ModClothes.Mushroom);

                      //back
                      output.accept(ModClothes.Quiver);
                      output.accept(ModClothes.Wings);
                      output.accept(ModClothes.Katana);
                      output.accept(ModClothes.Foxtail1);
                      output.accept(ModClothes.Foxtail9);
                      output.accept(ModClothes.Backchest);
                      output.accept(ModClothes.Magecape1);

                      //body
                      output.accept(ModClothes.Bluetoga);
                      output.accept(ModClothes.Greenshirt);
                      output.accept(ModClothes.Royalpads);
                      output.accept(ModClothes.Royal1);

                      //face
                      output.accept(ModClothes.Cartographer);
                      output.accept(ModClothes.Cigarro);

                      //belt
                      output.accept(ModClothes.Flotador);
                      output.accept(ModClothes.Tojiworm);

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
