package de.melonigemelone.miktoyaapi.lib.minecraft.messagebuilder;

import de.melonigemelone.miktoyaapi.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.lib.packets.v1_8;
import org.bukkit.entity.Player;

public class ChatMessageBuilder {
    public ChatMessageBuilder sendClickableHoverableMessage(Player p, String textpart, String clickabletext, String hovertext, String runcommand) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendClickableHoverableMessage(p, textpart, clickabletext, hovertext, runcommand);
                break;
            case v1_16:
                break;
        }
        return this;
    }

    public ChatMessageBuilder sendHoverableMessage(Player p, String textpart, String hoverabletext, String hovertext) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendHoverableMessage(p, textpart, hoverabletext, hovertext);
                break;
            case v1_16:
                break;

        }
        return this;
    }

    public ChatMessageBuilder sendClickableMessage(Player p, String textpart, String clickabletext, String runcommand) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendClickableMessage(p, textpart, clickabletext, runcommand);
                break;
            case v1_16:
                break;
        }
        return this;
    }
}
