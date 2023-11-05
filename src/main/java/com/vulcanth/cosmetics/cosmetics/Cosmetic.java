package com.vulcanth.cosmetics.cosmetics;

import com.vulcanth.commons.player.role.Role;
import com.vulcanth.cosmetics.cosmetics.collections.closet.Closet;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Cosmetic {

    private static List<Cosmetic> COSMETICS_CACHE = new ArrayList<>();

    public static void setupCosmetics() {
        Closet.setupCloset();
    }

    private final String id;
    private final CosmeticType type;
    private final Long value;
    private final Boolean canBuy;
    private final String name;
    private final String permission;
    private final ItemStack iconNoHas;
    private final ItemStack iconNoHasPermission;
    private final ItemStack iconHas;
    private final ItemStack iconSelected;

    public Cosmetic(String id, CosmeticType type, String name, String permission, Long value, Boolean canBuy, ItemStack iconNoHas, ItemStack iconNoHasPermission, ItemStack iconHas, ItemStack iconSelected) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.permission = permission;
        this.value = value;
        this.canBuy = canBuy;
        this.iconNoHas = iconNoHas;
        this.iconNoHasPermission = iconNoHasPermission;
        this.iconHas = iconHas;
        this.iconSelected = iconSelected;
    }

    public boolean hasPermission(Player player) {
        return Role.findRole(player.getPlayer()).getId() <= 7 || player.hasPermission("COSMETICS." + this.type.getName().toUpperCase() + "." + this.name.toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPermission() {
        return this.permission;
    }

    public CosmeticType getType() {
        return this.type;
    }

    public Boolean getCanBuy() {
        return this.canBuy;
    }

    public Long getValue() {
        return this.value;
    }

    public ItemStack getIconHas() {
        return this.iconHas;
    }

    public ItemStack getIconNoHas() {
        return this.iconNoHas;
    }

    public ItemStack getIconNoHasPermission() {
        return this.iconNoHasPermission;
    }

    public ItemStack getIconSelected() {
        return this.iconSelected;
    }
}
