package de.melonigemelone.miktoyaapi.lib.minecraft.messagebuilder;


import de.melonigemelone.miktoyaapi.lib.packets.VersionChecker;
import de.melonigemelone.miktoyaapi.lib.packets.v1_8;
import org.bukkit.entity.Player;

public class TitleBuilder {
    private String title;

    private String subtitle;

    private int titleFadeIn;

    private int titleStay;

    private int titleFadeOut;

    private int subFadeIn;

    private int subStay;

    private int subFadeOut;

    public TitleBuilder(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public TitleBuilder setTimings(int titleFadeIn, int titleStay, int titleFadeOut, int subFadeIn, int subStay, int subFadeOut) {
        this.titleFadeIn = titleFadeIn;
        this.titleStay = titleStay;
        this.titleFadeOut = titleFadeOut;
        this.subFadeIn = subFadeIn;
        this.subStay = subStay;
        this.subFadeOut = subFadeOut;
        return this;
    }

    public TitleBuilder send(Player p) {
        switch (VersionChecker.getBukkitVersion()) {
            case v1_8:
                v1_8.sendTitle(p, this.title, this.titleFadeIn, this.titleStay, this.titleFadeOut, this.subtitle, this.subFadeIn, this.subStay, this.subFadeOut);
                break;
            case v1_16:
                break;
        }
        return this;
    }
}
