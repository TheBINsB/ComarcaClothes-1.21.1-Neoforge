package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.bodydef;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBodyModel;
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

public class CosmeticBodyRenderer implements ICurioRenderer {

    // El contenedor de datos para el cuerpo
    private record BodyCosmetic(EntityModel<LivingEntity> model, ResourceLocation texture) {}

    private final Map<Item, BodyCosmetic> cosmetics = new HashMap<>();

    public CosmeticBodyRenderer(EntityModelSet modelSet) {
        // Registro del bodydef actual con sus dos texturas
        register(ModClothes.Bluetoga.get(), new bodydef<>(modelSet.bakeLayer(bodydef.LAYER_LOCATION)), "blue_toga");
        register(ModClothes.Greenshirt.get(), new bodydef<>(modelSet.bakeLayer(bodydef.LAYER_LOCATION)), "greenshirt");

        // EJEMPLO: Si mañana creas un modelo llamado "mochila.java"
        // register(ModClothes.Backpack.get(), new mochila<>(modelSet.bakeLayer(mochila.LAYER_LOCATION)), "backpack_texture");
    }

    private void register(Item item, EntityModel<LivingEntity> model, String textureName) {
        ResourceLocation tex = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/" + textureName + ".png");
        cosmetics.put(item, new BodyCosmetic(model, tex));
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

        BodyCosmetic data = cosmetics.get(stack.getItem());
        if (data == null) return;

        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> playerModel)) return;

        matrixStack.pushPose();

        // --- SINCRONIZACIÓN TRIPLE ---
        // Aquí es donde ocurre la magia para el cuerpo
        if (data.model() instanceof IBodyModel bodyParts) {
            bodyParts.getBody().copyFrom(playerModel.body);
            bodyParts.getLeftArm().copyFrom(playerModel.leftArm);
            bodyParts.getRightArm().copyFrom(playerModel.rightArm);
        }

        // Ajustes de agachado de Curios (opcional si el copyFrom ya lo hace bien)
        ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());
        ICurioRenderer.rotateIfSneaking(matrixStack, slotContext.entity());

        // Renderizado
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(RenderType.entityCutoutNoCull(data.texture()));
        data.model().renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
