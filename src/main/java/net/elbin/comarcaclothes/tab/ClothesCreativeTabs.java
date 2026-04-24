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
                      output.accept(ModClothes.Dragon_Skull);
                      output.accept(ModClothes.Christmas_Hat);
                      output.accept(ModClothes.CaptainHat);
                      output.accept(ModClothes.CowboyHat);
                      output.accept(ModClothes.Crown);
                      output.accept(ModClothes.Quiver);
                      output.accept(ModClothes.Wings);
                      output.accept(ModClothes.Horns);
                      output.accept(ModClothes.Sombrero);
                      output.accept(ModClothes.Pickelhaube);
                      output.accept(ModClothes.Wizardhat);

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
