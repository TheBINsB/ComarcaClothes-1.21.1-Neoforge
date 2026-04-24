package net.elbin.comarcaclothes.client.model;

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

public class pickelhaube<T extends LivingEntity> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "pickelhaube"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public pickelhaube(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(6, 13).addBox(-4.0F, -7.825F, 0.75F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, -3.75F, 0.48F, 0.0F, 0.0F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -7.0F, -1.0F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.01F))
				.texOffs(27, 4).addBox(-2.0F, -15.5F, -0.5F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(27, -1).addBox(0.5F, -15.5F, -3.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(27, 0).addBox(-1.0F, -12.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.01F))
				.texOffs(0, 0).addBox(-4.0F, -11.0F, -5.0F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 0.25F, -0.0436F, 0.0F, 0.0F));

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
}