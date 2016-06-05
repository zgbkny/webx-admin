package com.alibaba.webx.adminx.dal.dataobject;

/**
 * Created by wei on 2016/4/8.
 */
public class ResultInfo {

    public static final int CODE_ERR = 1;
    public static final int CODE_OK = 0;

    public ResultInfo() {

    }

    public ResultInfo(int code, String info) {
        this.code = code;
        this.info = info;
    }

    private int code;
    private String info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
