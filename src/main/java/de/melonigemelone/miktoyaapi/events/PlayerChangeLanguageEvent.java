package de.melonigemelone.miktoyaapi.events;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerChangeLanguageEvent extends Event {

    private final Player player;
    private final Language newLanguage;

    public PlayerChangeLanguageEvent(Player player, Language newLanguage) {
        this.player = player;
        this.newLanguage = newLanguage;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return player;
    }

    public Language getNewLanguage() {
        return newLanguage;
    }
}
