package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.lib.configuration.yaml.YamlFileBuilder;

/**
 * Erstellt den englischen Language File
 *
 * @author  MelonigeMelone
 * @version 1.0
 * @since   2021-01-11
 */

public class LanguageSystemEnglischConfigHandler extends YamlFileBuilder {

    public LanguageSystemEnglischConfigHandler() {
        super(MiktoyaAPI.getInstance().getDataFolder() + "/Messages", "messageFileEnglisch.yml");

        save();
    }

}
