package net.chert.kiwimod;

import net.chert.kiwimod.entity.ModEntities;
import net.chert.kiwimod.entity.client.KiwiModel;
import net.chert.kiwimod.entity.client.KiwiRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class KiwiModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(KiwiModel.KIWI, KiwiModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.KIWI, KiwiRenderer::new);
    }
}
