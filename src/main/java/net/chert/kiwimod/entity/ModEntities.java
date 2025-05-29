package net.chert.kiwimod.entity;

import net.chert.kiwimod.KiwiMod;
import net.chert.kiwimod.entity.custom.KiwiEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<KiwiEntity> KIWI = Registry.register(Registries.ENTITY_TYPE, Identifier.of(KiwiMod.MOD_ID, "kiwi"), EntityType.Builder.create(KiwiEntity::new, SpawnGroup.CREATURE).dimensions(0.6f, 0.8f).build());

    public static void registerModEntities(){
        KiwiMod.LOGGER.info("Registering mod entities for " + KiwiMod.MOD_ID);
    }
}
