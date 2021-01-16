package de.melonigemelone.miktoyaapi.bungeecommunication;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.events.PlayerChangeLanguageEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BungeeCommunicationHandler {

    public BungeeCommunicationHandler() {

    }

    public void sendMessage(Player p, String message) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);
        try {
            out.writeUTF("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.sendPluginMessage(MiktoyaAPI.getInstance(), "Miktoya", stream.toByteArray());
    }

    public void doTaskFromMessage(String message) {
        if(message.contains("updateLanguage")) {
            String answer = message.substring(message.indexOf("(")+1,message.indexOf(")"));
            String[] split = answer.split(",");

            String uuid = split[0];
            String language = split[1];

            Player p = Bukkit.getPlayer(UUID.fromString(uuid));
            Language l = Language.valueOf(language);

            if(p != null && l != null) {
                PlayerChangeLanguageEvent playerChangeLanguageEvent = new PlayerChangeLanguageEvent(p, l);
                Bukkit.getPluginManager().callEvent(playerChangeLanguageEvent);
            }

        }
    }


}
