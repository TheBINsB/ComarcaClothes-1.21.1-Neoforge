package net.elbin.comarcaclothes.client.model;// Made with Blockbench 5.1.4
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

public class ribbon<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "ribbon"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public ribbon(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(19, 16).addBox(-2.0F, -7.0F, 3.675F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, -2).addBox(-9.9836F, -10.0F, 1.4885F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(19, -1).mirror().addBox(9.9836F, -10.0F, 1.5385F, 0.0F, 9.0F, 6.95F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(1.9302F, -7.243F, 0.7995F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, -2.757F, 3.398F, 0.0F, -0.3927F, 0.0F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(1.9302F, -7.243F, 0.7995F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3F, -2.757F, 4.898F, 0.0F, 0.3927F, 0.0F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 10).addBox(-10.9302F, -7.243F, 0.7995F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -2.757F, 4.898F, 0.0F, -0.3927F, 0.0F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(0, 10).addBox(-10.9302F, -7.243F, 0.7995F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, -2.757F, 3.798F, 0.0F, 0.3927F, 0.0F));

		PartDefinition armorHead_r5 = armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-0.2639F, -0.8932F, -0.548F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.757F, 6.898F, 0.0F, 0.0F, -0.7854F));

		PartDefinition armorHead_r6 = armorHead.addOrReplaceChild("armorHead_r6", CubeListBuilder.create().texOffs(0, 20).addBox(-2.7361F, -0.8932F, -0.548F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.757F, 6.898F, 0.0F, 0.0F, 0.7854F));

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