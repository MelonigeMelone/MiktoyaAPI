package de.melonigemelone.miktoyaapi;

import de.melonigemelone.miktoyaapi.api.coinssysteme.coins.CoinsMySQL;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyImpl;
import de.melonigemelone.miktoyaapi.api.coinssysteme.economy.EconomyMySQL;
import de.melonigemelone.miktoyaapi.api.coinssysteme.rbx.RBXMySQL;
import de.melonigemelone.miktoyaapi.api.languagesystem.MultiLanguageMessage;
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
import org.bukkit.Bukkit;
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

    public static LanguageSystemAPI languageSystemAPI;
    public static GroupConfigHandler groupConfigHandler;

    @Override
    public void onEnable() {

        instance = this;

        if(detectPlugins()) {

            versionChecker = new VersionChecker();

            System.out.println("Minecraft Server Version " + VersionChecker.bukkitVersion.name() + " erkannt!");

            this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Miktoya");
            this.getServer().getMessenger().registerIncomingPluginChannel(this, "Miktoya", new BungeeCommunicationListener());

            bungeeCommunicationHandler = new BungeeCommunicationHandler();

            setupEconomy();
            setupPermissions();

            mySQLConfigHandler = new MySQLConfigHandler();

            playerDataMySQL = new PlayerDataMySQL();
            coinsMySQL = new CoinsMySQL();
            economyMySQL = new EconomyMySQL();
            rbxMySQL = new RBXMySQL();

            languageSystemGermanConfigHandler = new LanguageSystemGermanConfigHandler();
            languageSystemEnglischConfigHandler = new LanguageSystemEnglischConfigHandler();
            languageSystemAPI = new LanguageSystemAPI();


            groupConfigHandler = new GroupConfigHandler();

            initCommands();
            initListener();

            TCPExploitFixer.init();

        } else {
            Bukkit.getPluginManager().disablePlugin(this);
        }



    }

    @Override
    public void onDisable() {

    }

    public void initCommands() {

    }

    public void initListener() {

    }

    public static boolean detectPlugins() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            if (Bukkit.getPluginManager().getPlugin("LuckPerms") != null) {
                if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
                    return true;
                } else {
                    System.out.println("Das Plugin Vault fehlt! MiktoyaAPI wird deaktiviert!");
                    return false;
                }
            } else {
                System.out.println("Das Plugin LuckPerms fehlt! MiktoyaAPI wird deaktiviert!");
                return false;
            }
        } else {
            System.out.println("Das Plugin PlaceHolderAPI fehlt! MiktoyaAPI wird deaktiviert!");
            return false;
        }
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

    public static LanguageSystemAPI getLanguageSystemAPI() {
        return languageSystemAPI;
    }
}
