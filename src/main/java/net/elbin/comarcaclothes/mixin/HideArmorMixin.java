package net.elbin.comarcaclothes.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elbin.comarcaclothes.ModTags;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(HumanoidArmorLayer.class)
public abstract class HideArmorMixin {

    @Inject(
            method = "renderArmorPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;ILnet/minecraft/client/model/HumanoidModel;FFFFFF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void comarcaclothes$renderArmorPiece(
            PoseStack poseStack, MultiBufferSource buffer, LivingEntity entity,
            EquipmentSlot armorSlot, int light, HumanoidModel<LivingEntity> model,
            float limbSwing, float limbSwingAmount, float partialTick,
            float ageInTicks, float netHeadYaw, float headPitch,
            CallbackInfo ci) {

        if (entity instanceof Player && armorSlot == EquipmentSlot.HEAD) {

            // BUSCAMOS SI CUALQUIER ÍTEM EQUIPADO EN CURIOS TIENE EL TAG
            boolean hasCosmetic = CuriosApi.getCuriosInventory(entity)
                    .map(inv -> inv.findFirstCurio(stack -> stack.is(ModTags.Items.HIDE_HELMET)).isPresent())
                    .orElse(false);

            if (hasCosmetic) {
                ci.cancel();
            }
        }

        // --- LÓGICA PARA EL TORSO (PECHERA) ---
        if (armorSlot == EquipmentSlot.CHEST) {
            // Buscamos en Curios si el jugador tiene equipada la Blue Toga u otro ítem que oculte el torso
            boolean hasChestCosmetic = CuriosApi.getCuriosInventory(entity)
                    .map(inv -> inv.findFirstCurio(stack -> stack.is(ModTags.Items.HIDE_CHESTPLATE)).isPresent())
                    .orElse(false);

            if (hasChestCosmetic) {
                ci.cancel();
                return;
            }
        }
    }
}