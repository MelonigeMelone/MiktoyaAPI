package de.melonigemelone.miktoyaapi.lib.minecraft.messagebuilder;

import de.melonigemelone.miktoyaapi.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.lib.packets.v1_8;
import org.bukkit.entity.Player;

public class ActionbarBuilder {
    private String text;

    public ActionbarBuilder(String text) {
        this.text = text;
    }

    public ActionbarBuilder send(Player p) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendActionBar(p, this.text);
                break;

            case v1_16:
                break;
        }
        return this;
    }
}
