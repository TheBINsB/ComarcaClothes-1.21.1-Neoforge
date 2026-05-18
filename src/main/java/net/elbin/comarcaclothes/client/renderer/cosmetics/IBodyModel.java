package net.elbin.comarcaclothes.client.renderer.cosmetics;

import net.minecraft.client.model.geom.ModelPart;

public interface IBodyModel {
    ModelPart getBody();
    ModelPart getLeftArm();
    ModelPart getRightArm();

    // NUEVO: Para ropa larga
    ModelPart getLeftLeg();
    ModelPart getRightLeg();
}
