package de.melonigemelone.miktoyaapi.api.vault.groups;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml.YamlFileBuilder;

public class GroupConfigHandler extends YamlFileBuilder {

    public GroupConfigHandler() {
        super(MiktoyaAPI.getInstance().getDataFolder() + "/Groups", "groups.yml");

        createFile();
        loadGroups();
    }

    public void createFile() {

        for(String group : MiktoyaAPI.getPermission().getGroups()) {
            setIfNotExists("GROUP." + group + ".Chat.Prefix", "&e" + group + " ");
            setIfNotExists("GROUP." + group + ".Chat.Suffix", "");
            setIfNotExists("GROUP." + group + ".Chat.NameColors", "&7");
            setIfNotExists("GROUP." + group + ".Chat.Format", "%displayname% &8&l-> &7%message%");

            setIfNotExists("GROUP." + group + ".Tab.Prefix", "&e" + group + " &7");
            setIfNotExists("GROUP." + group + ".Tab.Suffix", "");
            setIfNotExists("GROUP." + group + ".Tab.NameColors", "&7");
            setIfNotExists("GROUP." + group + ".Tab.Rank", "01" + group);

            setIfNotExists("GROUP." + group + ".ScoreBoard.DisplayName", "&e" + group);

        }

        save();

    }

    public void loadGroups() {
        for(String key : getConfigurationSection("GROUP").getKeys(false)){
            String chatPrefix = getString("GROUP." + key + ".Chat.Prefix").replaceAll("&", "§");
            String chatSuffix = getString("GROUP." + key + ".Chat.Suffix").replaceAll("&", "§");
            String[] chatNameColors = getString("GROUP." + key + ".Chat.NameColors").replaceAll("&", "§").split(",");
            String chatFormat = getString("GROUP." + key + ".Chat.Format").replaceAll("&", "§");

            String tabPrefix = getString("GROUP." + key + ".Tab.Prefix").replaceAll("&", "§");
            String tabSuffix = getString("GROUP." + key + ".Tab.Suffix").replaceAll("&", "§");
            String[] tabNameColors = getString("GROUP." + key + ".Tab.NameColors").replaceAll("&", "§").split(",");
            String tabRank = getString("GROUP." + key + ".Tab.Rank");

            String sbDisplayName =   getString("GROUP." + key + ".ScoreBoard.DisplayName");

            GroupAPI.loadedGroups.add(new Group(key, chatPrefix, chatSuffix, chatNameColors, chatFormat,
                    tabPrefix, tabSuffix, tabNameColors, tabRank, sbDisplayName));

        }
    }

}
