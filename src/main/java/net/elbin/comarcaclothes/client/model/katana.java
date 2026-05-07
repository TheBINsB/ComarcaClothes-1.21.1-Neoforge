package net.elbin.comarcaclothes.client.model;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBackModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class katana<T extends LivingEntity> extends EntityModel<T> implements IBackModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "katana"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public katana(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody_r1 = armorBody.addOrReplaceChild("armorBody_r1", CubeListBuilder.create().texOffs(6, 7).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.75F, 4.5F, 0.2664F, -0.2595F, -0.035F));

		PartDefinition armorBody_r2 = armorBody.addOrReplaceChild("armorBody_r2", CubeListBuilder.create().texOffs(9, 0).addBox(-2.0F, -3.25F, -1.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.25F, -0.5F, 2.0F, 22.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(-1.0F, -9.25F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.25F, 2.5F, 0.0F, 0.0F, -0.6545F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Para la espalda, normalmente no rotamos el bipedBody aquí manualmente
		// porque ICurioRenderer.followBody ya se encarga de que el modelo
		// siga las rotaciones del torso del jugador (incluyendo cuando se agacha).
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart getBodyPart() {
		return this.bipedBody;
	}

	public ModelPart getRoot() {
		return this.root;
	}
}