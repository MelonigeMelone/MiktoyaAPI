package de.melonigemelone.miktoyaapi.api.vanish;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishAPI {

    public static List<PlayerData> playerInVanish = new ArrayList<>();

    public static void addPlayerToVanish(PlayerData playerData) {
        Player p = playerData.getPlayer();

        p.setAllowFlight(true);
        p.setFlying(true);

        for (Player t : Bukkit.getOnlinePlayers()) {
            t.hidePlayer(p);
        }

        playerData.setVanish(true);
        playerInVanish.add(playerData);

    }

    public static void removePlayerFromVanish(PlayerData playerData) {
        Player p = playerData.getPlayer();

        p.setAllowFlight(false);
        p.setFlying(false);

        for(Player t : Bukkit.getOnlinePlayers()) {
            t.showPlayer(p);
        }

        playerData.setVanish(false);
        playerInVanish.remove(playerData);
    }

    public static void handlePlayerJoined(Player p) {
        for(PlayerData playerData : playerInVanish) {
            System.out.println("Test");
            p.hidePlayer(playerData.getPlayer());
        }
    }
}
