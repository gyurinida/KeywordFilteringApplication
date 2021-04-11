package Keyword.review.persistence;

import Keyword.commons.paging.Criteria;
import Keyword.review.domain.ReviewVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
    private static String NAMESPACE = "Keyword.mappers.review.ReviewMapper";
    private final SqlSession sqlSession;

    @Inject
    public ReviewDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ReviewVO> list(String contentId, String userId) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("userId", userId);
        return sqlSession.selectList(NAMESPACE+".list", paramMap);
    }

    @Override
    public void create(ReviewVO reviewVO) throws Exception {
        sqlSession.insert(NAMESPACE+".create", reviewVO);
    }

    @Override
    public void update(ReviewVO reviewVO) throws Exception {
        sqlSession.update(NAMESPACE+".update", reviewVO);
    }

    @Override
    public void delete(Integer reviewNo) throws Exception {
        sqlSession.delete(NAMESPACE+".delete", reviewNo);
    }

    @Override
    public String getContentId(Integer reviewNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".getContentId", reviewNo);
    }

    @Override
    public ReviewVO getMyReview(String contentId, String userId) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("userId", userId);
        return sqlSession.selectOne(NAMESPACE+".getMyReview", paramMap);
    }

    @Override
    public List<ReviewVO> listPaging(String contentId, Criteria criteria) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("criteria", criteria);
        return sqlSession.selectList(NAMESPACE+".listPaging", paramMap);
    }

    @Override
    public Integer countReviews(String contentId) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".countReviews", contentId);
    }

    @Override
    public Float getAvgRatings(String contentId) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".ratingsAvg", contentId);
    }
}
