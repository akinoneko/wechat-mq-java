package com.wechat.mp.exception;

import org.apache.http.HttpStatus;
import org.springframework.web.client.RestClientException;

/**
 * Created by akinoneko on 2017/4/17.
 */
public class RestException extends RestClientException implements HttpStatus {

    /**
     * HTTP返回码
     */
    private Integer status;

    /**
     * 业务码
     */
    private Integer code;

    /**
     * 详细描述
     */
    private String description;

    public RestException(String msg) {
        super(msg);
    }

    public RestException(Integer status, String msg) {
        super(msg);
        this.status = status;
    }

    public RestException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public RestException(Integer status, String msg, Throwable ex) {
        super(msg, ex);
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
