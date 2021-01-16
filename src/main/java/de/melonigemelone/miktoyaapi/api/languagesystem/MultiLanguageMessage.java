package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;

public class MultiLanguageMessage {

    private final String identifier;
    private final String germanMessage;
    private final String englischMessage;

    public MultiLanguageMessage(String identifier, String germanMessage, String englischMessage) {
        this.identifier = identifier;
        this.germanMessage = germanMessage;
        this.englischMessage = englischMessage;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getGermanMessage() {
        return germanMessage;
    }

    public String getEnglischMessage() {
        return englischMessage;
    }

    public String getMessage(PlayerData playerData, boolean replaceColorCodes) {
        return LanguageSystemAPI.getMessage(identifier, playerData.getLanguage(), replaceColorCodes);
    }

    public MultiLanguageMessage create() {
        LanguageSystemAPI.addMessage(identifier,germanMessage, englischMessage);
        return this;
    }
}