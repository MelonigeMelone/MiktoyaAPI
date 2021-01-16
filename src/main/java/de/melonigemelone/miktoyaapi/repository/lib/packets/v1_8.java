package de.melonigemelone.miktoyaapi.repository.lib.packets;

import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EnumDifficulty;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutRespawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.WorldSettings;
import net.minecraft.server.v1_8_R3.WorldType;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class v1_8 {
    public static void sendClickableHoverableMessage(Player p, String textpart, String clickabletext, String hovertext, String runcommand) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + textpart + "\",\"extra\":" +
                "[{\"text\":\"" + clickabletext + "\",\"hoverEvent\":{\"action\":\"show_text\", " +
                "\"value\":\"" + hovertext + "\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":" +
                "\"/" + runcommand + "\"}}]}"));
        sendPacket(p, (Packet<?>)packet);
    }

    public static void sendHoverableMessage(Player p, String textpart, String hoverabletext, String hovertext) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + textpart + "\",\"extra\":" +
                "[{\"text\":\"" + hoverabletext + "\",\"hoverEvent\":{\"action\":\"show_text\", " +
                "\"value\":\"" + hovertext + "\"}}]}"));
        sendPacket(p, (Packet<?>)packet);
    }

    public static void sendClickableMessage(Player p, String textpart, String clickabletext, String runcommand) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + textpart + "\",\"extra\":" +
                "[{\"text\":\"" + clickabletext + "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":" +
                "\"/" + runcommand + "\"}}]}"));
        sendPacket(p, (Packet<?>)packet);
    }

    public static void sendActionBar(Player p, String text) {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\"}"), (byte)2);
        sendPacket(p, (Packet<?>)packet);
    }

    public static void sendTitle(Player p, String title, int fadeintitle, int staytitle, int fadeouttitle, String subtitle, int fadeinsub, int staysub, int fadeoutsub) {
        PacketPlayOutTitle packet1 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}"), fadeintitle, staytitle, fadeouttitle);
        PacketPlayOutTitle packet2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}"), fadeinsub, staysub, fadeoutsub);
        PacketPlayOutTitle packet3 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}"));
        PacketPlayOutTitle packet4 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}"));
        sendPacket(p, (Packet<?>)packet1);
        sendPacket(p, (Packet<?>)packet2);
        sendPacket(p, (Packet<?>)packet3);
        sendPacket(p, (Packet<?>)packet4);
    }

    public static void sendTablist(Player p, String header, String footer) {
        IChatBaseComponent tabheader = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + header + "\"}");
        IChatBaseComponent tabfooter = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + footer + "\"}");
        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabheader);
        try {
            Field f = packet.getClass().getDeclaredField("b");
            f.setAccessible(true);
            f.set(packet, tabfooter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sendPacket(p, (Packet<?>)packet);
        }
    }

    public static int getPing(Player p) {
        EntityPlayer ep = ((CraftPlayer)p).getHandle();
        return ep.ping;
    }

    private static void sendPacket(Player player, Packet<?> packet) {
        (((CraftPlayer)player).getHandle()).playerConnection.sendPacket(packet);
    }

    public static void respawn(Player player, boolean kill) {
        if (kill) {
            (((CraftPlayer)player).getHandle()).playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
        } else {
            PacketPlayOutRespawn packet = new PacketPlayOutRespawn(((CraftPlayer)player).getWorld().getEnvironment().getId(), EnumDifficulty.getById(((CraftPlayer)player).getWorld().getDifficulty().getValue()), WorldType.getType(((CraftPlayer)player).getWorld().getWorldType().getName()), WorldSettings.EnumGamemode.getById(((CraftPlayer)player).getGameMode().getValue()));
            sendPacket(player, (Packet<?>)packet);
        }
    }
}

