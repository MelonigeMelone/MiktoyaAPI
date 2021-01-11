package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.lib.configuration.yaml.YamlFileBuilder;

/**
 * Erstellt den deutschen Language File
 *
 * @author  MelonigeMelone
 * @version 1.0
 * @since   2021-01-11
 */

public class LanguageSystemGermanConfigHandler extends YamlFileBuilder {

    public LanguageSystemGermanConfigHandler() {
        super(MiktoyaAPI.getIntsance().getDataFolder() + "/Messages", "messageFileGerman.yml");

        save();
    }


}
