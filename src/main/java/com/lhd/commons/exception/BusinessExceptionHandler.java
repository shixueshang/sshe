package com.lhd.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lihongde on 2016/11/25 12:10
 */
@ControllerAdvice
public class BusinessExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(ForbiddenReqeustException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ModelAndView handleInvalidRequestError(ForbiddenReqeustException ex) {
        logger.error("handleInvalidRequestError FailedReqeustException :"+ex.getMessage());
        ModelAndView mav = new ModelAndView("error/403");
        mav.addObject("result",  ex.getResult());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(NeedLoginRequestException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ModelAndView handleInvalidRequestError(NeedLoginRequestException ex) {
        logger.error("handleInvalidRequestError NeedLoginRequestException :" + ex.getMessage());
        ModelAndView mav = new ModelAndView("error/401");
        mav.addObject("result",  ex.getResult());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleInvalidRequestError(BadRequestException ex) {
        logger.error("handleInvalidRequestError BadRequestRequestException :"+ex.getMessage());
        ModelAndView mav = new ModelAndView("error/400");
        mav.addObject("result",  ex.getResult());
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(RuntimeException.class)

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleInvalidRequestError(RuntimeException ex) {
        logger.error("handleInvalidRequestError RuntimeException :" + ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error/500");
        mav.addObject("message", ex);
        mav.addObject("cause", ex.getCause());
        return mav;
    }

    @ExceptionHandler(NotFoundRequestException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handleInvalidRequestError(NotFoundRequestException ex) {
        logger.error("handleInvalidRequestError  inteface not found :" + ex.getMessage());
        ModelAndView mav = new ModelAndView("error/404");
        mav.addObject("result", ex.getResult());
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}
