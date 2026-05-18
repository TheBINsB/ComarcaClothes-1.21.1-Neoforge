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

public class magecape1<T extends LivingEntity> extends EntityModel<T> implements IBackModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID, "magecape1"), "main");

	private final ModelPart root;
	private final ModelPart bipedBody;
	private final ModelPart cape;

	public magecape1(ModelPart root) {
		this.root = root;
		this.bipedBody = root.getChild("bipedBody");
		this.cape = this.bipedBody.getChild("cape");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cape = bipedBody.addOrReplaceChild("cape", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cape_r1 = cape.addOrReplaceChild("cape_r1", CubeListBuilder.create().texOffs(4, 24).addBox(-4.0F, -24.0F, 2.0F, 6.0F, 22.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 24.0F, 0.9F, 0.0609F, -0.0053F, 0.0871F));

		PartDefinition cape_r2 = cape.addOrReplaceChild("cape_r2", CubeListBuilder.create().texOffs(4, 24).mirror().addBox(-2.0F, -24.0F, 2.0F, 6.0F, 22.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 24.0F, 0.9F, 0.0609F, 0.0053F, -0.0871F));

		PartDefinition cape_r3 = cape.addOrReplaceChild("cape_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -24.0F, 2.0F, 8.0F, 22.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.9F, 0.0611F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.cape.xRot = 0.0F;
		this.cape.zRot = 0.0F; // Por si queremos añadir bamboleo lateral

		// FÍSICAS DE MOVIMIENTO (Al caminar)
		// limbSwingAmount  0.0 (quieto) 1.0 (corriendo)
		float velocidad = Math.min(limbSwingAmount, 1.0F);

		//  (default 0.6F)
		this.cape.xRot += velocidad * 0.6F;

		// función para simular el viento
		if (velocidad < 0.1F) { // Solo si el jugador está casi quieto
			this.cape.xRot += (float) Math.sin(ageInTicks * 0.1F) * 0.06F; // Balanceo suave adelante/atrás
			this.cape.zRot += (float) Math.cos(ageInTicks * 0.05F) * 0.03F; // Balanceo sutil a los lados
		}

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