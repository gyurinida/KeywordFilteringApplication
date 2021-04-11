package Keyword.review.domain;

import java.util.Date;

public class ReviewVO {
    private Integer reviewNo;
    private String contentId;
    private String reviewText;
    private String reviewWriter;
    private Date regDate;
    private Date updateDate;
    private Float reviewRating;

    public Integer getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewWriter() {
        return reviewWriter;
    }

    public void setReviewWriter(String reviewWriter) {
        this.reviewWriter = reviewWriter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Float getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Float reviewRating) {
        this.reviewRating = reviewRating;
    }

    @Override
    public String toString() {
        return "ReviewVO{" +
                "reviewNo=" + reviewNo +
                ", contentId='" + contentId + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewWriter='" + reviewWriter + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                ", reviewRating=" + reviewRating +
                '}';
    }
}
