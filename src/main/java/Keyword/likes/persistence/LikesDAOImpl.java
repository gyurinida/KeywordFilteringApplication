package Keyword.likes.persistence;

import Keyword.likes.domain.LikesVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LikesDAOImpl implements LikesDAO{
    private static String NAMESPACE = "Keyword.mappers.likes.LikesMapper";
    private final SqlSession sqlSession;

    @Inject
    public LikesDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(LikesVO likesVO) throws Exception {
        sqlSession.insert(NAMESPACE+".create", likesVO);
    }

    @Override
    public void delete(LikesVO likesVO) throws Exception {
        sqlSession.delete(NAMESPACE+".delete", likesVO);
    }

    @Override
    public LikesVO isLiked(String contentId, String userId) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("userId", userId);
        return sqlSession.selectOne(NAMESPACE+".isLiked", paramMap);
    }

    @Override
    public int countMyLikes(String userId) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".countMyLikes", userId);
    }
}
