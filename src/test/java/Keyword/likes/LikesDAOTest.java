package Keyword.likes;

import Keyword.likes.domain.LikesVO;
import Keyword.likes.persistence.LikesDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class LikesDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(LikesDAOTest.class);
    @Inject
    private LikesDAO likesDAO;

    @Test
    public void testLikesCreate() throws Exception{
        LikesVO likesVO = new LikesVO();
        likesVO.setContentId("tt3521164");
        likesVO.setUserId("RM");
        likesDAO.create(likesVO);
    }

    @Test
    public void testLikesDelete() throws Exception {
        LikesVO likesVO = new LikesVO();
        likesVO.setContentId("tt3521164");
        likesVO.setUserId("RM");
        likesDAO.delete(likesVO);
    }

    @Test
    public void testIsLiked() throws Exception{
        System.out.println(likesDAO.isLiked("tt3521164", "RM").toString());
    }

}
