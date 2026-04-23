package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.model.dragonskull;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class DragonSkullRenderer implements ICurioRenderer {

    private final dragonskull<LivingEntity> model;

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "textures/entity/dragon_skull.png");


    public DragonSkullRenderer(EntityModelSet modelSet) {
        this.model = new dragonskull<>(modelSet.bakeLayer(dragonskull.LAYER_LOCATION));
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

        this.model.setupAnim(slotContext.entity(),limbSwing, limbSwingAmount,ageInTicks,netHeadYaw,headPitch);

        matrixStack.pushPose();

        ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());
        ICurioRenderer.rotateIfSneaking(matrixStack, slotContext.entity());

        VertexConsumer vertexconsumer = renderTypeBuffer.getBuffer(RenderType.armorCutoutNoCull(TEXTURE));

        this.model.renderToBuffer(
                matrixStack,
                renderTypeBuffer.getBuffer(this.model.renderType(TEXTURE)),
                light,
                net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY,
                -1 // Color blanco por defecto (RGBA empaquetado)
        );

        matrixStack.popPose();

    }
}
