package Keyword.likes.service;

import Keyword.likes.domain.LikesVO;

public interface LikesService {
    void liked(LikesVO likesVO) throws Exception;
    void unliked(LikesVO likesVO) throws Exception;
    LikesVO isLiked(String contentId, String userId) throws Exception;
    int countMyLikes(String userId) throws Exception;
}
