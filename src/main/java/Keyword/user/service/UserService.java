package Keyword.user.service;

import Keyword.user.domain.LoginDTO;
import Keyword.user.domain.UserVO;

import java.util.Date;

public interface UserService {
    void signUp(UserVO userVO) throws Exception;
    UserVO login(LoginDTO loginDTO) throws Exception;
    void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;
    UserVO checkLoginBefore(String value) throws Exception;
    Integer dupCheck(String uncheckedId) throws Exception;
}
