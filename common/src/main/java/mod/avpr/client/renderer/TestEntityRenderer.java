package mod.avpr.client.renderer;

import mod.avpr.Constants;
import mod.avpr.common.entities.TestEntity;
import mod.azure.azurelib.model.DefaultedEntityGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TestEntityRenderer extends GeoEntityRenderer<TestEntity> {

    /**
     *
     * Put your animation file in assets/avpr/animations/entity
     * Put your model file in assets/avpr/geo/entity
     * Put your texture file in assets/avpr/textures/entity
     */
    public TestEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel(Constants.rl("test_entity")));
    }
}
