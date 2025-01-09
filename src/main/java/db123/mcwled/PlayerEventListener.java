package com.example.wledmod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerEventListener {
    public static void register() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            server.getPlayerManager().getPlayerList().forEach(player -> {
                String biomeId = player.world.getBiome(player.getBlockPos()).toString();
                BiomeEffectHandler.handleBiomeChange(biomeId);
            });
        });
    }
}
