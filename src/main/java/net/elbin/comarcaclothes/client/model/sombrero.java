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

public class sombrero<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "sombrero"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public sombrero(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -10.0F, -13.75F, 0.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-13.0F, -10.0F, 12.25F, 26.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(13.0F, -10.0F, -13.75F, 0.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(-13.0F, -10.0F, -13.75F, 26.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(-26, 0).addBox(-13.0F, -7.0F, -13.75F, 26.0F, 0.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(-4.5F, -12.0F, -5.25F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

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