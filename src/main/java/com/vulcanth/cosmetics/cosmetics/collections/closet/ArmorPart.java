package com.vulcanth.cosmetics.cosmetics.collections.closet;

import com.vulcanth.commons.utils.BukkitUtils;
import com.vulcanth.cosmetics.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ArmorPart {

    private final ArmorPartType type;
    private final boolean copyMaterial;
    private final boolean isRgb;
    private ItemStack item;
    private ItemStack icon;

    public ArmorPart(ArmorPartType type, ItemStack icon, ItemStack item, boolean rgb, boolean copyMaterial) {
        this.type = type;
        this.item = item;
        this.icon = icon;
        this.copyMaterial = copyMaterial;
        this.isRgb = rgb;
        if (rgb) {
            startArmorUpdater();
        }
    }

    public void startArmorUpdater() {
        new BukkitRunnable() {
            private int r = 0;
            private int g = 0;
            private int b = 0;

            @Override
            public void run() {
                if (r == 255 || g == 255 || b == 255) {
                    r = 0;
                    g = 0;
                    b = 0;
                }

                switch (type) {
                    case HELMET: {
                        item = BukkitUtils.getItemStackFromString("298 : 1 : nome>&aChapéu de Couro : paint>" + r + ":" + g + ":" + b);
                        break;
                    }

                    case CHESTPLATE: {
                        item = BukkitUtils.getItemStackFromString("299 : 1 : nome>&aPeitoral de Couro : paint>" + r + ":" + g + ":" + b);
                        break;
                    }

                    case LEGGINS: {
                        item = BukkitUtils.getItemStackFromString("300 : 1 : nome>&aCalça de Couro : paint>" + r + ":" + g + ":" + b);
                        break;
                    }

                    case BOOTS: {
                        item = BukkitUtils.getItemStackFromString("299 : 1 : nome>&aBota de Couro : paint>" + r + ":" + g + ":" + b);
                        break;
                    }
                }

                r++;
                g++;
                b++;
                if (copyMaterial) {
                    ItemStack newIcon = item;
                    ItemMeta meta = newIcon.getItemMeta();
                    meta.setDisplayName(icon.getItemMeta().getDisplayName());
                    meta.setLore(icon.getItemMeta().getLore());
                    newIcon.setItemMeta(meta);
                    icon = newIcon;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 1L);
    }

    public ArmorPartType getType() {
        return this.type;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public ItemStack getIcon() {
        return this.icon;
    }

    public BukkitTask equip(Player player) {
        PlayerInventory inventory = player.getInventory();
        BukkitTask task = null;
        switch (type) {
            case HELMET: {
                inventory.setHelmet(this.item);
                if (isRgb) {
                    task = new BukkitRunnable() {
                        private int r = 0;
                        private int g = 0;
                        private int b = 0;

                        @Override
                        public void run() {
                            if (r == 255 || g == 255 || b == 255) {
                                r = 0;
                                g = 0;
                                b = 0;
                            }

                            ItemStack itemNow = BukkitUtils.getItemStackFromString("298 : 1 : nome>&aChapéu de Couro : paint>" + r + ":" + g + ":" + b);
                            r++;
                            g++;
                            b++;

                            player.getInventory().setHelmet(itemNow);
                        }
                    }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 1L);
                }
                break;
            }

            case CHESTPLATE: {
                inventory.setChestplate(this.item);
                if (isRgb) {
                    task = new BukkitRunnable() {
                        private int r = 0;
                        private int g = 0;
                        private int b = 0;

                        @Override
                        public void run() {
                            if (r == 255 || g == 255 || b == 255) {
                                r = 0;
                                g = 0;
                                b = 0;
                            }

                            ItemStack itemNow = BukkitUtils.getItemStackFromString("299 : 1 : nome>&aPeitoral de Couro : paint>" + r + ":" + g + ":" + b);
                            r++;
                            g++;
                            b++;

                            player.getInventory().setChestplate(itemNow);
                        }
                    }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 1L);
                }
                break;
            }

            case LEGGINS: {
                inventory.setLeggings(this.item);
                if (isRgb) {
                    task = new BukkitRunnable() {
                        private int r = 0;
                        private int g = 0;
                        private int b = 0;

                        @Override
                        public void run() {
                            if (r == 255 || g == 255 || b == 255) {
                                r = 0;
                                g = 0;
                                b = 0;
                            }

                            ItemStack itemNow = BukkitUtils.getItemStackFromString("300 : 1 : nome>&aCalça de Couro : paint>" + r + ":" + g + ":" + b);
                            r++;
                            g++;
                            b++;

                            player.getInventory().setLeggings(itemNow);
                        }
                    }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 1L);
                }
                break;
            }

            case BOOTS: {
                inventory.setBoots(this.item);
                if (isRgb) {
                    task = new BukkitRunnable() {
                        private int r = 0;
                        private int g = 0;
                        private int b = 0;

                        @Override
                        public void run() {
                            if (r == 255 || g == 255 || b == 255) {
                                r = 0;
                                g = 0;
                                b = 0;
                            }

                            ItemStack itemNow = BukkitUtils.getItemStackFromString("301 : 1 : nome>&aBota de Couro : paint>" + r + ":" + g + ":" + b);
                            r++;
                            g++;
                            b++;

                            player.getInventory().setBoots(itemNow);
                        }
                    }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 1L);
                }
                break;
            }
        }



        return task;
    }

}
