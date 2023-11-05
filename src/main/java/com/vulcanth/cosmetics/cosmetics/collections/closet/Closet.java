package com.vulcanth.cosmetics.cosmetics.collections.closet;

import com.vulcanth.cosmetics.cosmetics.collections.closet.collections.RGBArmor;

import java.util.ArrayList;
import java.util.List;

public abstract class Closet {

    private static final List<Closet> CLOSET_CACHE = new ArrayList<>();

    public static void setupCloset() {
        CLOSET_CACHE.add(new RGBArmor().setupContent());
    }

    public static List<Closet> listClosetItens() {
        return CLOSET_CACHE;
    }

    private final String id;
    private final List<ArmorPart> parts;

    public Closet(String id) {
        this.id = id;
        this.parts = new ArrayList<>();
    }

    public void registerNewPart(ArmorPart part) {
        this.parts.add(part);
    }

    public abstract Closet setupContent();

    public ArmorPart getParty(ArmorPartType type) {
        return this.parts.stream().filter(part -> part.getType().equals(type)).findFirst().orElse(null);
    }

    public List<ArmorPart> listParts() {
        return this.parts;
    }

    public String getId() {
        return this.id;
    }

}
