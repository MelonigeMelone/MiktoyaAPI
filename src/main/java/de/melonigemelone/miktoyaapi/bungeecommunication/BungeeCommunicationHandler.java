package de.melonigemelone.miktoyaapi.bungeecommunication;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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

        }
    }
}
