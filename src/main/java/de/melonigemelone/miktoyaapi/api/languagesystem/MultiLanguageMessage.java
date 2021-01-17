package de.melonigemelone.miktoyaapi.api.languagesystem;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;

public class MultiLanguageMessage {

    private final String identifier;

    private final String defaultGermanMessage;
    private final String defaultEnglischMessage;

    private String germanMessage;
    private String englischMessage;

    public MultiLanguageMessage(String identifier, String defaultGermanMessage, String defaultEnglischMessage) {
        this.identifier = identifier;
        this.defaultGermanMessage = defaultGermanMessage;
        this.defaultEnglischMessage = defaultEnglischMessage;

        MiktoyaAPI.getLanguageSystemAPI().addMessage(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDefaultEnglischMessage() {
        return defaultEnglischMessage;
    }

    public String getDefaultGermanMessage() {
        return defaultGermanMessage;
    }

    public void setEnglischMessage(String englischMessage) {
        this.englischMessage = englischMessage;
    }

    public void setGermanMessage(String germanMessage) {
        this.germanMessage = germanMessage;
    }

    public String getMessage(PlayerData playerData, boolean replaceColorCodes) {
        String message = germanMessage;

        if(playerData.getLanguage().equals(Language.ENGLISCH)) {
            message =  englischMessage;
        }

        if(replaceColorCodes) {
            message = message.replaceAll("&", "§");
        }

        return message;
    }
}