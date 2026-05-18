package net.elbin.comarcaclothes.client.model.back;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBackModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class foxtail1<T extends LivingEntity> extends EntityModel<T> implements IBackModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "foxtail1"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public foxtail1(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody_r1 = armorBody.addOrReplaceChild("armorBody_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
		.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.1F, 12.7F, 7.7F, -0.2182F, 0.0F, 0.0F));

		PartDefinition armorBody_r2 = armorBody.addOrReplaceChild("armorBody_r2", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7F, 12.5F, 2.9F, 0.1309F, 0.0F, 0.0F));

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