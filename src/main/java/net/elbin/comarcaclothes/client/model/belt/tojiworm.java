package net.elbin.comarcaclothes.client.model.belt;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBeltModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class tojiworm<T extends LivingEntity> extends EntityModel<T> implements IBeltModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "tojiworm"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public tojiworm(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(23, 28).addBox(-6.3F, 9.2F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.5F))
				.texOffs(0, 28).addBox(4.0F, 6.0F, -5.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = armorBody.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 23).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.4F))
				.texOffs(31, 7).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(5.4F, -1.3F, 0.6F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = armorBody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(49, 32).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, -1.0F, 0.2F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r3 = armorBody.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -3.0F, -1.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.6F, 4.5F, -0.0225F, 0.2521F, -0.0901F));

		PartDefinition cube_r4 = armorBody.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, 2.5F, -3.3F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r5 = armorBody.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(27, 0).addBox(-9.0F, -3.0F, -2.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.8F, -3.1F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r6 = armorBody.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -3.0F, -1.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3F, 11.0F, 3.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r7 = armorBody.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(29, 21).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 12.0F, -3.2F, 0.0F, 0.0F, 0.2182F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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