package com.vulcanth.cosmetics.commands.collections;

import com.vulcanth.commons.commands.CommandsAbstract;
import com.vulcanth.commons.player.Profile;
import com.vulcanth.cosmetics.view.MenuCosmetics;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CosmeticsCommand extends CommandsAbstract {

    public CosmeticsCommand() {
        super("cosmetics", true);
    }

    @Override
    public void executeCommand(CommandSender commandSender, String s, String[] strings) {
        Player player = getPlayerSender(commandSender);
        Profile profile = Profile.loadProfile(player.getName());
        if (profile != null && profile.getGame() == null) {
            //new MenuCosmetics(profile).open();
            player.sendMessage("§cEm desenvolvimento");
        }
    }

}
