package Keyword.content.persistence;

import Keyword.commons.paging.Criteria;
import Keyword.commons.paging.SearchCriteria;
import Keyword.content.domain.ContentVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContentDAOImpl implements ContentDAO{
    private static final String NAMESPACE = "Keyword.mappers.content.ContentMapper";
    private final SqlSession sqlSession;

    @Inject
    public ContentDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(ContentVO contentVO) throws Exception {
        sqlSession.insert(NAMESPACE+".create", contentVO);
    }

    @Override
    public ContentVO read(String contentId) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".read", contentId);
    }

    @Override
    public void update(ContentVO contentVO) throws Exception {
        sqlSession.update(NAMESPACE+".update", contentVO);
    }

    @Override
    public void delete(String contentId) throws Exception {
        sqlSession.delete(NAMESPACE+".delete", contentId);
    }

    @Override
    public List<ContentVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE+".listAll");
    }

    @Override
    public List<String> listType() throws Exception {
        return sqlSession.selectList(NAMESPACE+".listType");
    }

    @Override
    public List<String> listGenre() throws Exception {
        return sqlSession.selectList(NAMESPACE+".listGenre");
    }

    @Override
    public List<String> listRated() throws Exception {
        return sqlSession.selectList(NAMESPACE+".listRated");
    }

    @Override
    public void updateReview(String contentId, int amount, float rating) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("amount", amount);
        paramMap.put("rating", rating);

        sqlSession.update(NAMESPACE+".updateReview", paramMap);
    }

    @Override
    public List<String> listMyGenre(String contentId) throws Exception {
        return sqlSession.selectList(NAMESPACE+".listMyGenre", contentId);
    }

    @Override
    public void updateLikesCnt(String contentId, int amount) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("amount", amount);

        sqlSession.update(NAMESPACE+".updateLikesCnt", paramMap);
    }

    @Override
    public int countResult(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("selType", selType);
        paramMap.put("selGenre", selGenre);
        paramMap.put("selRated", selRated);
        paramMap.put("selRtime_start", selRtime_start);
        paramMap.put("selRtime_end", selRtime_end);
        return sqlSession.selectOne(NAMESPACE+".countResult", paramMap);
    }

    @Override
    public List<ContentVO> listSelected(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end, String selSort, Criteria criteria) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("selType", selType);
        paramMap.put("selGenre", selGenre);
        paramMap.put("selRated", selRated);
        paramMap.put("selRtime_start", selRtime_start);
        paramMap.put("selRtime_end", selRtime_end);
        paramMap.put("selSort", selSort);
        paramMap.put("criteria", criteria);
        return sqlSession.selectList(NAMESPACE+".listSelected", paramMap);
    }

    @Override
    public List<ContentVO> getMyLikes(String userId, Criteria criteria, String selSort) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("criteria", criteria);
        paramMap.put("selSort", selSort);
        return sqlSession.selectList(NAMESPACE+".getMyLikes", paramMap);
    }

    @Override
    public int countSearchedContents(SearchCriteria searchCriteria) throws Exception{
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchCriteria", searchCriteria);
        return sqlSession.selectOne(NAMESPACE+".countSearchedContents", paramMap);
    }

    @Override
    public List<ContentVO> listSearch(SearchCriteria searchCriteria, String selSort) throws Exception{
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchCriteria", searchCriteria);
        paramMap.put("selSort", selSort);
        return sqlSession.selectList(NAMESPACE+".listSearch", paramMap);
    }

    @Override
    public void setPoster(String contentId, String poster) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("contentId", contentId);
        paramMap.put("poster", poster);

        sqlSession.update(NAMESPACE+".setPoster", paramMap);
    }

    @Override
    public void insertGenre(String contentId, List<String> genre) throws Exception {
        for(String g : genre) {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("contentId", contentId);
            paramMap.put("genre", g);
            sqlSession.insert(NAMESPACE + ".insertGenre", paramMap);
        }
    }

    @Override
    public List<ContentVO> getRanking(String selType) throws Exception {
        return sqlSession.selectList(NAMESPACE+".getRanking", selType);
    }
}
