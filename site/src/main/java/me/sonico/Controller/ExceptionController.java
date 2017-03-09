package me.sonico.Controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by yanfa_4 on 2016-11-19.
 * http://www.cnblogs.com/xinzhao/p/4902295.html
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class ExceptionController {
    // 以下是异常处理方法

    // 将DataIntegrityViolationException转化为Http Status Code为409的响应
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    // 针对SQLException和DataAccessException返回视图databaseError
    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed to
        // the view-resolver(s) in usual way.
        // Note that the exception is _not_ available to this view (it is not added to
        // the model) but see "Extending ExceptionHandlerExceptionResolver" below.
        return "databaseError";
    }

    // 创建ModleAndView，将异常和请求的信息放入到Model中，指定视图名字，并返回该ModleAndView
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}

