package de.melonigemelone.miktoyaapi.api.scoreboard;

import java.util.List;

public class ScoreBoardData {

    private String displayName;
    private List<String> linesGerman;
    private List<String> linesEnglisch;

    public ScoreBoardData(String displayName, List<String> linesGerman , List<String> linesEnglisch) {
        this.displayName = displayName;
        this.linesGerman = linesGerman;
        this.linesEnglisch = linesEnglisch;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getLinesGerman() {
        return linesGerman;
    }

    public void setLinesGerman(List<String> linesGerman) {
        this.linesGerman = linesGerman;
    }

    public void setLinesEnglisch(List<String> linesEnglisch) {
        this.linesEnglisch = linesEnglisch;
    }

    public List<String> getLinesEnglisch() {
        return linesEnglisch;
    }
}
