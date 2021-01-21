package de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist;

public class TablistData {

    private String germanHeader;
    private String germanFooter;

    private String englischHeader;
    private String englischFooter;

    public TablistData(String germanHeader, String germanFooter, String englischHeader, String englischFooter) {
        this.germanHeader = germanHeader;
        this.germanFooter = germanFooter;
        this.englischHeader = englischHeader;
        this.englischFooter = englischFooter;
    }

    public String getGermanHeader() {
        return germanHeader;
    }

    public void setGermanHeader(String germanHeader) {
        this.germanHeader = germanHeader;
    }

    public String getGermanFooter() {
        return germanFooter;
    }

    public void setGermanFooter(String germanFooter) {
        this.germanFooter = germanFooter;
    }

    public String getEnglischHeader() {
        return englischHeader;
    }

    public void setEnglischHeader(String englischHeader) {
        this.englischHeader = englischHeader;
    }

    public String getEnglischFooter() {
        return englischFooter;
    }

    public void setEnglischFooter(String englischFooter) {
        this.englischFooter = englischFooter;
    }
}
