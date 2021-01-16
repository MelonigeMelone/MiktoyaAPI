package de.melonigemelone.miktoyaapi.repository.lib.minecraft.itembuilder;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionBuilder extends ItemBuilder {
    private PotionMeta pm;

    public PotionBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public PotionBuilder(Material material, int amount) {
        super(material, amount);
    }

    public PotionBuilder addCustomEffect(PotionEffectType type, int duration, int amplifier) {
        this.pm = (PotionMeta)this.is.getItemMeta();
        PotionEffect effect = new PotionEffect(type, duration, amplifier, true);
        this.pm.addCustomEffect(effect, true);
        this.is.setItemMeta((ItemMeta)this.pm);
        return this;
    }
}

