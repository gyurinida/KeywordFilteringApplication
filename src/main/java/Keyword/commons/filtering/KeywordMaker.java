package Keyword.commons.filtering;

import java.util.List;

public class KeywordMaker {
    private List<String> totalType;
    private List<String> totalGenre;
    private List<String> totalRated;
    private List<String> myGenre;

    public List<String> getTotalType() {
        return totalType;
    }

    public void setTotalType(List<String> totalType) {
        this.totalType = totalType;
    }

    public List<String> getTotalGenre() {
        return totalGenre;
    }

    public void setTotalGenre(List<String> totalGenre) {
        this.totalGenre = totalGenre;
    }

    public List<String> getTotalRated() {
        return totalRated;
    }

    public void setTotalRated(List<String> totalRated) {
        this.totalRated = totalRated;
    }

    public List<String> getMyGenre() {
        return myGenre;
    }

    public void setMyGenre(List<String> myGenre) {
        this.myGenre = myGenre;
    }
}
