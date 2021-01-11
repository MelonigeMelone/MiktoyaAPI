package de.melonigemelone.miktoyaapi.lib.packets;

import org.bukkit.Bukkit;

public class VersionChecker {
    public static BukkitVersion getBukkitVersion() {
        if (Bukkit.getVersion().contains("(MC: 1.8.8)") )
            return BukkitVersion.v1_8;
        if (Bukkit.getVersion().contains("(MC: 1.16)") || Bukkit.getVersion().contains("(MC: 1.16.1)") || Bukkit.getVersion().contains("(MC: 1.16.2)") || Bukkit.getVersion().contains("(MC: 1.16.3)") || Bukkit.getVersion().contains("(MC: 1.16.4)"))
            return BukkitVersion.v1_16;

        return null;
    }

    public enum BukkitVersion {
        v1_8, v1_16;
    }
}
