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

public class foxtail9<T extends LivingEntity> extends EntityModel<T> implements IBackModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID,  "foxtail9"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;

	public foxtail9(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition armorBody_r1 = armorBody.addOrReplaceChild("armorBody_r1", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F)).mirror(false)
				.texOffs(0, 17).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-4.2924F, 6.4858F, 9.8267F, 0.4841F, -0.715F, 0.0311F));

		PartDefinition armorBody_r2 = armorBody.addOrReplaceChild("armorBody_r2", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-2.2F, 9.5F, 6.7F, 0.8331F, -0.715F, 0.0311F));

		PartDefinition armorBody_r3 = armorBody.addOrReplaceChild("armorBody_r3", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
				.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(4.4924F, 6.4858F, 9.2267F, 0.4841F, 0.715F, -0.0311F));

		PartDefinition armorBody_r4 = armorBody.addOrReplaceChild("armorBody_r4", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(2.4F, 9.5F, 6.1F, 0.8331F, 0.715F, -0.0311F));

		PartDefinition armorBody_r5 = armorBody.addOrReplaceChild("armorBody_r5", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
				.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9181F, 11.0153F, 9.8669F, -0.0345F, 0.0353F, 0.0204F));

		PartDefinition armorBody_r6 = armorBody.addOrReplaceChild("armorBody_r6", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7F, 11.7F, 5.1F, 0.3146F, 0.0353F, 0.0204F));

		PartDefinition armorBody_r7 = armorBody.addOrReplaceChild("armorBody_r7", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
				.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(4.5755F, 10.9388F, 8.5542F, -0.0034F, 0.8407F, 0.0204F));

		PartDefinition armorBody_r8 = armorBody.addOrReplaceChild("armorBody_r8", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.3F, 11.7F, 5.1F, 0.3457F, 0.8407F, 0.0204F));

		PartDefinition armorBody_r9 = armorBody.addOrReplaceChild("armorBody_r9", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F)).mirror(false)
				.texOffs(0, 17).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-4.3343F, 11.3655F, 8.8311F, -0.1223F, -0.7671F, 0.0245F));

		PartDefinition armorBody_r10 = armorBody.addOrReplaceChild("armorBody_r10", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 11.7F, 5.1F, 0.2267F, -0.7671F, 0.0245F));

		PartDefinition armorBody_r11 = armorBody.addOrReplaceChild("armorBody_r11", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F)).mirror(false)
				.texOffs(0, 17).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-5.9685F, 15.1952F, 6.1341F, -0.6739F, -1.244F, -0.0008F));

		PartDefinition armorBody_r12 = armorBody.addOrReplaceChild("armorBody_r12", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-2.1F, 12.9F, 4.4F, -0.3248F, -1.244F, -0.0008F));

		PartDefinition armorBody_r13 = armorBody.addOrReplaceChild("armorBody_r13", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F)).mirror(false)
				.texOffs(0, 17).mirror().addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-1.6575F, 15.267F, 8.0643F, -0.7038F, -0.3227F, 0.0503F));

		PartDefinition armorBody_r14 = armorBody.addOrReplaceChild("armorBody_r14", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 12.9F, 4.0F, -0.3547F, -0.3227F, 0.0503F));

		PartDefinition armorBody_r15 = armorBody.addOrReplaceChild("armorBody_r15", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
				.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(5.8818F, 15.1322F, 6.8767F, -0.5234F, 1.0815F, 0.1641F));

		PartDefinition armorBody_r16 = armorBody.addOrReplaceChild("armorBody_r16", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(2.4F, 12.9F, 4.4F, -0.1744F, 1.0815F, 0.1641F));

		PartDefinition armorBody_r17 = armorBody.addOrReplaceChild("armorBody_r17", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.44F))
				.texOffs(0, 17).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.1306F, 15.2422F, 8.2073F, -0.6837F, 0.1674F, 0.032F));

		PartDefinition armorBody_r18 = armorBody.addOrReplaceChild("armorBody_r18", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.9F, 12.9F, 4.0F, -0.3347F, 0.1674F, 0.032F));

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