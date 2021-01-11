package de.melonigemelone.miktoyaapi.bungeecommunication;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class BungeeCommunicationListener  implements PluginMessageListener {

    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (!channel.equals("Miktoya")) {
            return;
        }

        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        DataInputStream in = new DataInputStream(stream);
        try {
            MiktoyaAPI.getBungeeCommunicationHandler().doTaskFromMessage(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
