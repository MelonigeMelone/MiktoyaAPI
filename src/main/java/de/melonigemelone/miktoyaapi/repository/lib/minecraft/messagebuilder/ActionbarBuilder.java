package de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder;

import de.melonigemelone.miktoyaapi.repository.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.repository.lib.packets.v1_8;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(this.text));
                break;
        }
        return this;
    }
}
