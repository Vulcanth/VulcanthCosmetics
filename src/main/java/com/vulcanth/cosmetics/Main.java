package com.vulcanth.cosmetics;

import com.vulcanth.commons.commands.CommandsAbstract;
import com.vulcanth.commons.plugin.VulcanthPlugins;
import com.vulcanth.cosmetics.commands.Command;
import com.vulcanth.cosmetics.commands.collections.CosmeticsCommand;
import com.vulcanth.cosmetics.cosmetics.Cosmetic;

public class Main extends VulcanthPlugins {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void loadPlugin() {
        instance = this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void enablePlugin() {
        Command.setupCommands();
        Cosmetic.setupCosmetics();

        this.sendMessage("O plugin iniciou com sucesso!");
    }

    @Override
    public void disablePlugin() {
        this.sendMessage("O plugin desligou com sucesso!");
    }
}