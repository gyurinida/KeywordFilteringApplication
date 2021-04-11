package Keyword.review.service;

import Keyword.commons.paging.Criteria;
import Keyword.review.domain.ReviewVO;

import java.util.List;

public interface ReviewService {
    List<ReviewVO> getReviews(String contentId, String userId) throws Exception;
    void addReview(ReviewVO reviewVO) throws Exception;
    void modifyReview(ReviewVO reviewVO) throws Exception;
    void removeReview(Integer reviewNo) throws Exception;
    ReviewVO getMyReview(String contentId, String userId) throws Exception;
    List<ReviewVO> getReviewsPaging(String contentId, Criteria criteria) throws Exception;  // 페이징
    int countReviews(String contentId) throws Exception;    // 페이징
}
