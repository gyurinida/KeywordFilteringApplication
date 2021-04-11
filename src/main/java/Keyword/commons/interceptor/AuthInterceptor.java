package Keyword.commons.interceptor;

import Keyword.user.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserVO user = (UserVO) request.getSession().getAttribute("login");
        String query = request.getQueryString();
        Integer sIdx = query.indexOf("?userId=")+8;
        Integer eIdx = query.indexOf("&");

        String qId;
        if(eIdx==-1)    qId = query.substring(sIdx);
        else            qId = query.substring(sIdx, eIdx);

        if(user==null || !user.getUserId().equals(qId)){
            logger.info("Wrong Access..");
            response.sendRedirect("/commons/wrongAccess");
            return false;
        }
        return true;
    }
}
