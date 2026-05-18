package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.belt.flotador;
import net.elbin.comarcaclothes.client.model.belt.tojiworm;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBeltModel;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

import java.util.HashMap;
import java.util.Map;

public class CosmeticBeltRenderer implements ICurioRenderer {

    private record BeltCosmetic(EntityModel<LivingEntity> model, ResourceLocation texture) {}

    private final Map<Item, BeltCosmetic> cosmetics = new HashMap<>();

    public CosmeticBeltRenderer(EntityModelSet modelSet){
        register(ModClothes.Flotador.get(), new flotador<>(modelSet.bakeLayer(flotador.LAYER_LOCATION)), "flotador");
        register(ModClothes.Tojiworm.get(), new tojiworm<>(modelSet.bakeLayer(tojiworm.LAYER_LOCATION)), "tojiworm");

    }

    private void register(Item item, EntityModel<LivingEntity> model, String textureName) {
        ResourceLocation tex = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/" + textureName + ".png");
        cosmetics.put(item, new CosmeticBeltRenderer.BeltCosmetic(model, tex));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
            int light, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch) {

        CosmeticBeltRenderer.BeltCosmetic data = cosmetics.get(stack.getItem());
        if (data == null) return;

        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> playerModel)) return;

        matrixStack.pushPose();

        // 1. SINCRONIZACIÓN CON EL CUERPO
        if (data.model() instanceof IBeltModel beltModel) {
            beltModel.getBodyPart().copyFrom(playerModel.body);
        }

        // 3. RENDERIZADO
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(RenderType.entityCutoutNoCull(data.texture()));
        data.model().renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }


}
