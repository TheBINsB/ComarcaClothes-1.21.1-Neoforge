package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.katana;
import net.elbin.comarcaclothes.client.model.quiver;
import net.elbin.comarcaclothes.client.model.wings;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBackModel;
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

public class CosmeticBackRenderer implements ICurioRenderer {

    private record BackCosmetic(EntityModel<LivingEntity> model, ResourceLocation texture) {}

    private final Map<Item, BackCosmetic> cosmetics = new HashMap<>();

    public CosmeticBackRenderer(EntityModelSet modelSet) {
        // Registro de los modelos de espalda
        register(ModClothes.Quiver.get(), new quiver(modelSet.bakeLayer(quiver.LAYER_LOCATION)), "arrow_quiver");
        register(ModClothes.Wings.get(), new wings(modelSet.bakeLayer(wings.LAYER_LOCATION)), "wings");
        register(ModClothes.Katana.get(), new katana(modelSet.bakeLayer(katana.LAYER_LOCATION)), "katana");
    }

    private void register(Item item, EntityModel<LivingEntity> model, String textureName) {
        ResourceLocation tex = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/" + textureName + ".png");
        cosmetics.put(item, new BackCosmetic(model, tex));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
            int light, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch) {

        BackCosmetic data = cosmetics.get(stack.getItem());
        if (data == null) return;

        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> playerModel)) return;

        matrixStack.pushPose();

        // 1. SINCRONIZACIÓN CON EL CUERPO
        if (data.model() instanceof IBackModel backModel) {
            backModel.getBodyPart().copyFrom(playerModel.body);
        }

        // 2. AJUSTE DE PROFUNDIDAD
        // Ese 0.08 que tenías es vital para que no haya Z-Fighting con la espalda
        matrixStack.translate(0, 0, 0.08);

        // 3. RENDERIZADO
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(RenderType.entityCutoutNoCull(data.texture()));
        data.model().renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
