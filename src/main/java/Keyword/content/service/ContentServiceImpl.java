package Keyword.content.service;

import Keyword.commons.paging.Criteria;
import Keyword.commons.paging.SearchCriteria;
import Keyword.content.domain.ContentVO;
import Keyword.content.persistence.ContentDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{
    private final ContentDAO contentDAO;

    @Inject
    public ContentServiceImpl(ContentDAO contentDAO) {
        this.contentDAO = contentDAO;
    }

    @Override
    public void create(ContentVO contentVO) throws Exception {
        contentDAO.create(contentVO);
    }

    @Override
    public ContentVO read(String contentId) throws Exception {
        return contentDAO.read(contentId);
    }

    @Override
    public void update(ContentVO contentVO) throws Exception {
        contentDAO.update(contentVO);
    }

    @Override
    public void delete(String contentId) throws Exception {
        contentDAO.delete(contentId);
    }

    @Override
    public List<ContentVO> listAll() throws Exception {
        return contentDAO.listAll();
    }

    @Override
    public List<String> listType() throws Exception {
        return contentDAO.listType();
    }

    @Override
    public List<String> listGenre() throws Exception {
        return contentDAO.listGenre();
    }

    @Override
    public List<String> listRated() throws Exception {
        return contentDAO.listRated();
    }

    @Override
    public List<ContentVO> listSelected(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end, String selSort, Criteria criteria) throws Exception {
        return contentDAO.listSelected(selType, selGenre, selRated, selRtime_start, selRtime_end, selSort, criteria);
    }

    @Override
    public List<String> listMyGenre(String contentId) throws Exception {
        return contentDAO.listMyGenre(contentId);
    }

    @Override
    public int countResult(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end) throws Exception {
        return contentDAO.countResult(selType, selGenre, selRated, selRtime_start, selRtime_end);
    }

    @Override
    public List<ContentVO> getMyLikes(String userId, Criteria criteria, String selSort) throws Exception {
        return contentDAO.getMyLikes(userId, criteria, selSort);
    }

    @Override
    public int countSearchedContents(SearchCriteria searchCriteria) throws Exception{
        return contentDAO.countSearchedContents(searchCriteria);
    }

    @Override
    public List<ContentVO> listSearch(SearchCriteria searchCriteria, String selSort) throws Exception{
        return contentDAO.listSearch(searchCriteria, selSort);
    }

    @Override
    public List<ContentVO> getRanking(String selType) throws Exception {
        return contentDAO.getRanking(selType);
    }


}
