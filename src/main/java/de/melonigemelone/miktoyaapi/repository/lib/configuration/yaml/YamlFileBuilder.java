package de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class YamlFileBuilder {

    private File file;

    private FileConfiguration cfg;

    public YamlFileBuilder(String path, String file) {
        this.file = new File(path, file);
        this.cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
    }

    public void addDefault(String path, Object value) {
        this.cfg.addDefault(path, value);
    }

    public void copyDefaults(boolean copyDefaults) {
        this.cfg.options().copyDefaults(copyDefaults);
    }

    public void set(String path, Object value) {
        this.cfg.set(path, value);
    }

    public void setIfNotExists(String path, Object value) {
        if(!this.cfg.contains(path)) {
            this.cfg.set(path, value);
        }
    }

    public YamlFileBuilder save() {
        try {
            this.cfg.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public void reload() {
        try {
            this.cfg.load(this.file);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
            save();
            reload();
        }
    }

    public boolean exists() {
        return this.file.exists();
    }

    public boolean contains(String value) {
        return this.cfg.contains(value);
    }

    public Object getObject(String path) {
        return this.cfg.get(path);
    }

    public String getString(String path) {
        return this.cfg.getString(path);
    }

    public int getInt(String path) {
        return this.cfg.getInt(path);
    }

    public double getDouble(String path) {
        return this.cfg.getDouble(path);
    }

    public long getLong(String path) {
        return this.cfg.getLong(path);
    }

    public boolean getBoolean(String path) {
        return this.cfg.getBoolean(path);
    }

    public List<String> getStringList(String path) {
        return this.cfg.getStringList(path);
    }

    public List<Boolean> getBooleanList(String path) {
        return this.cfg.getBooleanList(path);
    }

    public List<Double> getDoubleList(String path) {
        return this.cfg.getDoubleList(path);
    }

    public List<Integer> getIntegerList(String path) {
        return this.cfg.getIntegerList(path);
    }

    public Set<String> getKeys(boolean keys) {
        return this.cfg.getKeys(keys);
    }

    public ConfigurationSection getConfigurationSection(String section) {
        return this.cfg.getConfigurationSection(section);
    }

    public void delete() {
        this.file.delete();
    }
}
