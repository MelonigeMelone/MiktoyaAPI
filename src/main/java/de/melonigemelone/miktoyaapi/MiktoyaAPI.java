package de.melonigemelone.miktoyaapi;

import de.melonigemelone.miktoyaapi.api.coinssysteme.coins.CoinsMySQL;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyImpl;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyMySQL;
import de.melonigemelone.miktoyaapi.api.coinssysteme.rbx.RBXMySQL;
import de.melonigemelone.miktoyaapi.api.languagesystem.config.LanguageSystemEnglischConfigHandler;
import de.melonigemelone.miktoyaapi.api.languagesystem.config.LanguageSystemGermanConfigHandler;
import de.melonigemelone.miktoyaapi.api.languagesystem.LanguageSystemAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataMySQL;
import de.melonigemelone.miktoyaapi.api.vault.groups.GroupConfigHandler;
import de.melonigemelone.miktoyaapi.bungeecommunication.BungeeCommunicationHandler;
import de.melonigemelone.miktoyaapi.bungeecommunication.BungeeCommunicationListener;
import de.melonigemelone.miktoyaapi.repository.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.repository.config.mysql.MySQLConfigHandler;
import de.melonigemelone.miktoyaapi.tcpexploitfixer.TCPExploitFixer;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class MiktoyaAPI extends JavaPlugin {

    public static MiktoyaAPI instance;

    //BungeeCommunication
    public static BungeeCommunicationHandler bungeeCommunicationHandler;

    public static VersionChecker versionChecker;

    //Vault
    public static Permission permission;
    public static Economy economy;

    //MySQL-Values
    public static MySQLConfigHandler mySQLConfigHandler;

    //MySQL-Manager
    public static PlayerDataMySQL playerDataMySQL;
    public static CoinsMySQL coinsMySQL;
    public static EconomyMySQL economyMySQL;
    public static RBXMySQL rbxMySQL;

    //Manager
    public static LanguageSystemGermanConfigHandler languageSystemGermanConfigHandler;
    public static LanguageSystemEnglischConfigHandler languageSystemEnglischConfigHandler;
    public static GroupConfigHandler groupConfigHandler;

    @Override
    public void onEnable() {

        instance = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Miktoya");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "Miktoya", new BungeeCommunicationListener());

        bungeeCommunicationHandler = new BungeeCommunicationHandler();

        versionChecker = new VersionChecker();

        System.out.println("Minecraft Server Version " + VersionChecker.bukkitVersion.name() + " erkannt!");

        setupEconomy();
        setupPermissions();

        mySQLConfigHandler = new MySQLConfigHandler();

        playerDataMySQL = new PlayerDataMySQL();
        coinsMySQL = new CoinsMySQL();
        economyMySQL = new EconomyMySQL();
        rbxMySQL = new RBXMySQL();

        languageSystemGermanConfigHandler = new LanguageSystemGermanConfigHandler();
        languageSystemEnglischConfigHandler = new LanguageSystemEnglischConfigHandler();
        groupConfigHandler = new GroupConfigHandler();

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

    private void setupEconomy() {
        economy = new EconomyImpl();
        getServer().getServicesManager().register(net.milkbowl.vault.economy.Economy.class,economy,this, ServicePriority.High);
    }

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        permission = rsp.getProvider();
    }

    public static MiktoyaAPI getInstance() {
        return instance;
    }

    public static BungeeCommunicationHandler getBungeeCommunicationHandler() {
        return bungeeCommunicationHandler;
    }

    public static Permission getPermission() {
        return permission;
    }

    public static MySQLConfigHandler getMySQLConfigHandler() {
        return mySQLConfigHandler;
    }

    public static PlayerDataMySQL getPlayerDataMySQL() {
        return playerDataMySQL;
    }

    public static CoinsMySQL getCoinsMySQL() {
        return coinsMySQL;
    }

    public static RBXMySQL getRbxMySQL() {
        return rbxMySQL;
    }

    public static EconomyMySQL getEconomyMySQL() {
        return economyMySQL;
    }

    public static LanguageSystemGermanConfigHandler getLanguageSystemGermanConfigHandler() {
        return languageSystemGermanConfigHandler;
    }

    public static LanguageSystemEnglischConfigHandler getLanguageSystemEnglischConfigHandler() {
        return languageSystemEnglischConfigHandler;
    }
}
