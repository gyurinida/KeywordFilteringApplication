package Keyword.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView commonException(Exception e){
        // ModelAndView: 하나의 객체에 Model 데이터와 View의 처리를 동시에 할 수 있는 객체
        logger.info(e.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("/commons/common_error");

        return modelAndView;
    }
}
