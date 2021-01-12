package de.melonigemelone.miktoyaapi.api.luckperms;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.context.DefaultContextKeys;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeEqualityPredicate;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class LuckPermsAPI {

    public static  RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);

    //spieler
    public static boolean givePlayerPermission(Player p, PermissionNode permissionNode) {
        boolean success = false;

        if (provider != null) {
            LuckPerms api = provider.getProvider();
            User pUser = api.getUserManager().getUser(p.getUniqueId());

            if(pUser != null) {
                success = pUser.data().add(permissionNode).wasSuccessful();
                api.getUserManager().saveUser(pUser);
            }

        }
        return success;
    }

    public static boolean givePlayerPermissionGlobal(Player p, String permNode) {
        PermissionNode node = PermissionNode.builder(permNode).build();
        return givePlayerPermission(p, node);
    }

    public static boolean givePlayerPermissionOnSpecificServer(Player p, String permNode, String server) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .build();
        return givePlayerPermission(p, node);
    }

    public static boolean givePlayerPermissionOnSpecificServerAndWorld(Player p, String permNode, String server, String world) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .withContext(DefaultContextKeys.WORLD_KEY, world)
                .build();
        return givePlayerPermission(p, node);
    }

    public static boolean removePermission(Player p, PermissionNode permissionNode) {
        boolean success = false;
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            User pUser = api.getUserManager().getUser(p.getUniqueId());

            if (pUser != null) {
                success = pUser.data().remove(permissionNode).wasSuccessful();
                api.getUserManager().saveUser(pUser);
            }
        }
        return success;
    }

    public static boolean removePermissionGlobal(Player p, String permNode) {
        PermissionNode node = PermissionNode.builder(permNode).build();
        return removePermission(p, node);

    }

    public static boolean removePermissionGlobalOnSpecificServer(Player p, String permNode, String server) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .build();
        return removePermission(p, node);

    }

    public static boolean removePermissionGlobalOnSpecificServerAndWorld(Player p, String permNode, String server, String world) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .withContext(DefaultContextKeys.WORLD_KEY, world)
                .build();
        return removePermission(p, node);
    }

    public static boolean hasPermission(Player p, PermissionNode permissionNode, NodeEqualityPredicate nodeEqualityPredicate) {
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            User pUser = api.getUserManager().getUser(p.getUniqueId());

            if (pUser != null) {
                return pUser.data().contains(permissionNode, nodeEqualityPredicate).asBoolean();
            }

        }
        return false;
    }

    public static boolean hasPlayerPermissionGlobal(Player p, String permNode, NodeEqualityPredicate nodeEqualityPredicate) {
        PermissionNode node = PermissionNode.builder(permNode)
                .build();
        return hasPermission(p, node, nodeEqualityPredicate);
    }

    public static boolean hasPlayerPermissionOnSpecificServer(Player p, String permNode, String server, NodeEqualityPredicate nodeEqualityPredicate) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .build();
        return hasPermission(p, node, nodeEqualityPredicate);

    }

    public static boolean hasPlayerPermissionOnSpecificServerAndWorld(Player p, String permNode, String server, String world, NodeEqualityPredicate nodeEqualityPredicate) {
        PermissionNode node = PermissionNode.builder(permNode)
                .withContext(DefaultContextKeys.SERVER_KEY, server)
                .withContext(DefaultContextKeys.WORLD_KEY, world)
                .build();
        return hasPermission(p, node, nodeEqualityPredicate);
    }

    //Gruppen
    public static boolean existsGroup(String groupName) {
       return getGroup(groupName) != null;
    }

    public static Group getGroup(String groupName) {
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            for(Group group : api.getGroupManager().getLoadedGroups()) {
                if(group.getName().toLowerCase().equalsIgnoreCase(groupName.toLowerCase())) {
                    return group;
                }
            }
        }
        return null;
    }

    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }

}
