package com.example.demo.entity;

public class ResultInfo {
    private Integer code;
    private String msg;
    private Object data;

    public static ResultInfo error(Object dataObject,String msgStr){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.code = -1;
        resultInfo.msg = msgStr;
        resultInfo.data = dataObject;
        return resultInfo;
    }
    public static ResultInfo success(Object dataObject,String msgStr){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.code = 0;
        resultInfo.msg = msgStr;
        resultInfo.data = dataObject;
        return resultInfo;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
