package mod.avpr;

import mod.avpr.common.entities.TestEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class AVPRFabricMod implements ModInitializer {

    public static EntityType<TestEntity> TEST_ENTITY = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Constants.rl("test_entity"), FabricEntityTypeBuilder.create(MobCategory.CREATURE, TestEntity::new).dimensions(EntityDimensions.scalable(1.0f, 1.0f)).build());

    @Override
    public void onInitialize() {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        CommonClass.init();
        FabricDefaultAttributeRegistry.register(TEST_ENTITY, TestEntity.makeMobAttributes());
    }
}
