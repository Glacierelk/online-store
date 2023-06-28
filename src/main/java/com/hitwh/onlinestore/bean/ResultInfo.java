package com.hitwh.onlinestore.bean;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private boolean flag;
    private Object data;
    private String errorMsg;

    public ResultInfo() {
    }

    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public Object getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
