package Keyword.review.persistence;

import Keyword.commons.paging.Criteria;
import Keyword.review.domain.ReviewVO;

import java.util.List;

public interface ReviewDAO {
    List<ReviewVO> list(String contentId, String userId) throws Exception;
    void create(ReviewVO reviewVO) throws Exception;
    void update(ReviewVO reviewVO) throws Exception;
    void delete(Integer reviewNo) throws Exception;
    String getContentId(Integer reviewNo) throws Exception;
    ReviewVO getMyReview(String contentId, String userId) throws Exception;   // 내 리뷰 가져오기
    List<ReviewVO> listPaging(String contentId, Criteria criteria) throws Exception;    // 페이징
    Integer countReviews(String contentId) throws Exception;   // 페이징
    Float getAvgRatings(String contentId) throws Exception;
}
