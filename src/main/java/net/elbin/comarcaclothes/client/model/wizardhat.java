package net.elbin.comarcaclothes.client.model;

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

public class wizardhat<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "wizardhat"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public wizardhat(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-1.656F, -38.1503F, -22.7963F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, 24.75F, -7.25F, -0.829F, 0.0F, -0.0873F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 39).addBox(-2.656F, -39.9819F, -12.2037F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, 24.75F, -7.25F, -0.5236F, 0.0F, -0.0873F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 30).addBox(-3.656F, -36.4403F, -8.1818F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 23.25F, -6.75F, -0.3927F, 0.0F, -0.0873F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(0, 18).addBox(-5.156F, -34.2584F, -6.7532F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 23.25F, -6.75F, -0.3054F, 0.0F, -0.0873F));

		PartDefinition armorHead_r5 = armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(0, 40).addBox(-11.656F, -31.8153F, -10.5474F, 22.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 23.25F, -6.75F, -0.2182F, 0.0F, -0.0873F));

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