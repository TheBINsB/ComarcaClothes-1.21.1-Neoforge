package net.elbin.comarcaclothes.client.model.head;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


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

public class scara<T extends LivingEntity> extends EntityModel<T> implements IHeadModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(ComarcaClothes.MOD_ID,  "scara"), "main");

	private final ModelPart root;
	private final ModelPart cloth;
	private final ModelPart bipedHead;

	public scara(ModelPart root) {
		this.root = root;
		this.bipedHead = root.getChild("bipedHead");
		this.cloth = this.bipedHead.getChild("cloth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cloth = bipedHead.addOrReplaceChild("cloth", CubeListBuilder.create().texOffs(49, 31).mirror().addBox(-8.0F, 24.5F, -1.45F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 31).addBox(-5.0F, 24.5F, -1.45F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(9, 52).addBox(-7.0F, 25.5F, -0.45F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 52).addBox(-7.0F, 22.5F, -1.05F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(33, 39).addBox(-9.0F, 0.5F, -0.05F, 6.0F, 25.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(9, 52).mirror().addBox(5.0F, 25.5F, -0.45F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 31).addBox(7.0F, 24.5F, -1.45F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(49, 31).mirror().addBox(4.0F, 24.5F, -1.45F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 52).mirror().addBox(5.0F, 22.5F, -1.05F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(33, 39).mirror().addBox(3.0F, 0.5F, -0.05F, 6.0F, 25.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, -8.0F, 9.55F));

		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(46, 44).addBox(0.4F, -12.5F, -10.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 41).addBox(-3.5F, -10.5F, -3.5F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -8.0F, -9.0F, 19.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-8.9F, -7.5F, -11.0F, 19.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorHead_r1 = armorHead.addOrReplaceChild("armorHead_r1", CubeListBuilder.create().texOffs(0, 37).addBox(-9.0F, -11.5F, 8.5F, 19.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.5F, 4.0F, 0.8F, 0.0F, 1.5708F, 0.0F));

		PartDefinition armorHead_r2 = armorHead.addOrReplaceChild("armorHead_r2", CubeListBuilder.create().texOffs(0, 37).addBox(-9.0F, -11.5F, -11.5F, 19.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 4.0F, 0.2F, 0.0F, -1.5708F, 0.0F));

		PartDefinition armorHead_r3 = armorHead.addOrReplaceChild("armorHead_r3", CubeListBuilder.create().texOffs(0, 37).addBox(-9.0F, -11.5F, 8.5F, 19.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 4.0F, 20.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition armorHead_r4 = armorHead.addOrReplaceChild("armorHead_r4", CubeListBuilder.create().texOffs(49, 26).addBox(-1.4393F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 52).addBox(-1.4393F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 21).addBox(-2.4393F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 24.0F, 0.7F, -3.1416F, -0.7854F, -3.1416F));

		PartDefinition armorHead_r5 = armorHead.addOrReplaceChild("armorHead_r5", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-0.5607F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 26).mirror().addBox(-0.5607F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 21).mirror().addBox(-1.5607F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6F, 24.0F, 2.4F, -3.1416F, 0.9599F, -3.1416F));

		PartDefinition armorHead_r6 = armorHead.addOrReplaceChild("armorHead_r6", CubeListBuilder.create().texOffs(49, 26).addBox(-1.4393F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 52).addBox(-1.4393F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 21).addBox(-2.4393F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition armorHead_r7 = armorHead.addOrReplaceChild("armorHead_r7", CubeListBuilder.create().texOffs(49, 21).mirror().addBox(-1.5607F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 52).mirror().addBox(-0.5607F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 26).mirror().addBox(-0.5607F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition armorHead_r8 = armorHead.addOrReplaceChild("armorHead_r8", CubeListBuilder.create().texOffs(49, 21).mirror().addBox(-1.5607F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 52).mirror().addBox(-0.5607F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 26).mirror().addBox(-0.5607F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition armorHead_r9 = armorHead.addOrReplaceChild("armorHead_r9", CubeListBuilder.create().texOffs(49, 21).addBox(-2.4393F, -31.5F, -13.9602F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 52).addBox(-1.4393F, -31.5F, -14.9602F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 26).addBox(-1.4393F, -32.5F, -13.9602F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 24.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition armorHead_r10 = armorHead.addOrReplaceChild("armorHead_r10", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-2.0F, -12.5F, -7.5F, 9.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 2.3F, 0.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition armorHead_r11 = armorHead.addOrReplaceChild("armorHead_r11", CubeListBuilder.create().texOffs(0, 21).addBox(-7.0F, -12.5F, -7.5F, 9.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 2.3F, -1.0F, -1.5708F, 1.309F, -1.5708F));

		PartDefinition armorHead_r12 = armorHead.addOrReplaceChild("armorHead_r12", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-2.0F, -12.5F, -7.5F, 9.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3F, 2.3F, 2.4F, 1.5708F, 1.309F, 1.5708F));

		PartDefinition armorHead_r13 = armorHead.addOrReplaceChild("armorHead_r13", CubeListBuilder.create().texOffs(0, 21).addBox(-7.0F, -12.5F, -7.5F, 9.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 2.3F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition armorHead_r14 = armorHead.addOrReplaceChild("armorHead_r14", CubeListBuilder.create().texOffs(43, 37).mirror().addBox(-12.7476F, -11.354F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3F, 4.2F, 1.3F, -1.5708F, -1.1781F, 1.5708F));

		PartDefinition armorHead_r15 = armorHead.addOrReplaceChild("armorHead_r15", CubeListBuilder.create().texOffs(43, 37).addBox(9.7476F, -11.354F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 4.2F, -0.3F, 1.5708F, -1.1781F, -1.5708F));

		PartDefinition armorHead_r16 = armorHead.addOrReplaceChild("armorHead_r16", CubeListBuilder.create().texOffs(43, 37).mirror().addBox(-12.7476F, -11.354F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 4.2F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition armorHead_r17 = armorHead.addOrReplaceChild("armorHead_r17", CubeListBuilder.create().texOffs(43, 37).addBox(9.7476F, -11.354F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 4.2F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition armorHead_r18 = armorHead.addOrReplaceChild("armorHead_r18", CubeListBuilder.create().texOffs(46, 44).addBox(-0.5F, -36.5F, 5.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 24.0F, 17.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Movimiento a los trozos de tela
		// Reiniciamos la rotación para que no se acumule infinitamente
		this.cloth.xRot = 0.0F;
		this.cloth.zRot = 0.0F; // Por si queremos añadir bamboleo lateral

		// FISICAS DE MOVIMIENTO (Al caminar)
		// limbSwingAmount default 0.0 (quieto) 1.0 (corriendo)
		float velocidad = Math.min(limbSwingAmount, 1.0F);

		// default (0.6F)
		this.cloth.xRot += velocidad * 0.8F;

		// balanceo cuando está quieto
		// ageInTicks para simular el viento
		if (velocidad < 0.1F) { // Solo si el jugador está casi quieto
			this.cloth.xRot += (float) Math.sin(ageInTicks * 0.1F) * 0.06F; // Balanceo suave adelante/atrás (default 0.05F)
			this.cloth.zRot += (float) Math.cos(ageInTicks * 0.05F) * 0.03F; // Balanceo sutil a los lados (default 0.03F)
		}
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