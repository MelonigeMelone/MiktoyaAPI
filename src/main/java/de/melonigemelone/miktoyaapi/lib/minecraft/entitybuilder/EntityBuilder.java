package de.melonigemelone.miktoyaapi.lib.minecraft.entitybuilder;

import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class EntityBuilder {

    private Entity en;

    public EntityBuilder(final EntityType entity, final Location loc) {
        this.en = loc.getWorld().spawnEntity(loc, entity);
    }


    public EntityBuilder setCustomName(final String name) {
        this.en.setCustomName(name);
        return this;
    }

    public EntityBuilder setCustomNameVisible(final boolean visible) {
        this.en.setCustomNameVisible(visible);
        return this;
    }

    public EntityBuilder setPassenger(final Entity entity) {
        this.en.setPassenger(entity);
        return this;
    }

    public EntityBuilder setAge(final EntityAge age) {
        if (this.en instanceof Ageable) {
            switch (age) {
                case BABY: {
                    ((Ageable) this.en).setBaby();
                    break;
                }
                case ADULT: {
                    ((Ageable) this.en).setAdult();
                    break;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("Entity's age cannot be modified!");
    }

    public Entity spawn() {
        return this.en;
    }

    public enum EntityAge {
        BABY("BABY", 0),
        ADULT("ADULT", 1);

        EntityAge(final String s, final int n) {
        }
    }

    public EntityBuilder remove() {
        this.en.remove();
        return this;
    }

}
