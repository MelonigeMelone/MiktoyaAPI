package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import org.bukkit.entity.Player;

/**
 * Dient dazu Messages dem LanguageSystem hinzuzufügen und zu getten
 *
 * @author  MelonigeMelone
 * @version 1.0
 * @since   2021-01-11
 */

public class LanguageSystemAPI {

    //Fügt eine Nachircht den LanguageSystem hinzu
    //Bitte immer folgendes Format verwenden !!PUNKT NUR NACH DEM PLUGINNAME!! (PluginName.Identifier_Identifier, Bsp. MiktoyaAPI.Start_Message)
    public static void addMessage(String name, String defaultGerman, String defaultEnglisch) {
        MiktoyaAPI.getLanguageSystemGermanConfigHandler().setIfNotExists(name, defaultGerman);
        MiktoyaAPI.getLanguageSystemEnglischConfigHandler().setIfNotExists(name, defaultEnglisch);

        MiktoyaAPI.getLanguageSystemGermanConfigHandler().save();;
        MiktoyaAPI.getLanguageSystemEnglischConfigHandler().save();;
    }

    //Gibt eine Nachricht zurück anhand der Sprache des Spielers
    public static String getMessage(String name, Player player, boolean replaceFarbCodes) {
        return getMessage(name, PlayerDataAPI.getPlayerDataFromUUID(player.getUniqueId().toString()).getLanguage(), replaceFarbCodes);
    }

    //Gibt eine Nachricht zurück
    public static String getMessage(String name, Language language, boolean replaceFarbCodes) {
        if(language.equals(Language.GERMAN)) {
            if(replaceFarbCodes) {
                return MiktoyaAPI.getLanguageSystemGermanConfigHandler().getString(name).replaceAll("&", "§");
            } else {
                return MiktoyaAPI.getLanguageSystemGermanConfigHandler().getString(name);
            }
        } else {
            if(replaceFarbCodes) {
                return MiktoyaAPI.getLanguageSystemEnglischConfigHandler().getString(name).replaceAll("&", "§");
            } else {
                return MiktoyaAPI.getLanguageSystemEnglischConfigHandler().getString(name);
            }
        }
    }

    public static String getPrefix(boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.Prefix", Language.GERMAN, replaceFarbCodes);
    }

    public static String getOnlyPlayers(boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.Only_Players", Language.GERMAN, replaceFarbCodes);
    }

    public static String getNoPerm(Player p, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.No_Perm", p, replaceFarbCodes);
    }

    public static String getNoPerm(Language language, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.No_Perm", language, replaceFarbCodes);
    }

    public static String getNoPlayerFound(Player p, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.No_Player_Found", p, replaceFarbCodes);
    }

    public static String getNoPlayerFound(Language language, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.No_Player_Found", language, replaceFarbCodes);
    }

    public static String getUseCommand(Player p, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.Use_Cmd", p, replaceFarbCodes);
    }

    public static String getUseCommand(Language language, boolean replaceFarbCodes) {
        return getMessage("MiktoyaAPI.Use_Cmd", language, replaceFarbCodes);
    }
}
