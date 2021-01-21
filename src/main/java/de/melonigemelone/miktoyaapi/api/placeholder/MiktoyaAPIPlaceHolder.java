package de.melonigemelone.miktoyaapi.api.placeholder;

import de.melonigemelone.miktoyaapi.api.vault.groups.GroupAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

//TODO Add PlaceHolders

public class MiktoyaAPIPlaceHolder extends PlaceholderExpansion {

    /*
    The identifier, shouldn't contain any _ or %
     */
    public String getIdentifier() {
        return "miktoya";
    }

    /*
     The author of the Placeholder
     This cannot be null
     */
    public String getAuthor() {
        return "MelonigeMelone";
    }

    /*
     Same with #getAuthor() but for versioon
     This cannot be null
     */

    public String getVersion() {
        return "1.0";
    }

    /*
    Use this method to setup placeholders
    This is somewhat similar to EZPlaceholderhook
     */
    public String onPlaceholderRequest(Player player, String identifier) {
        /*
         %tutorial_onlines%
         Returns the number of online players
          */
        if(identifier.equalsIgnoreCase("onlines")){
            return String.valueOf(Bukkit.getOnlinePlayers().size());
        }

        /*
        Check if the player is online,
        You should do this before doing anything regarding players
         */
        if(player == null){
            return null;
        }

        /*
        %tutorial_name%
        Returns the player name
         */
        if(identifier.equalsIgnoreCase("rbx")){
        }

        if(identifier.equalsIgnoreCase("coins")){
        }

        if(identifier.equalsIgnoreCase("money")){
        }

        if(identifier.equalsIgnoreCase("firstJoin")){
            return player.getName();
        }

        if(identifier.equalsIgnoreCase("playtime")){
            return "";
        }

        if(identifier.equalsIgnoreCase("group")){
            return GroupAPI.getGroupFromPlayer(player).getSbName();
        }


        return null;
    }
}
