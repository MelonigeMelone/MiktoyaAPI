package de.melonigemelone.miktoyaapi.api.headdatabase;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.inventory.ItemStack;

public class HeadDataBaseAPI {

    public static HeadDatabaseAPI api = new HeadDatabaseAPI();

    public static ItemStack getHead(String id) {
        return api.getItemHead(id);
    }
}
