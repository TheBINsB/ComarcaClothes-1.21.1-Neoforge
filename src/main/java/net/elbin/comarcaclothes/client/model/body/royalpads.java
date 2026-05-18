package net.elbin.comarcaclothes.client.model.body;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elbin.comarcaclothes.ComarcaClothes;
import net.elbin.comarcaclothes.client.renderer.cosmetics.IBodyModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class royalpads<T extends LivingEntity> extends EntityModel<T> implements IBodyModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "royalpads"), "main");

	private final ModelPart root;
	public final ModelPart bipedBody;
	public final ModelPart bipedLeftArm;
	public final ModelPart bipedRightArm;
	private final ModelPart bipedLeftLeg;
	private final ModelPart bipedRightLeg;

	public royalpads(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
		this.bipedLeftArm = root.getChild("bipedLeftArm");
		this.bipedRightArm = root.getChild("bipedRightArm");
		this.bipedLeftLeg = root.getChild("bipedLeftLeg");
		this.bipedRightLeg = root.getChild("bipedRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition armorLeftArm = bipedLeftArm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("bipedRightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition armorRightArm = bipedRightArm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-4.0F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bipedLeftLeg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("bipedRightLeg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Las rotaciones se sincronizan en el Renderer usando followBodyRotations, etc.
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bipedLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bipedRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	public ModelPart getRoot() { return this.root; }

	@Override
	public ModelPart getBody() {
		return this.bipedBody;
	}

	@Override
	public ModelPart getLeftArm() {
		return this.bipedLeftArm;
	}

	@Override
	public ModelPart getRightArm() {
		return this.bipedRightArm;
	}

	@Override public ModelPart getLeftLeg() {
		return this.bipedLeftLeg;
	}

	@Override public ModelPart getRightLeg() {
		return this.bipedRightLeg;
	}
}