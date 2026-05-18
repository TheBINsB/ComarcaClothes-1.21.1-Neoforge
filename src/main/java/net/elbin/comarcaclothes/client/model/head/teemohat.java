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

public class teemohat<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "teemohat"), "main");


	private final ModelPart root;
	private final ModelPart bipedHead;

	public teemohat(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(-0.1125F, -9.0F, -0.9489F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-5.0F, -5.0F, -1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9875F, 0.5357F, 2.6489F, -0.2174F, -0.0189F, -0.0852F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(40, 13).addBox(0.0F, -5.0F, -1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3125F, 0.5357F, 2.6489F, -0.2174F, 0.0189F, 0.0852F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.1125F, 1.7357F, 1.5489F, -0.2182F, 0.0F, 0.0F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(32, 17).mirror().addBox(-4.0F, -4.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).mirror(false)
		.texOffs(32, 17).addBox(0.8F, -4.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.7125F, 2.6357F, -1.6511F, -0.3054F, 0.0F, 0.0F));

		PartDefinition armorHead_r5 = armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1125F, 2.7357F, 1.4489F, -0.2182F, 0.0F, 0.0F));

		PartDefinition armorHead_r6 = armorHead.addOrReplaceChild("armorHead_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1125F, 3.7357F, 1.4489F, -0.2182F, 0.0F, 0.0F));

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