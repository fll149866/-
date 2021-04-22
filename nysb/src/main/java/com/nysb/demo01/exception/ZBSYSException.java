package com.nysb.demo01.exception;

public class ZBSYSException extends RuntimeException {

    /**
     * 自定义状态码
     */
    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
