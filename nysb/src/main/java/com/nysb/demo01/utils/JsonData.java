package com.nysb.demo01.utils;

public class JsonData {

    private int code;

    private String msg;

    private Object data;

    public JsonData() {
    }

    public JsonData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     * @return
     */
    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }

    public static JsonData buildSuccess(Object data){
        return new JsonData(0,null,data);
    }

    /**
     * 失败   状态码 0表成功 1表处理中 -1表示失败
     */
    public static JsonData buildError(String msg){
        return new JsonData(-1,msg,null);
    }

    public static JsonData buildError(int code,String msg){
        return new JsonData(code,msg,null);
    }
}
