package net.elbin.comarcaclothes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        // Creamos la etiqueta "comarcaclothes:oculta_casco"
        public static final TagKey<Item> HIDE_HELMET = TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath("comarcaclothes", "oculta_casco")
        );

        public static final TagKey<Item> HIDE_CHESTPLATE = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "oculta_torso"));
    }
}
