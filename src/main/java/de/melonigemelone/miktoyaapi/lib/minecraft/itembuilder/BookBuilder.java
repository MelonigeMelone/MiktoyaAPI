package de.melonigemelone.miktoyaapi.lib.minecraft.itembuilder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BookBuilder extends ItemBuilder {
    private BookMeta bm;

    public BookBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public BookBuilder(int amount) {
        super(Material.WRITTEN_BOOK, amount);
    }

    public BookBuilder setAuthor(String name) {
        this.bm = (BookMeta)this.is.getItemMeta();
        this.bm.setAuthor(name);
        this.is.setItemMeta((ItemMeta)this.bm);
        return this;
    }

    public BookBuilder addPage(String content) {
        this.bm = (BookMeta)this.is.getItemMeta();
        this.bm.addPage(new String[] { content });
        this.is.setItemMeta((ItemMeta) this.bm);
        return this;
    }

    public BookBuilder addPages(List<String> contents) {
        this.bm = (BookMeta)this.is.getItemMeta();
        for (String content : contents) {
            this.bm.addPage(new String[] { content });
        }
        this.is.setItemMeta((ItemMeta)this.bm);
        return this;
    }

    public int getPageCount() {
        return this.bm.getPageCount();
    }
}
