package net.elbin.comarcaclothes.client.model;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class mahoraga_aro<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID,  "mahoraga_aro"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public mahoraga_aro(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(15, 32).addBox(-2.0F, -13.0F, -2.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 33).addBox(-1.7F, -12.0F, 9.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 33).addBox(-1.7F, -12.0F, -12.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(17, 33).addBox(-12.0F, -12.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 33).addBox(9.0F, -12.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-0.7F, -11.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(-5.0F, -12.0F, -5.0F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(1, 37).addBox(-5.0F, -12.0F, 4.0F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 27).addBox(4.0F, -12.0F, -4.0F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(36, 37).addBox(-4.0F, -12.0F, -5.0F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, -11.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -11.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(16, 33).addBox(-2.0F, -1.0F, 11.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -11.0F, -1.2F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armorHead_r5 = armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(16, 33).addBox(11.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.0F, 1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armorHead_r6 = armorHead.addOrReplaceChild("armorHead_r6", CubeListBuilder.create().texOffs(16, 33).addBox(-2.0F, -1.0F, -14.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -11.0F, 1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armorHead_r7 = armorHead.addOrReplaceChild("armorHead_r7", CubeListBuilder.create().texOffs(17, 33).addBox(-14.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, -11.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Sincronización con la cabeza del jugador
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