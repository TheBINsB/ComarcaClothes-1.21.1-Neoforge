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

public class dragonskull<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {

	// CORRECCIÓN 1: ResourceLocation.fromNamespaceAndPath en lugar de new ResourceLocation
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "dragonskull"), "main");

	private final ModelPart bipedHead;

	public dragonskull(ModelPart root) {
		// CORRECCIÓN 2: El constructor de EntityModel ahora maneja el root internamente en algunas versiones,
		// pero para Curios necesitamos acceder a las partes.
		this.bipedHead = root.getChild("bipedHead");
	}

	public ModelPart getRoot() {
		return this.bipedHead;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 46).mirror().addBox(2.0F, -18.5F, -1.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 9.5F, 0.134F, 0.2163F, 0.0289F));
		armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(2.0F, -21.4763F, 3.2164F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 9.5F, 0.3522F, 0.2163F, 0.0289F));
		armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 35).addBox(-5.0F, -21.4763F, 3.2164F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 10.0F, 9.5F, 0.3522F, -0.2163F, -0.0289F));
		armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(0, 46).addBox(-5.0F, -18.5F, -1.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 10.0F, 9.5F, 0.134F, -0.2163F, -0.0289F));
		armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(2, 20).addBox(-4.5F, -16.5559F, -6.1139F, 9.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 7.5F, 0.6109F, 0.0F, 0.0F));
		armorHead.addOrReplaceChild("armorHead_r6", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, -20.0F, -16.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.0F, -21.0F, -9.5F, 10.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 7.5F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Aquí sincronizamos la rotación del cráneo con la cabeza del jugador
		this.bipedHead.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.bipedHead.xRot = headPitch * ((float)Math.PI / 180F);
	}

	// CORRECCIÓN 3: En 1.21.1 el método se llama renderToBuffer y la firma cambió ligeramente
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	public ModelPart getHead() {
		return this.bipedHead;
	}
}