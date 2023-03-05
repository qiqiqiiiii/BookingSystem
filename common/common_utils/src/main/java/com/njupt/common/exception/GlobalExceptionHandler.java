package com.njupt.common.exception;

import com.njupt.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //使用@RestControllerAdvice后面就不需要再添加@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(SystemException.class)
    public Result exceptionHandler(SystemException e){
        e.printStackTrace();
        return Result.fail();
    }
}
