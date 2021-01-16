package de.melonigemelone.miktoyaapi.lib.packets;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.awt.*;
import java.lang.reflect.Field;

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
