package com.wechat.mp.controller;

import com.wechat.mp.exception.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by akinoneko on 2017/4/17.
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * Rest接口异常处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(RestException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> restApiException(HttpServletRequest request, RestException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", ex.getStatus());
        body.put("message", ex.getMessage());
        body.put("url", request.getRequestURL());
        HttpStatus status = HttpStatus.valueOf(ex.getStatus());
        return new ResponseEntity<>(body, status);
    }


}
