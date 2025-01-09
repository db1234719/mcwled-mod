package com.example.wledmod;

import net.minecraft.entity.damage.DamageSource;

public class DamageEffectHandler {
    public static void handleDamage(DamageSource source) {
        String event = switch (source.getName()) {
            case "fire" -> "fire_damage";
            case "drowning" -> "drowning_damage";
            default -> "normal_damage";
        };

        WLEDAPI.sendWLEDEvent(event);
    }
}
