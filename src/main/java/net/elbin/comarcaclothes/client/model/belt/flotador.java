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

public class flotador<T extends LivingEntity> extends EntityModel<T> implements IBeltModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "flotador"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public flotador(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -4.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition armorBody_r1 = armorBody.addOrReplaceChild("armorBody_r1", CubeListBuilder.create().texOffs(9, 17).addBox(-1.0F, -4.6F, -4.7F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F))
				.texOffs(9, 11).addBox(-1.0F, -6.6F, -4.7F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.6F, 0.2618F, 0.0F, 0.0F));

		PartDefinition armorBody_r2 = armorBody.addOrReplaceChild("armorBody_r2", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -6.5F, -1.1F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.6F, 0.2618F, 0.0F, 0.0F));

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