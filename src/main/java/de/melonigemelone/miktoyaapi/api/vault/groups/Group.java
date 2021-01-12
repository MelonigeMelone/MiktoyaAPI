package de.melonigemelone.miktoyaapi.api.vault.groups;

public class Group {

    private String name;

    private String chatPrefix;
    private String chatSuffix;
    private String[] chatNameColors;
    private String chatFormat;

    private String tabPrefix;
    private String tabSuffix;
    private String[] tabNameColors;
    private String tabRank;

    private String sbName;

    public Group(String name, String chatPrefix, String chatSuffix, String[] chatNameColors, String chatFormat, String tabPrefix, String tabSuffix, String[] tabNameColors, String tabRank, String sbName) {
        this.name = name;
        this.chatPrefix = chatPrefix;
        this.chatSuffix = chatSuffix;
        this.chatNameColors = chatNameColors;
        this.chatFormat = chatFormat;
        this.tabPrefix = tabPrefix;
        this.tabSuffix = tabSuffix;
        this.tabNameColors = tabNameColors;
        this.tabRank = tabRank;
        this.sbName = sbName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChatPrefix() {
        return chatPrefix;
    }

    public void setChatPrefix(String chatPrefix) {
        this.chatPrefix = chatPrefix;
    }

    public String getChatSuffix() {
        return chatSuffix;
    }

    public void setChatSuffix(String chatSuffix) {
        this.chatSuffix = chatSuffix;
    }

    public String[] getChatNameColors() {
        return chatNameColors;
    }

    public void setChatNameColors(String[] chatNameColors) {
        this.chatNameColors = chatNameColors;
    }

    public String getChatFormat() {
        return chatFormat;
    }

    public void setChatFormat(String chatFormat) {
        this.chatFormat = chatFormat;
    }

    public String getTabPrefix() {
        return tabPrefix;
    }

    public void setTabPrefix(String tabPrefix) {
        this.tabPrefix = tabPrefix;
    }

    public String getTabSuffix() {
        return tabSuffix;
    }

    public void setTabSuffix(String tabSuffix) {
        this.tabSuffix = tabSuffix;
    }

    public String[] getTabNameColors() {
        return tabNameColors;
    }

    public void setTabNameColors(String[] tabNameColors) {
        this.tabNameColors = tabNameColors;
    }

    public String getTabRank() {
        return tabRank;
    }

    public void setTabRank(String tabRank) {
        this.tabRank = tabRank;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }
}
