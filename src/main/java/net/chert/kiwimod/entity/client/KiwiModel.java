package net.chert.kiwimod.entity.client;

import net.chert.kiwimod.KiwiMod;
import net.chert.kiwimod.entity.custom.KiwiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class KiwiModel <T extends KiwiEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer KIWI = new EntityModelLayer(Identifier.of(KiwiMod.MOD_ID, "mantis"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart l_leg;
    private final ModelPart r_leg;
	public KiwiModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.l_leg = root.getChild("l_leg");
        this.r_leg = root.getChild("r_leg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.5309F, 0.3671F, 6.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 14.5309F, -1.3671F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, -1.5463F, -3.4493F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 13.5463F, 0.4493F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(13, 24).cuboid(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5463F, -5.0507F, -1.2654F, 0.0F, 0.0F));

        ModelPartData l_leg = modelPartData.addChild("l_leg", ModelPartBuilder.create().uv(16, 30).cuboid(-0.5F, -0.25F, -0.7033F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 14).cuboid(-0.5F, 5.75F, -5.7033F, 1.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 18.25F, 2.7033F));

        ModelPartData cube_r2 = l_leg.addChild("cube_r2", ModelPartBuilder.create().uv(26, 0).cuboid(-0.5F, 0.0F, -3.5F, 1.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 5.75F, -2.2033F, 0.0F, -0.5672F, 0.0F));

        ModelPartData cube_r3 = l_leg.addChild("cube_r3", ModelPartBuilder.create().uv(0, 23).cuboid(-0.5F, 0.0F, -3.5F, 1.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 5.75F, -2.2033F, 0.0F, 0.5672F, 0.0F));

        ModelPartData r_leg = modelPartData.addChild("r_leg", ModelPartBuilder.create().uv(18, 22).cuboid(-0.5F, 5.75F, -5.7033F, 1.0F, 0.0F, 8.0F, new Dilation(0.0F))
                .uv(20, 30).cuboid(-0.5F, -0.25F, -0.7033F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 18.25F, 2.7033F));

        ModelPartData cube_r4 = r_leg.addChild("cube_r4", ModelPartBuilder.create().uv(0, 28).cuboid(-0.5F, 0.0F, -3.5F, 1.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 5.75F, -2.2033F, 0.0F, -0.5672F, 0.0F));

        ModelPartData cube_r5 = r_leg.addChild("cube_r5", ModelPartBuilder.create().uv(26, 5).cuboid(-0.5F, 0.0F, -3.5F, 1.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 5.75F, -2.2033F, 0.0F, 0.5672F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(KiwiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(KiwiAnimations.KIWI_ANIM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, KiwiAnimations.KIWI_ANIM_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch){
        headYaw = MathHelper.clamp(headYaw, -30, 30);
        headPitch = MathHelper.clamp(headPitch, -25, 45);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        body.render(matrices, vertexConsumer, light, overlay, color);
        head.render(matrices, vertexConsumer, light, overlay, color);
        l_leg.render(matrices, vertexConsumer, light, overlay, color);
        r_leg.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return body;
    }
}
