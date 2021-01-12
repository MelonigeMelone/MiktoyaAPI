package de.melonigemelone.miktoyaapi.api.vault.groups;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GroupAPI {

    public static Permission permission = MiktoyaAPI.getPermission();

    public static List<Group> loadedGroups = new ArrayList<>();

    public static Group getGroupFromName(String groupName) {
        for(Group group : loadedGroups) {
            if(group.getName().toLowerCase().equalsIgnoreCase(groupName.toLowerCase())) {
                return group;
            }
        }
        return null;
    }

    public static Group getGroupFromPlayer(Player p) {
        String playerGroup = permission.getPrimaryGroup(p);
        for(Group group : loadedGroups) {
            if(group.getName().toLowerCase().equalsIgnoreCase(playerGroup.toLowerCase())) {
                return group;
            }
        }
        return null;
    }


}
