package Keyword.likes.domain;

import java.util.Date;

public class LikesVO {
    private String contentId;
    private String userId;
    private Date regDate;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "LikesVO{" +
                "contentId='" + contentId + '\'' +
                ", userId='" + userId + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
