package de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.repository.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.repository.lib.packets.v1_8;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionbarBuilder {

    private String textGerman;
    private String textEnglisch;

    public ActionbarBuilder(String textGerman, String textEnglisch) {
        this.textGerman = textGerman;
        this.textEnglisch = textEnglisch;
    }

    public ActionbarBuilder send(Player p) {
        PlayerData playerData = PlayerDataAPI.getPlayerDataFromUUIDFromOlinePlayers(p.getUniqueId().toString());

        String text;
        if(playerData.getLanguage().equals(Language.ENGLISCH)) {
            text = textEnglisch;
        } else {
            text = textGerman;
        }
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendActionBar(p, text);
                break;
            case v1_16:
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(text));
                break;
        }
        return this;
    }
}
