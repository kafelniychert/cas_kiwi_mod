package net.chert.kiwimod;

import net.chert.kiwimod.entity.ModEntities;
import net.chert.kiwimod.entity.custom.KiwiEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class KiwiMod implements ModInitializer {
	public static final String MOD_ID = "kiwimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.KIWI, KiwiEntity.createAttributes());
	}
}