package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.*;
import net.elbin.comarcaclothes.client.renderer.cosmetics.HeadCosmetic;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IHeadModel;
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


public class CosmeticHeadRenderer implements ICurioRenderer {

    private final Map<Item, HeadCosmetic> cosmetics = new HashMap<>();

    public CosmeticHeadRenderer(EntityModelSet modelSet) {
        register(ModClothes.Dragon_Skull.get(), new dragonskull(modelSet.bakeLayer(dragonskull.LAYER_LOCATION)), "dragon_skull");
        register(ModClothes.Christmas_Hat.get(), new christmas_hat(modelSet.bakeLayer(christmas_hat.LAYER_LOCATION)), "christmast_hat");
        register(ModClothes.CaptainHat.get(), new captainhat(modelSet.bakeLayer(captainhat.LAYER_LOCATION)), "captain_hat");
        register(ModClothes.CowboyHat.get(), new cowboyhat(modelSet.bakeLayer(cowboyhat.LAYER_LOCATION)), "cowboy_hat");
        register(ModClothes.Crown.get(), new crown(modelSet.bakeLayer(crown.LAYER_LOCATION)), "crown");
        register(ModClothes.Horns.get(), new horns(modelSet.bakeLayer(horns.LAYER_LOCATION)), "horns");
        register(ModClothes.Sombrero.get(), new sombrero(modelSet.bakeLayer(sombrero.LAYER_LOCATION)), "sombrero");
        register(ModClothes.Pickelhaube.get(), new pickelhaube(modelSet.bakeLayer(pickelhaube.LAYER_LOCATION)), "pickelhaube");
        register(ModClothes.Wizardhat.get(), new wizardhat(modelSet.bakeLayer(wizardhat.LAYER_LOCATION)), "wizard_hat");
        register(ModClothes.Piratehat.get(), new piratehat(modelSet.bakeLayer(piratehat.LAYER_LOCATION)), "pirate_hat");
        register(ModClothes.Tophat.get(), new tophat(modelSet.bakeLayer(tophat.LAYER_LOCATION)), "top_hat");
        register(ModClothes.Doubletophat.get(), new doubletophat(modelSet.bakeLayer(doubletophat.LAYER_LOCATION)), "top_hat");
        register(ModClothes.Kasahat.get(), new kasahat(modelSet.bakeLayer(kasahat.LAYER_LOCATION)), "kasahat");
        register(ModClothes.Pumpkinhat.get(), new pumpkinhat(modelSet.bakeLayer(pumpkinhat.LAYER_LOCATION)), "pumpkin_hat");
        register(ModClothes.Mahoraga_aro.get(), new mahoraga_aro(modelSet.bakeLayer(mahoraga_aro.LAYER_LOCATION)), "aro");
        register(ModClothes.Pto.get(), new pto(modelSet.bakeLayer(pto.LAYER_LOCATION)), "pto");
        register(ModClothes.Gorro1.get(), new gorro1(modelSet.bakeLayer(gorro1.LAYER_LOCATION)), "gorro1");
        register(ModClothes.Choppa.get(), new choppa(modelSet.bakeLayer(choppa.LAYER_LOCATION)), "choppa");
        register(ModClothes.Axolotl.get(), new axolotl(modelSet.bakeLayer(axolotl.LAYER_LOCATION)), "axolotl");
        register(ModClothes.Ribbon.get(), new ribbon(modelSet.bakeLayer(ribbon.LAYER_LOCATION)), "ribbon");
        register(ModClothes.Turtle.get(), new turtle(modelSet.bakeLayer(turtle.LAYER_LOCATION)), "turtle");
        register(ModClothes.Swamp.get(), new swamp(modelSet.bakeLayer(swamp.LAYER_LOCATION)), "swamp");
        register(ModClothes.Librarian.get(), new librarian(modelSet.bakeLayer(librarian.LAYER_LOCATION)), "librarian");
        register(ModClothes.Cartographer.get(), new cartographer(modelSet.bakeLayer(cartographer.LAYER_LOCATION)), "cartographer");
    }

    private void register(Item item, EntityModel<LivingEntity> model, String textureName) {
        ResourceLocation tex = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/" + textureName + ".png");
        cosmetics.put(item, new HeadCosmetic(model, tex));
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

        HeadCosmetic data = cosmetics.get(stack.getItem());

        if (data == null) return;

        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> playerModel)) return;


        // --- LÓGICA DE RENDERIZADO (IGUAL PARA TODOS) ---
        matrixStack.pushPose();

        // Esto hace que el modelo siga el movimiento de la cabeza del jugador
        //ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());
        if (data.model() instanceof IHeadModel modelWithHead) {
            modelWithHead.getHead().copyFrom(playerModel.head);
        }

        // Sincronizar animación
        //modelToUse.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        // Dibujar el modelo
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(RenderType.entityCutoutNoCull(data.texture()));
        data.model().renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
