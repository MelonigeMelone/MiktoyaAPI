package de.melonigemelone.miktoyaapi.listener;

import de.melonigemelone.miktoyaapi.api.coinssysteme.coins.CoinsAPI;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyAPI;
import de.melonigemelone.miktoyaapi.api.coinssysteme.rbx.RBXAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();

        CoinsAPI.loadCoinsDataFromDataBase(uuid);
        EconomyAPI.loadEconomyDataFromDataBase(uuid);
        RBXAPI.loadRBXDataFromDataBase(uuid);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();

        CoinsAPI.removeCoinsDataFromLocalStorgae(uuid);
        EconomyAPI.removeEconomyDataFromLocalStorgae(uuid);
        RBXAPI.removeRBXDataFromLocalStorgae(uuid);
    }
}
