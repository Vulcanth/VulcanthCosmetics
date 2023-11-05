package com.vulcanth.cosmetics.cosmetics.collections.closet.collections;

import com.vulcanth.commons.utils.BukkitUtils;
import com.vulcanth.cosmetics.cosmetics.collections.closet.ArmorPart;
import com.vulcanth.cosmetics.cosmetics.collections.closet.ArmorPartType;
import com.vulcanth.cosmetics.cosmetics.collections.closet.Closet;

public class RGBArmor extends Closet {

    public RGBArmor() {
        super("0");
    }

    @Override
    public Closet setupContent() {
        registerNewPart(new ArmorPart(ArmorPartType.HELMET, BukkitUtils.getItemStackFromString("298 : 1 : nome>&aCapacete de Couro : desc>&7Caminhe com estilo em nossos\n&7lobbies com a roupa RGB\n \n&eClique para selecionar"), BukkitUtils.getItemStackFromString("298 : 1 : nome>&aCapacete de Couro"), true, true));
        registerNewPart(new ArmorPart(ArmorPartType.CHESTPLATE, BukkitUtils.getItemStackFromString("299 : 1 : nome>&aPeitoral de Couro : desc>&7Caminhe com estilo em nossos\n&7lobbies com a roupa RGB\n \n&eClique para selecionar"), BukkitUtils.getItemStackFromString("299 : 1 : nome>&aPeitoral de Couro"), true, true));
        registerNewPart(new ArmorPart(ArmorPartType.LEGGINS, BukkitUtils.getItemStackFromString("300 : 1 : nome>&aCalça de Couro : desc>&7Caminhe com estilo em nossos\n&7lobbies com a roupa RGB\n \n&eClique para selecionar"), BukkitUtils.getItemStackFromString("300 : 1 : nome>&aCalça de Couro"), true, true));
        registerNewPart(new ArmorPart(ArmorPartType.BOOTS, BukkitUtils.getItemStackFromString("301 : 1 : nome>&aBota de Couro : desc>&7Caminhe com estilo em nossos\n&7lobbies com a roupa RGB\n \n&eClique para selecionar"), BukkitUtils.getItemStackFromString("301 : 1 : nome>&aBota de Couro"), true, true));

        return this;
    }

}
