package com.vulcanth.cosmetics.view;

import com.vulcanth.commons.library.menu.PlayerMenu;
import com.vulcanth.commons.player.Profile;
import com.vulcanth.commons.player.role.Role;
import com.vulcanth.commons.player.role.RoleEnum;
import com.vulcanth.commons.utils.BukkitUtils;
import com.vulcanth.cosmetics.cosmetics.collections.closet.ArmorPartType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MenuCosmetics extends PlayerMenu {
    private Profile profile;

    public MenuCosmetics(Profile profile) {
        super(profile.getPlayer(), 5, "Cosméticos");
        this.profile = profile;

        setupItens(profile.getPlayer());
        registerMenu();
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
                    event.setCancelled(true);
                    switch (slot) {
                        case 10: {
                            if (Role.findRole(player).equals(RoleEnum.MEMBRO)) {
                                player.sendMessage("§cExclusivo para o grupo §aVIP §cou superior!");
                                return;
                            }

                            new MenuCloset(profile, ArmorPartType.HELMET).open();
                            break;
                        }
                    }
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
        int max;
        long have;
        String name;
        String color;

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("SKULL_ITEM:3 : 1 : nome>&aChapéus Animados : desc>&7Escolha um chapéu animado para\n&7exibir as mais diversas reações.\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 34);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("SKULL_ITEM:3 : 1 : nome>&aCompanheiros : desc>&7Tenha um companheiro exclusivo\n&7ao seu lado em nossos lobbies!\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir! : skin>eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjNjhlODJhZDMyMmU1OWZhNDUwN2M0YTM4MWIxNmEwMzRmMDI2ZmRkNmQ3OTNiYTZkMGFkNDFlNjUwZGYyMCJ9fX0="), 29);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("SKULL_ITEM:3 : 1 : nome>&aChapéus : desc>&7Escolha um chapéu para andar\n&7com estilo em nossos lobbies.\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir! : skin>eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzI1YWY5NjZhMzI2ZjlkOTg0NjZhN2JmODU4MmNhNGRhNjQ1M2RlMjcxYjNiYzllNTlmNTdhOTliNjM1MTFjNiJ9fX0="), 33);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("BONE : 1 : nome>&aPets : desc>&7Passeie pelo nossos lobbies\n&7acompanhado por um Pet!\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 28);

        this.setItem(BukkitUtils.getItemStackFromString("LEATHER_CHESTPLATE : 1 : nome>&aGuarda-Roupa : desc>&7Personalize sua armadura da forma que quiser!\n \n&cExclusivo para o grupo &aVIP &cou superior.\n \n&eClique para abrir!"), 10);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("397:2 : 1 : nome>&aMutações : desc>&7Você pode se transformar em um mob\n&7especial enquanto anda pelos lobbies.\n \n&fDesbloqueados: " + color + have + "/" + max + "\n§fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 16);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString( "379 : 1 : nome>&aEngenhocas : desc>&7Escolha uma engenhoca\n&7para se divertir em nossos lobbies!\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 15);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("BLAZE_POWDER : 1 : nome>&aPartículas : desc>&7Passeie em nossos lobbies com\n&7partículas em volta de você.\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 11);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("381 : 1 : nome>&aCapas : desc>&7Passeie em nossos lobbies com\n&7asas deslumbrantes.\n \n&fDesbloqueados: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir!"), 31);

        max = 0;
        have = 0;
        name = "&cNenhum";
        color = "&a";
        this.setItem(BukkitUtils.getItemStackFromString("BANNER : 1 : nome>&aBanners : esconder>tudo : desc>&7Escolha banners com diversos\n&7desenhos diferentes para usar\n&7nos lobbies\n \n" + "&fDesbloqueado: " + color + have + "/" + max + "\n&fSelecionado atualmente:\n&a" + name + "\n \n&eClique para abrir! : pattern>WHITE:MOJANG : bannerBaseColor>RED"), 13);
    }

    @Override
    public void destroy() {
        this.profile = null;
        HandlerList.unregisterAll(this);
    }

}
