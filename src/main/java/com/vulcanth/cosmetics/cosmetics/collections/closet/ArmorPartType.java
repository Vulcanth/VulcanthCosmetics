package com.vulcanth.cosmetics.cosmetics.collections.closet;

public enum ArmorPartType {

    HELMET("0", "Capacete"),
    CHESTPLATE("1", "Peitoral"),
    LEGGINS("2", "Calça"),
    BOOTS("3", "Bota");

    private String id;
    private String name;

    ArmorPartType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
