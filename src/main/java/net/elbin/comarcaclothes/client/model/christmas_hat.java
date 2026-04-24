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

public class christmas_hat<T extends LivingEntity> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "christmas_hat"), "main");

	private final ModelPart root;
	private final ModelPart bipedHead;

	public christmas_hat(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -9.0F, -7.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(24, 15).addBox(-10.0F, -8.45F, -5.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F))
				.texOffs(26, 23).addBox(-11.0F, -4.75F, -12.25F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(8.0F, -5.0F, 5.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 29).addBox(-9.5F, -9.5F, -8.75F, 3.0F, 3.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(8.0F, -5.0F, 5.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-12.0F, -6.0F, -11.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(8.0F, -4.75F, 5.75F, -0.3054F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Esto sincroniza el gorro con la rotación de la cabeza del jugador
		this.bipedHead.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.bipedHead.xRot = headPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	// Getter para que el renderer pueda acceder a la raíz si es necesario
	public ModelPart getRoot() {
		return this.root;
	}
}