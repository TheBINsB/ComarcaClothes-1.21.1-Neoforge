package net.elbin.comarcaclothes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.client.model.*;
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

public class CosmeticHeadRenderer implements ICurioRenderer {
    // Definimos los modelos que vamos a usar
    private final dragonskull dragonModel;
    private final christmas_hat christmashatmodel;
    private final captainhat captainhatmodel;
    private final cowboyhat cowboyhatmodel;
    private final crown crownmodel;
    private final horns hornsmodel;
    private final sombrero sombreromodel;
    private final pickelhaube pickelhaubemodel;
    private final wizardhat wizardhatmodel;
    private final piratehat piratehatmodel;
    private final tophat tophatmodel;
    private final doubletophat doubletophatmodel;
    private final kasahat kasahatmodel;
    private final pumpkinhat pumpkinhatmodel;
    private final mahoraga_aro mahoragaaromodel;
    private final pto ptomodel;
    private final gorro1 gorro1model;
    private final choppa choppamodel;
    private final axolotl axolotlmodel;
    private final ribbon ribbonmodel;

    public CosmeticHeadRenderer(EntityModelSet modelSet) {
        this.dragonModel = new dragonskull(modelSet.bakeLayer(dragonskull.LAYER_LOCATION));
        this.christmashatmodel = new christmas_hat(modelSet.bakeLayer(christmas_hat.LAYER_LOCATION));
        this.captainhatmodel = new captainhat(modelSet.bakeLayer(captainhat.LAYER_LOCATION));
        this.cowboyhatmodel = new cowboyhat(modelSet.bakeLayer(cowboyhat.LAYER_LOCATION));
        this.crownmodel = new crown(modelSet.bakeLayer(crown.LAYER_LOCATION));
        this.hornsmodel = new horns(modelSet.bakeLayer(horns.LAYER_LOCATION));
        this.sombreromodel = new sombrero(modelSet.bakeLayer(sombrero.LAYER_LOCATION));
        this.pickelhaubemodel = new pickelhaube(modelSet.bakeLayer(pickelhaube.LAYER_LOCATION));
        this.wizardhatmodel = new wizardhat(modelSet.bakeLayer(wizardhat.LAYER_LOCATION));
        this.piratehatmodel = new piratehat(modelSet.bakeLayer(piratehat.LAYER_LOCATION));
        this.tophatmodel = new tophat(modelSet.bakeLayer(tophat.LAYER_LOCATION));
        this.doubletophatmodel = new doubletophat(modelSet.bakeLayer(doubletophat.LAYER_LOCATION));
        this.kasahatmodel = new kasahat(modelSet.bakeLayer(kasahat.LAYER_LOCATION));
        this.pumpkinhatmodel = new pumpkinhat(modelSet.bakeLayer(pumpkinhat.LAYER_LOCATION));
        this.mahoragaaromodel = new mahoraga_aro(modelSet.bakeLayer(mahoraga_aro.LAYER_LOCATION));
        this.ptomodel = new pto(modelSet.bakeLayer(pto.LAYER_LOCATION));
        this.gorro1model = new gorro1(modelSet.bakeLayer(gorro1.LAYER_LOCATION));
        this.choppamodel = new choppa(modelSet.bakeLayer(choppa.LAYER_LOCATION));
        this.axolotlmodel = new axolotl(modelSet.bakeLayer(axolotl.LAYER_LOCATION));
        this.ribbonmodel = new ribbon(modelSet.bakeLayer(ribbon.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack, SlotContext slotContext, PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
            int light, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch) {

        // 1. SELECTOR DINÁMICO
        EntityModel<LivingEntity> modelToUse;
        ResourceLocation textureToUse;

        if (stack.is(ModClothes.Dragon_Skull.get())) {
            modelToUse = (EntityModel) dragonModel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/dragon_skull.png");
        }
        else if (stack.is(ModClothes.Christmas_Hat.get())) {
            modelToUse = (EntityModel) christmashatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/christmas_hat.png");
        }
        else if (stack.is(ModClothes.CaptainHat.get())) {
            modelToUse = (EntityModel) captainhatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/captain_hat.png");
        }
        else if (stack.is(ModClothes.CowboyHat.get())) {
            modelToUse = (EntityModel) cowboyhatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/cowboy_hat.png");
        }
        else if (stack.is(ModClothes.Crown.get())) {
            modelToUse = (EntityModel) crownmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/crown.png");
        }
        else if (stack.is(ModClothes.Horns.get())) {
            modelToUse = (EntityModel) hornsmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/horns.png");
        }
        else if (stack.is(ModClothes.Sombrero.get())) {
            modelToUse = (EntityModel) sombreromodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/sombrero.png");
        }
        else if (stack.is(ModClothes.Pickelhaube.get())) {
            modelToUse = (EntityModel) pickelhaubemodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/pickelhaube.png");
        }
        else if (stack.is(ModClothes.Wizardhat.get())) {
            modelToUse = (EntityModel) wizardhatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/wizard_hat.png");
        }
        else if (stack.is(ModClothes.Piratehat.get())) {
            modelToUse = (EntityModel) piratehatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/pirate_hat.png");
        }
        else if (stack.is(ModClothes.Tophat.get())) {
            modelToUse = (EntityModel) tophatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/top_hat.png");
        }
        else if (stack.is(ModClothes.Doubletophat.get())) {
            modelToUse = (EntityModel) doubletophatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/top_hat.png");
        }
        else if (stack.is(ModClothes.Kasahat.get())) {
            modelToUse = (EntityModel) kasahatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/kasahat.png");
        }
        else if (stack.is(ModClothes.Pumpkinhat.get())) {
            modelToUse = (EntityModel) pumpkinhatmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/pumpkin_hat.png");
        }
        else if (stack.is(ModClothes.Mahoraga_aro.get())) {
            modelToUse = (EntityModel) mahoragaaromodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/aro.png");
        }
        else if (stack.is(ModClothes.Pto.get())) {
            modelToUse = (EntityModel) ptomodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/pto.png");
        }
        else if (stack.is(ModClothes.Gorro1.get())) {
            modelToUse = (EntityModel) gorro1model;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/gorro1.png");
        }
        else if (stack.is(ModClothes.Choppa.get())) {
            modelToUse = (EntityModel) choppamodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/choppa.png");
        }
        else if (stack.is(ModClothes.Axolotl.get())) {
            modelToUse = (EntityModel) axolotlmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/axolotl.png");
        }
        else if (stack.is(ModClothes.Ribbon.get())) {
            modelToUse = (EntityModel) ribbonmodel;
            textureToUse = ResourceLocation.fromNamespaceAndPath("comarcaclothes", "textures/entity/ribbon.png");
        }
        else {
            return;
        }


        // --- LÓGICA DE RENDERIZADO (IGUAL PARA TODOS) ---
        matrixStack.pushPose();

        // Esto hace que el modelo siga el movimiento de la cabeza del jugador
        ICurioRenderer.translateIfSneaking(matrixStack, slotContext.entity());

        // Sincronizar animación
        modelToUse.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        // Dibujar el modelo
        VertexConsumer vertexConsumer = renderTypeBuffer.getBuffer(modelToUse.renderType(textureToUse));

        // CORRECCIÓN AQUÍ: Se añade el parámetro de color (0xFFFFFFFF es blanco total/sin tinte)
        modelToUse.renderToBuffer(matrixStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);

        matrixStack.popPose();
    }
}
