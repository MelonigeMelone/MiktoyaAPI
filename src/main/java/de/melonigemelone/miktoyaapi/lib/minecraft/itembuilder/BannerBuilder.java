package de.melonigemelone.miktoyaapi.lib.minecraft.itembuilder;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class BannerBuilder extends ItemBuilder {
    private BannerMeta bm;

    public BannerBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public BannerBuilder(Material material, int amount) {
        super(material, amount);
    }

    @Deprecated
    public BannerBuilder setBaseColor(DyeColor color) {
        this.bm = (BannerMeta)this.is.getItemMeta();
        this.bm.setBaseColor(color);
        this.is.setItemMeta((ItemMeta)this.bm);
        return this;
    }

    public BannerBuilder addPattern(DyeColor color, PatternType pattern) {
        this.bm = (BannerMeta)this.is.getItemMeta();
        this.bm.addPattern(new Pattern(color, pattern));
        this.is.setItemMeta((ItemMeta)this.bm);
        return this;
    }
}
