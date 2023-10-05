package mod.avpr;

import mod.avpr.common.entities.TestEntity;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Constants.MOD_ID)
public class AVPRForgeMod {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);
    public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = ENTITY_TYPE_DEFERRED_REGISTER.register("test_entity",
            () -> EntityType.Builder.<TestEntity>of(TestEntity::new, MobCategory.CREATURE).sized(1.0f, 1.0f).build("test_entity"));

    public AVPRForgeMod() {
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        if (FMLLoader.getDist().isClient()) {
            CommonClientClass.init();
        }
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(AVPRForgeMod::onGatherData);
        bus.addListener(AVPRForgeMod::setupCommon);
        bus.addListener(AVPRForgeMod::createTestEntityAttributes);
    }

    private static void onGatherData(GatherDataEvent event) {
        FabricDataGenerator fabricDataGenerator = FabricDataGenerator.create(Constants.MOD_ID, event);
        CommonClass.runDatagen(fabricDataGenerator);
    }
    public static void createTestEntityAttributes(final EntityAttributeCreationEvent event){
        event.put(TEST_ENTITY.get(), TestEntity.makeMobAttributes().build());
    }

    public static void setupCommon(final FMLCommonSetupEvent event){
        ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}