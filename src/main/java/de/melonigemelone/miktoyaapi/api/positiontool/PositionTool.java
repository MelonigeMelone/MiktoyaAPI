package de.melonigemelone.miktoyaapi.api.positiontool;

import de.melonigemelone.miktoyaapi.repository.lib.minecraft.itembuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class PositionTool {

    public static ItemStack getItemStack() {
        return new ItemBuilder(Material.STICK)
                .addGlow()
                .setDisplayName("")
                .setLore(Arrays.asList("", ""))
                .setUnbreakable(true)
                .build();
    }


}
