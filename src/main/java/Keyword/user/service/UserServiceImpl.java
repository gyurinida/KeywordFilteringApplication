package Keyword.user.service;

import Keyword.user.domain.LoginDTO;
import Keyword.user.domain.UserVO;
import Keyword.user.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Inject
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void signUp(UserVO userVO) throws Exception {
        userDAO.signUp(userVO);
    }

    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return userDAO.login(loginDTO);
    }

    @Override
    public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
        userDAO.keepLogin(userId, sessionId, sessionLimit);
    }

    @Override
    public UserVO checkLoginBefore(String value) throws Exception {
        return userDAO.checkUserWithSessionKey(value);
    }

    @Override
    public Integer dupCheck(String uncheckedId) throws Exception{
        return userDAO.dupCheck(uncheckedId);
    }
}
