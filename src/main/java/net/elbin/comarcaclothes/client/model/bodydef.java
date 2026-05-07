package net.elbin.comarcaclothes.client.model;

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

public class bodydef<T extends LivingEntity> extends EntityModel<T> implements IBodyModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "bodydef"), "main");

	private final ModelPart root;
	public final ModelPart bipedBody;
	public final ModelPart bipedLeftArm;
	public final ModelPart bipedRightArm;

	public bodydef(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
		this.bipedLeftArm = root.getChild("bipedLeftArm");
		this.bipedRightArm = root.getChild("bipedRightArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// Torso
		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(16, 16)
				.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		// Brazo Izquierdo
		PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		bipedLeftArm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(40, 16).mirror()
				.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		// Brazo Derecho
		PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("bipedRightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		bipedRightArm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(40, 16)
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
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
}