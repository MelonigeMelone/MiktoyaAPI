package de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.repository.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.repository.lib.packets.v1_8;
import org.bukkit.entity.Player;

public class TablistAPI {

    public static TablistData tablistData;

    public static void send(Player p) {
        if(tablistData !=null) {
            PlayerData playerData = PlayerDataAPI.getPlayerDataFromUUIDFromOlinePlayers(p.getUniqueId().toString());

            String header;
            String footer;

            if(playerData.getLanguage().equals(Language.ENGLISCH)) {
                header = tablistData.getEnglischHeader();
                footer = tablistData.getEnglischFooter();
            } else {
                header = tablistData.getGermanHeader();
                footer = tablistData.getGermanFooter();
            }

            switch (VersionChecker.getBukkitVersion()) {
                case v1_8:
                    v1_8.sendTablist(p, header, footer);
                    break;
                case v1_16:
                    p.setPlayerListHeaderFooter(header, footer);
                    break;
            }
        }

    }

    public static void setTablistData(TablistData tablistData) {
        TablistAPI.tablistData = tablistData;
    }
}
