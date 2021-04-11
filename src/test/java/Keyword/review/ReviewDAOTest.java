package Keyword.review;

import Keyword.commons.paging.Criteria;
import Keyword.review.domain.ReviewVO;
import Keyword.review.persistence.ReviewDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ReviewDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(ReviewDAOTest.class);
    @Inject
    private ReviewDAO reviewDAO;

    @Test
    public void testReplyPaging() throws Exception{
        Criteria criteria = new Criteria();
        criteria.setPerPageNum(10);
        criteria.setPage(1);

        List<ReviewVO> reviews = reviewDAO.listPaging("tt3521164", criteria);
        for(ReviewVO review: reviews)
            System.out.println(review.getReviewNo()+": "+review.getReviewText());
    }

    @Test
    public void testReviewCreate() throws Exception{
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.setContentId("tt3521164");
        reviewVO.setReviewText("1번째 댓글입니다..");
        reviewVO.setReviewWriter("admin");
        reviewDAO.create(reviewVO);
    }


    @Test
    public void testReviewList() throws Exception{
        System.out.println(reviewDAO.list("tt3521164", "").toString());
    }

    @Test
    public void testReviewUpdate() throws Exception{
        ReviewVO reviewVO = new ReviewVO();
        reviewVO.setContentId("tt3521164");
        reviewVO.setReviewNo(1);
        reviewVO.setReviewText("1번째 댓글 수정!");
        reviewDAO.update(reviewVO);
    }

    @Test
    public void testReviewDelete() throws Exception{
        reviewDAO.delete(1);
    }
}
