package Keyword.user.persistence;

import Keyword.user.domain.LoginDTO;
import Keyword.user.domain.UserVO;

import java.util.Date;

public interface UserDAO {
    void signUp(UserVO userVO) throws Exception;
    UserVO login(LoginDTO loginDTO) throws Exception;
    void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;
    UserVO checkUserWithSessionKey(String value) throws Exception;
    Integer dupCheck(String uncheckedId) throws Exception;
}
