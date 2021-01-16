package de.melonigemelone.miktoyaapi.repository.lib.minecraft.holograms;

import de.melonigemelone.miktoyaapi.repository.lib.configuration.yaml.YamlFileBuilder;

public class HologramHandler {

    public void loadHologramsFromFile(String path, String file) {
        YamlFileBuilder fb = new YamlFileBuilder(path, file);
        for (String name : fb.getKeys(false)) {
            HologramBuilder hb = new HologramBuilder(name, fb.getString(String.valueOf(name) + ".World"), fb.getDouble(String.valueOf(name) + ".X"), fb.getDouble(String.valueOf(name) + ".Y"), fb.getDouble(String.valueOf(name) + ".Z"));
            for (String line : fb.getStringList(String.valueOf(name) + ".Lines"))
                hb.addLine(line);
            hb.spawn();
        }
    }
}
