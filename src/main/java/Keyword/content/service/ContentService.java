package Keyword.content.service;

import Keyword.commons.paging.Criteria;
import Keyword.commons.paging.SearchCriteria;
import Keyword.content.domain.ContentVO;

import java.util.List;

public interface ContentService {
    void create(ContentVO contentVO) throws Exception;
    ContentVO read(String contentId) throws Exception;
    void update(ContentVO contentVO) throws Exception;
    void delete(String contentId) throws Exception;
    List<ContentVO> listAll() throws Exception;
    List<String> listType() throws Exception;
    List<String> listGenre() throws Exception;
    List<String> listRated() throws Exception;
    List<ContentVO> listSelected(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end, String selSort, Criteria criteria) throws Exception;
    List<String> listMyGenre(String contentId) throws Exception;
    int countResult(String selType, String[] selGenre, String[] selRated, int selRtime_start, int selRtime_end) throws Exception;
    List<ContentVO> getMyLikes(String userId, Criteria criteria, String selSort) throws Exception;
    int countSearchedContents(SearchCriteria searchCriteria) throws Exception;   // 검색 결과 카운트
    List<ContentVO> listSearch(SearchCriteria searchCriteria, String selSort) throws Exception;  // 검색 결과
    List<ContentVO> getRanking(String selType) throws Exception;
}
