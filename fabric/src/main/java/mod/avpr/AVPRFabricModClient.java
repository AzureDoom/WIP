package mod.avpr;

import mod.avpr.client.renderer.TestEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AVPRFabricModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CommonClientClass.init();
        EntityRendererRegistry.register(AVPRFabricMod.TEST_ENTITY, TestEntityRenderer::new);
    }
}
