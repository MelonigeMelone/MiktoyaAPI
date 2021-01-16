package de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder;

import de.melonigemelone.miktoyaapi.repository.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.repository.lib.packets.v1_8;
import org.bukkit.entity.Player;

public class TablistBuilder {

    private String header;

    private String footer;

    public TablistBuilder(String header, String footer) {
        this.header = header;
        this.footer = footer;
    }

    public TablistBuilder send(Player p) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendTablist(p, this.header, this.footer);
                break;
            case v1_16:
                p.setPlayerListHeaderFooter(this.header, this.footer);
                break;
        }
        return this;
    }
}
