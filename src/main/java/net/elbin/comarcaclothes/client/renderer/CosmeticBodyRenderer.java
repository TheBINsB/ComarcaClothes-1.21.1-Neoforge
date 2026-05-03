package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.bodydef;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CosmeticBodyRenderer implements ICurioRenderer {
    private final bodydef<LivingEntity> bodyModel;

    public CosmeticBodyRenderer(EntityModelSet modelSet) {
        this.bodyModel = new bodydef<>(modelSet.bakeLayer(bodydef.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource renderTypeBuffer,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {

        // 1. Obtener el modelo del jugador (o entidad que lo use)
        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> playerModel)) {
            return;
        }

        LivingEntity entity = slotContext.entity();
        ResourceLocation texture;
        if (stack.is(ModClothes.Bluetoga.get())) {
            texture = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/blue_toga.png");
        }
        else if (stack.is(ModClothes.Greenshirt.get())) {
            texture = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/greenshirt.png");
        }
        else {
            return;
        }

        matrixStack.pushPose();

        // 2. SINCRONIZACIÓN MANUAL (Sustituye a followBodyRotations)
        // Copiamos las rotaciones del cuerpo y brazos del jugador a nuestro modelo bodydef
        this.bodyModel.bipedBody.copyFrom(playerModel.body);
        this.bodyModel.bipedLeftArm.copyFrom(playerModel.leftArm);
        this.bodyModel.bipedRightArm.copyFrom(playerModel.rightArm);


        // 4. Renderizado
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(RenderType.entityCutoutNoCull(texture));
        this.bodyModel.renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
