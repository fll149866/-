package com.nysb.demo01.exception;

import com.nysb.demo01.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e){
        logger.error("[系统异常]{}",e.getMessage());

        if (e instanceof ZBSYSException){
            ZBSYSException zbsysException = (ZBSYSException) e;

            return JsonData.buildError(zbsysException.getCode(),zbsysException.getMsg());
        }else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }

}
