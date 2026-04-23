package net.elbin.comarcaclothes.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(HumanoidArmorLayer.class)
public class HideArmorMixin {

    @Inject(method = "renderArmorPiece", at = @At("HEAD"), cancellable = true)
    private void comarcaclothes$hideHelmet(
            PoseStack poseStack, MultiBufferSource buffer, LivingEntity livingEntity,
            EquipmentSlot slot, int packedLight, HumanoidModel<?> model, CallbackInfo ci) {

        if (slot == EquipmentSlot.HEAD) {
            // USANDO LA API MODERNA:
            // CuriosApi.getCuriosInventory(entity) es la forma recomendada ahora
            boolean hasDragonSkull = CuriosApi.getCuriosInventory(livingEntity)
                    .map(inv -> inv.findFirstCurio(ModClothes.Dragon_Skull.get()).isPresent())
                    .orElse(false);

            if (hasDragonSkull) {
                ci.cancel();
            }
        }
    }
}