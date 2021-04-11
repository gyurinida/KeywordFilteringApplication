package Keyword.user;

import Keyword.user.domain.UserVO;
import Keyword.user.persistence.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class UserDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Inject
    private UserDAO userDAO;

    @Test
    public void testCreate() throws Exception{
        UserVO user = new UserVO();
        user.setUserId("admin");
        user.setUserPw("admin");
        user.setUserName("관리자");
        user.setUserEmail("admin@filtering.com");
        Date cur = new Date();
        user.setUserJoinDate(cur);
        userDAO.signUp(user);
    }
}
