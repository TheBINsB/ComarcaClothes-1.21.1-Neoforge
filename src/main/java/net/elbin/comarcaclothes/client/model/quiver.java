package net.elbin.comarcaclothes.client.model;

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

public class quiver<T extends LivingEntity> extends EntityModel<T> implements IBackModel {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "quiver"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public quiver(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody_r1 = armorBody.addOrReplaceChild("armorBody_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-5.0F, -4.25F, 6.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(16, -3).addBox(-3.5F, -4.25F, 4.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, 0.072F, 0.6032F, -0.5652F));

		PartDefinition armorBody_r2 = armorBody.addOrReplaceChild("armorBody_r2", CubeListBuilder.create().texOffs(16, -3).addBox(6.25F, -7.5F, 5.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(4.75F, -7.5F, 6.5F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, -0.5256F, -0.9001F, -0.3049F));

		PartDefinition armorBody_r3 = armorBody.addOrReplaceChild("armorBody_r3", CubeListBuilder.create().texOffs(16, -3).addBox(3.5F, -5.5F, 5.75F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(2.0F, -5.5F, 7.25F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, -0.1732F, -0.5508F, -0.702F));

		PartDefinition armorBody_r4 = armorBody.addOrReplaceChild("armorBody_r4", CubeListBuilder.create().texOffs(16, -3).addBox(1.5F, -4.0F, 5.25F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(0.0F, -4.0F, 6.75F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, 0.0799F, -0.4559F, -0.8577F));

		PartDefinition armorBody_r5 = armorBody.addOrReplaceChild("armorBody_r5", CubeListBuilder.create().texOffs(16, -3).addBox(-0.5F, -6.0F, 7.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(-2.0F, -6.0F, 9.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, -0.2026F, 0.0806F, -0.6184F));

		PartDefinition armorBody_r6 = armorBody.addOrReplaceChild("armorBody_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 1.0F, 6.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, -0.0715F, -0.05F, -0.6091F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Para la espalda, normalmente no rotamos el bipedBody aquí manualmente
		// porque ICurioRenderer.followBody ya se encarga de que el modelo
		// siga las rotaciones del torso del jugador (incluyendo cuando se agacha).
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