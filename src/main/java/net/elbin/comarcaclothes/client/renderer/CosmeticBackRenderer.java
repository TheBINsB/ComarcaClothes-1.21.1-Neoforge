package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.katana;
import net.elbin.comarcaclothes.client.model.quiver;
import net.elbin.comarcaclothes.client.model.wings;
import net.elbin.comarcaclothes.clothes.ModClothes;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CosmeticBackRenderer implements ICurioRenderer {
    private final quiver quiverModel;
    private final wings wingsModel;
    private final katana katanamodel;

    public CosmeticBackRenderer(EntityModelSet modelSet) {
        this.quiverModel = new quiver(modelSet.bakeLayer(quiver.LAYER_LOCATION));
        this.wingsModel = new wings(modelSet.bakeLayer(wings.LAYER_LOCATION));
        this.katanamodel = new katana(modelSet.bakeLayer(katana.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
            int light, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch) {

        EntityModel<LivingEntity> modelToUse;
        ResourceLocation textureToUse;

        // Selector de ítems de espalda
        if (stack.is(ModClothes.Quiver.get())) {
            modelToUse = (EntityModel) quiverModel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/arrow_quiver.png");
        }
        else if (stack.is(ModClothes.Wings.get())) {
            modelToUse = (EntityModel) wingsModel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/wings.png");
        }
        else if (stack.is(ModClothes.Katana.get())) {
            modelToUse = (EntityModel) katanamodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/katana.png");
        }
        else {
            return;
        }

        matrixStack.pushPose();

        // Ajuste manual por si el modelo aparece dentro del cuerpo (ajustar según Blockbench)
        matrixStack.translate(0, 0, 0.08);

        ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());
        ICurioRenderer.rotateIfSneaking(matrixStack, slotContext.entity());

        modelToUse.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(modelToUse.renderType(textureToUse));
        modelToUse.renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
