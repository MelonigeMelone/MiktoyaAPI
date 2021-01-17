package de.melonigemelone.miktoyaapi.api.positiontool;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PositionToolAPI {

    public static HashMap<Player, Location> pos1 = new HashMap<>();

    public static HashMap<Player, Location> pos2 = new HashMap<>();

    public static Location getLocationPos1(Player p) {
        return pos1.get(p);
    }

    public static Location getLocationPos2(Player p) {
        return pos1.get(p);
    }


}
