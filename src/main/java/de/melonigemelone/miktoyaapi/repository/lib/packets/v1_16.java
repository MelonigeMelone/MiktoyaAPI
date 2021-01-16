package de.melonigemelone.miktoyaapi.repository.lib.packets;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class v1_16 {

    public static void sendClickableMessage(Player p, String textpart, String clickabletext, String runcommand) {
        TextComponent tc = new TextComponent(textpart + " ");
        TextComponent clickable = new TextComponent(clickabletext);
        clickable.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, runcommand));
        tc.addExtra(clickable);
        
        p.spigot().sendMessage(tc);
    }

    public static void sendHoverableMessage(Player p, String textpart, String hoverabletext, String hovertext) {
        TextComponent tc = new TextComponent(textpart + " ");
        TextComponent hoverable = new TextComponent(hoverabletext);
        hoverable.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovertext).create()));
        tc.addExtra(hoverable);

        p.spigot().sendMessage(tc);
    }

    public static void sendClickableHoverableMessage(Player p, String textpart, String clickabletext, String hovertext, String runcommand) {
        TextComponent tc = new TextComponent(textpart + " ");
        TextComponent clickable = new TextComponent(clickabletext);

        clickable.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovertext).create()));
        clickable.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, runcommand));

        tc.addExtra(clickable);

        p.spigot().sendMessage(tc);
    }



}
