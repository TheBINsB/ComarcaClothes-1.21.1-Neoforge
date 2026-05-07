package net.elbin.comarcaclothes.client.renderer.cosmetics;

import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public record HeadCosmetic(EntityModel<LivingEntity> model, ResourceLocation texture) {
}
