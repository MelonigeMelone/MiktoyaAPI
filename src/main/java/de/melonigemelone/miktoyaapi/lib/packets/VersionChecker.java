package de.melonigemelone.miktoyaapi.lib.packets;

import org.bukkit.Bukkit;

public class VersionChecker {

    public static BukkitVersion bukkitVersion = null;

    public VersionChecker() {
        bukkitVersion = getBukkitVersion();
    }

    public static BukkitVersion getBukkitVersion() {
        if(bukkitVersion != null) {
            return bukkitVersion;
        }

        if (Bukkit.getVersion().contains("(MC: 1.8.8)")) {
            return BukkitVersion.v1_8;
        } else if (Bukkit.getVersion().contains("(MC: 1.16)") || Bukkit.getVersion().contains("(MC: 1.16.1)") || Bukkit.getVersion().contains("(MC: 1.16.2)") || Bukkit.getVersion().contains("(MC: 1.16.3)") || Bukkit.getVersion().contains("(MC: 1.16.4)") || Bukkit.getVersion().contains("(MC: 1.16.5)")) {
            return BukkitVersion.v1_16;
        }
        return null;
    }

    public enum BukkitVersion {
        v1_8, v1_16;
    }
}
