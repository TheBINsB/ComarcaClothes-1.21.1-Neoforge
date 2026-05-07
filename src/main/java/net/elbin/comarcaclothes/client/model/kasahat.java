package net.elbin.comarcaclothes.client.model;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IHeadModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class kasahat<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "kasahat"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public kasahat(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(-12, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.25F, -0.5F, 1.1345F, -1.5272F, -1.5708F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(-12, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.25F, -0.5F, 2.6616F, 0.0F, -3.1416F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(-12, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.25F, -0.5F, 1.1345F, 1.5272F, 1.5708F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(-12, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.25F, -0.5F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bipedHead.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.bipedHead.xRot = headPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	public ModelPart getRoot() {
		return this.root;
	}
	public ModelPart getHead() {
		return this.bipedHead;
	}
}