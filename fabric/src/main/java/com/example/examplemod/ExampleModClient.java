package com.example.examplemod;

import net.fabricmc.api.ClientModInitializer;

public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CommonClientClass.init();
    }
}
