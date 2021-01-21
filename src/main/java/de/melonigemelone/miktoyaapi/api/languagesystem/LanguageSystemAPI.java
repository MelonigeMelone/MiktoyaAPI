package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

/**
 * Dient dazu Messages dem LanguageSystem hinzuzufügen und zu getten
 *
 * @author  MelonigeMelone
 * @version 1.0
 * @since   2021-01-11
 */

public class LanguageSystemAPI {

    public static MultiLanguageMessage prefix;
    public static MultiLanguageMessage onlyPlayers;
    public static MultiLanguageMessage noPerm;
    public static MultiLanguageMessage noPlayerFound;
    public static MultiLanguageMessage useCmd;

    public LanguageSystemAPI() {
    }


    //Fügt eine Nachircht den LanguageSystem hinzu und lädt sie in die HashMap
    //Bitte immer folgendes Format verwenden !!PUNKT NUR NACH DEM PLUGINNAME!! (PluginName.Identifier_Identifier, Bsp. MiktoyaAPI.Start_Message)
    public void addMessage(MultiLanguageMessage multiLanguageMessage) {
        String identifier = multiLanguageMessage.getIdentifier();

        MiktoyaAPI.getLanguageSystemGermanConfigHandler().setIfNotExistsAndSave(identifier, multiLanguageMessage.getDefaultGermanMessage());
        MiktoyaAPI.getLanguageSystemEnglischConfigHandler().setIfNotExistsAndSave(identifier, multiLanguageMessage.getDefaultEnglischMessage());

        multiLanguageMessage.setEnglischMessage(MiktoyaAPI.getLanguageSystemEnglischConfigHandler().getString(identifier));
        multiLanguageMessage.setGermanMessage(MiktoyaAPI.getLanguageSystemGermanConfigHandler().getString(identifier));

    }

    public void initDefaultMessages() {
        prefix = new MultiLanguageMessage("MiktoyaAPI.Prefix",
                "&8[&eMiktoya&8] ",
                "&8[&eMiktoya&8] ");


        onlyPlayers = new MultiLanguageMessage("MiktoyaAPI.Only_Players",
                "&cDer Befehl ist nur für Spieler!",
                "&cThe command is only for players!");

        noPerm = new MultiLanguageMessage("MiktoyaAPI.No_Perm",
                "&8[&eMiktoya&8] &cDazu hast du keine Rechte!",
                "&8[&eMiktoya&8] &cNo permissions!");

        noPlayerFound = new MultiLanguageMessage("MiktoyaAPI.No_Player_Found",
                "&8[&eMiktoya&8] &cEs wurde kein Spieler mit diesem Namen gefunden!",
                "&8[&eMiktoya&8] &cNo player with such a name was found!");

        useCmd = new MultiLanguageMessage("MiktoyaAPI.Use_Cmd",
                "&8[&eMiktoya&8] &cNutze: &7%command%",
                "&8[&eMiktoya&8] &cUse: &7%command%");

    }

    public static MultiLanguageMessage getNoPerm() {
        return noPerm;
    }

    public static MultiLanguageMessage getNoPlayerFound() {
        return noPlayerFound;
    }

    public static MultiLanguageMessage getOnlyPlayers() {
        return onlyPlayers;
    }

    public static MultiLanguageMessage getPrefix() {
        return prefix;
    }

    public static MultiLanguageMessage getUseCmd() {
        return useCmd;
    }
}
