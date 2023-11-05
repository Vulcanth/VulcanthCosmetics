package com.vulcanth.cosmetics.cosmetics;

import java.util.Arrays;

public enum CosmeticType {

    PARTICLES("0", "Particulas"),
    BANNERS("1", "Banners"),
    GADGETS("2", "Engenhocas"),
    MUTATIONS("3", "Mutações"),
    PETS("4", "Pets"),
    COMPAPIONS("5", "Companheiros"),
    CAPES("6", "Capas"),
    HATS("7", "Chapéus"),
    ANIMATED_HATS("8", "Chapéus Animados");

    public static CosmeticType findByID(String id) {
        return Arrays.stream(CosmeticType.values()).filter(cosmeticType -> cosmeticType.getId().equals(id)).findFirst().orElse(null);
    }

    private final String name;
    private final String id;

    CosmeticType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}
