package de.melonigemelone.miktoyaapi.lib.minecraft.itembuilder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder extends ItemBuilder {
    private SkullMeta sm;

    public SkullBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public SkullBuilder(Material material, int amount) {
        super(material, amount);
    }

    public SkullBuilder setOwner(String owner) {
        this.sm = (SkullMeta) this.is.getItemMeta();
        this.sm.setOwner(owner);
        this.is.setItemMeta((ItemMeta) this.sm);
        return this;
    }
}
