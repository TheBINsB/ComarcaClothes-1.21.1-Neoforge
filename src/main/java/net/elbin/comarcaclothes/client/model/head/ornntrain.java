package net.elbin.comarcaclothes.client.model.head;// Made with Blockbench 5.1.4
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

public class ornntrain<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "ornntrain"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public ornntrain(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -7.1F, -7.2F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = armorHead.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 7).mirror().addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.9F, -6.6F, -0.7F, -0.1731F, 0.0227F, 0.1289F));

		PartDefinition cube_r2 = armorHead.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 17).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false)
				.texOffs(33, 17).addBox(16.1F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-8.4F, -7.0F, -0.7F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = armorHead.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false)
				.texOffs(33, 0).addBox(15.1F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.9F, -10.5F, 0.4F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r4 = armorHead.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(33, 12).mirror().addBox(-2.0F, -3.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.4F)).mirror(false)
				.texOffs(33, 12).addBox(15.1F, -3.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-7.9F, -10.8F, 0.4F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r5 = armorHead.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(33, 7).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.2F, -6.6F, -0.7F, -0.1731F, -0.0227F, -0.1289F));

		PartDefinition cube_r6 = armorHead.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(33, 24).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.5F, -8.6F, -4.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r7 = armorHead.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.4F))
				.texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -6.9F, -0.1F, -0.1745F, 0.0F, 0.0F));

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