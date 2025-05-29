package net.chert.kiwimod.entity.client;

import net.chert.kiwimod.KiwiMod;
import net.chert.kiwimod.entity.custom.KiwiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class KiwiRenderer extends MobEntityRenderer<KiwiEntity, KiwiModel<KiwiEntity>> {
    public KiwiRenderer(EntityRendererFactory.Context context) {
        super(context, new KiwiModel<>(context.getPart(KiwiModel.KIWI)), 0.5f);
    }

    @Override
    public Identifier getTexture(KiwiEntity entity) {
        return Identifier.of(KiwiMod.MOD_ID, "textures/entity/kiwi/texture_kiwi.png");
    }

    @Override
    public void render(KiwiEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i){
        if(livingEntity.isBaby()){
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        else{
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
