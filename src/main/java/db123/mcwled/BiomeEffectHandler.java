package com.example.wledmod;

import net.minecraft.world.biome.Biome;

public class BiomeEffectHandler {
    public static void handleBiomeChange(String biomeId) {
        String event = switch (biomeId) {
            case "minecraft:plains" -> "plains";
            case "minecraft:desert" -> "desert";
            // Add more biome mappings here...
            default -> "default";
        };

        WLEDAPI.sendWLEDEvent(event);
    }
}
