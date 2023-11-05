package com.vulcanth.cosmetics.commands;

import com.vulcanth.commons.commands.CommandsAbstract;
import com.vulcanth.cosmetics.commands.collections.CosmeticsCommand;

public class Command {

    @SuppressWarnings("unchecked")
    public static void setupCommands() {
        CommandsAbstract.setupComands(CosmeticsCommand.class);
    }

}
