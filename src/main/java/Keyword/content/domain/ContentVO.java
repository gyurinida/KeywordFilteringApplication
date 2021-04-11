package Keyword.content.domain;

import java.util.Date;
import java.util.List;

public class ContentVO {
    private String contentId;
    private String title;
    private String plot;
    private String type;
    private String rated;
    private Integer year;
    private Date releasedAt;
    private Integer runtime;
    private String director;
    private String writer;
    private String actor;
    private String subtitle;
    private Integer awardWin;
    private Integer awardNominate;
    private String awardMajor;
    private String awardMajorType;
    private Double imdbRating;
    private Integer imdbVotes;
    private Double rating;
    private Integer reviewCnt;
    private Integer likesCnt;
    private String poster;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getAwardWin() {
        return awardWin;
    }

    public void setAwardWin(Integer awardWin) {
        this.awardWin = awardWin;
    }

    public Integer getAwardNominate() {
        return awardNominate;
    }

    public void setAwardNominate(Integer awardNominate) {
        this.awardNominate = awardNominate;
    }

    public String getAwardMajor() {
        return awardMajor;
    }

    public void setAwardMajor(String awardMajor) {
        this.awardMajor = awardMajor;
    }

    public String getAwardMajorType() {
        return awardMajorType;
    }

    public void setAwardMajorType(String awardMajorType) {
        this.awardMajorType = awardMajorType;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(Integer reviewCnt) {
        this.reviewCnt = reviewCnt;
    }

    public Integer getLikesCnt() {
        return likesCnt;
    }

    public void setLikesCnt(Integer likesCnt) {
        this.likesCnt = likesCnt;
    }

    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "ContentVO{" +
                "contentId='" + contentId + '\'' +
                ", title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", type='" + type + '\'' +
                ", rated='" + rated + '\'' +
                ", year=" + year +
                ", releasedAt=" + releasedAt +
                ", runtime=" + runtime +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actor='" + actor + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", awardWin=" + awardWin +
                ", awardNominate=" + awardNominate +
                ", awardMajor='" + awardMajor + '\'' +
                ", awardMajorType='" + awardMajorType + '\'' +
                ", imdbRating=" + imdbRating +
                ", imdbVotes=" + imdbVotes +
                ", rating=" + rating +
                ", reviewCnt=" + reviewCnt +
                ", likesCnt=" + likesCnt +
                '}';
    }
}
