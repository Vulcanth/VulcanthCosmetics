package com.vulcanth.cosmetics.view;

import com.vulcanth.commons.library.menu.PlayerCollectionUpdapleMenu;
import com.vulcanth.commons.player.Profile;
import com.vulcanth.commons.utils.BukkitUtils;
import com.vulcanth.cosmetics.cosmetics.collections.closet.ArmorPart;
import com.vulcanth.cosmetics.cosmetics.collections.closet.ArmorPartType;
import com.vulcanth.cosmetics.cosmetics.collections.closet.Closet;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuCloset extends PlayerCollectionUpdapleMenu {
    private Profile profile;
    private ArmorPartType type;

    public MenuCloset(Profile profile, ArmorPartType type) {
        super(profile.getPlayer(), 6, "Guarda Roupa");
        this.profile = profile;
        this.type = type;
        this.setOnlySlots(Arrays.asList(12, 13, 14, 21, 22, 23));
        this.setNextItem(BukkitUtils.getItemStackFromString("ARROW : 1 : nome>&aPróxima Página"));
        this.setNextItemSlot(35);
        this.setPreviusItem(BukkitUtils.getItemStackFromString("ARROW : 1 : nome>&aPágina anterior"));
        this.setPreviusItemSlot(27);

        setupItens(profile.getPlayer());
        registerMenu();
        setDelay(1);
    }

    @Override
    public void onPlayerCloseMenu(InventoryCloseEvent event) {
        if (event.getInventory().equals(this.getInventory())) {
            destroy();
        }
    }

    @Override
    public void onPlayerInteractMenu(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (player == this.profile.getPlayer()) {
                if (event.getCurrentItem() != null && !event.getCurrentItem().getType().equals(Material.AIR) && player.getOpenInventory().getTopInventory().equals(this.getInventory())) {
                    int slot = event.getSlot();
                    ArmorPart part = (ArmorPart) this.getValueForItem(slot, this.getItemForSlot(slot));
                    part.equip(player);
                    event.setCancelled(true);
                }
            }
        }
    }

    @Override
    public void onPlayerQuitOnMenu(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (this.profile.getPlayer() == player) {
            if (player.getOpenInventory().getTopInventory().equals(this.getInventory())) {
                destroy();
            }
        }
    }

    @Override
    public void setupItens(Player player) {
        switch (type) {
            case HELMET: {
                this.setItem(BukkitUtils.getItemStackFromString("351:10 : 1 : nome>&aEditando Capacete"), 9);
                break;
            }

            case CHESTPLATE: {
                this.setItem(BukkitUtils.getItemStackFromString("351:10 : 1 : nome>&aEditando Peitoral"), 18);
                break;
            }

            case LEGGINS: {
                this.setItem(BukkitUtils.getItemStackFromString("351:10 : 1 : nome>&aEditando Calça"), 27);
                break;
            }

            case BOOTS: {
                this.setItem(BukkitUtils.getItemStackFromString("351:10 : 1 : nome>&aEditando Botas"), 36);
                break;
            }
        }

        this.setItem(BukkitUtils.getItemStackFromString("ARROW : 1 : nome>&cVoltar"), 48);
        this.setItem(BukkitUtils.getItemStackFromString("BARRIER : 1 : nome>&cRemover " + this.type.getName()), 49);
        this.setItem(BukkitUtils.getItemStackFromString("NETHER_STAR : 1 : nome>&aAtivar Brilho"), 50);
    }

    @Override
    public void destroy() {
        this.profile = null;
        this.type = null;
        this.getThread().cancel();
        HandlerList.unregisterAll(this);
    }

    @Override
    public void update(Player player) {
        Map<ItemStack, Object> actionForSlot = new LinkedHashMap<>();
        for (Closet closet : Closet.listClosetItens()) {
            actionForSlot.put(closet.getParty(this.type).getIcon(), closet.getParty(this.type));
        }

        setItens(actionForSlot);
    }
}
