package Keyword.likes.persistence;

import Keyword.likes.domain.LikesVO;

import java.util.List;

public interface LikesDAO {
    void create(LikesVO likesVO) throws Exception;
    void delete(LikesVO likesVO) throws Exception;
    LikesVO isLiked(String contentId, String userId) throws Exception;
    int countMyLikes(String userId) throws Exception;
}
