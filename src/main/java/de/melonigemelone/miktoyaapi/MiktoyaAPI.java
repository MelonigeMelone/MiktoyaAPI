package de.melonigemelone.miktoyaapi;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemEnglischConfigHandler;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemGermanConfigHandler;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataMySQL;
import de.melonigemelone.miktoyaapi.bungeecommunication.BungeeCommunicationHandler;
import de.melonigemelone.miktoyaapi.bungeecommunication.BungeeCommunicationListener;
import de.melonigemelone.miktoyaapi.mysql.MySQLConfigHandler;
import de.melonigemelone.miktoyaapi.tcpexploitfixer.TCPExploitFixer;
import org.bukkit.plugin.java.JavaPlugin;

public class MiktoyaAPI extends JavaPlugin {

    public static MiktoyaAPI intsance;

    public static BungeeCommunicationHandler bungeeCommunicationHandler;

    public static MySQLConfigHandler mySQLConfigHandler;

    public static PlayerDataMySQL playerDataMySQL;

    public static LanguageSystemGermanConfigHandler languageSystemGermanConfigHandler;
    public static LanguageSystemEnglischConfigHandler languageSystemEnglischConfigHandler;

    @Override
    public void onEnable() {

        intsance = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Miktoya");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "Miktoya", new BungeeCommunicationListener());

        bungeeCommunicationHandler = new BungeeCommunicationHandler();

        mySQLConfigHandler = new MySQLConfigHandler();

        playerDataMySQL = new PlayerDataMySQL();

        languageSystemGermanConfigHandler = new LanguageSystemGermanConfigHandler();
        languageSystemEnglischConfigHandler = new LanguageSystemEnglischConfigHandler();

        initCommands();
        initListener();
        initDefaultMessages();

        TCPExploitFixer.init();

    }

    @Override
    public void onDisable() {

    }

    public void initCommands() {

    }

    public void initListener() {

    }

    public void initDefaultMessages() {
        LanguageSystemAPI.addMessage("MiktoyaAPI.Prefix", "&8[&eMiktoya&8]", "&8[&eMiktoya&8]");
        LanguageSystemAPI.addMessage("MiktoyaAPI.Only_Players", "&8[&eMiktoya&8] &cDer Befehl ist nur für Spieler!", "&8[&eMiktoya&8] &cDer Befehl ist nur für Spieler!");

        LanguageSystemAPI.addMessage("MiktoyaAPI.No_Perm", "&8[&eMiktoya&8] &cDazu hast du keine Rechte!", "&8[&eMiktoya&8] &cNo permissions!");
        LanguageSystemAPI.addMessage("MiktoyaAPI.No_Player_Found", "&8[&eMiktoya&8] &cEs wurde kein Spieler mit diesem Namen gefunden!", "&8[&eMiktoya&8] &cNo player with such a name was found!");
        LanguageSystemAPI.addMessage("MiktoyaAPI.Use_Cmd", "&8[&eMiktoya&8] &cNutze: &7%command%", "&8[&eMiktoya&8] &cUse: &7%command%");

    }


    public static MiktoyaAPI getIntsance() {
        return intsance;
    }

    public static BungeeCommunicationHandler getBungeeCommunicationHandler() {
        return bungeeCommunicationHandler;
    }

    public static MySQLConfigHandler getMySQLConfigHandler() {
        return mySQLConfigHandler;
    }

    public static PlayerDataMySQL getPlayerDataMySQL() {
        return playerDataMySQL;
    }

    public static LanguageSystemGermanConfigHandler getLanguageSystemGermanConfigHandler() {
        return languageSystemGermanConfigHandler;
    }

    public static LanguageSystemEnglischConfigHandler getLanguageSystemEnglischConfigHandler() {
        return languageSystemEnglischConfigHandler;
    }
}
