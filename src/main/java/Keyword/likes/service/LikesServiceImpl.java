package Keyword.likes.service;

import Keyword.content.persistence.ContentDAO;
import Keyword.likes.domain.LikesVO;
import Keyword.likes.persistence.LikesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class LikesServiceImpl implements LikesService{
    private final LikesDAO likesDAO;
    private final ContentDAO contentDAO;

    @Inject
    public LikesServiceImpl(LikesDAO likesDAO, ContentDAO contentDAO) {
        this.likesDAO = likesDAO;
        this.contentDAO = contentDAO;
    }

    @Transactional
    @Override
    public void liked(LikesVO likesVO) throws Exception {
        likesDAO.create(likesVO);
        contentDAO.updateLikesCnt(likesVO.getContentId(), 1);
    }

    @Transactional
    @Override
    public void unliked(LikesVO likesVO) throws Exception {
        likesDAO.delete(likesVO);
        contentDAO.updateLikesCnt(likesVO.getContentId(), -1);
    }

    @Override
    public LikesVO isLiked(String contentId, String userId) throws Exception {
        return likesDAO.isLiked(contentId, userId);
    }

    @Override
    public int countMyLikes(String userId) throws Exception {
        return likesDAO.countMyLikes(userId);
    }
}
