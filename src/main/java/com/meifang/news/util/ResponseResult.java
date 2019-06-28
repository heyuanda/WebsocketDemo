package com.meifang.news.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer state;
    private String message;
    private T data;
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
    }
    public ResponseResult() {
        super();
    }
    public ResponseResult(Integer state) {
        super();
        setState(state);
    }
    public ResponseResult(Integer state,Exception e) {
        this(state,e.getMessage());
    }
    public ResponseResult(Integer state, String message) {
        this(state);
        setMessage(message);
    }
    public ResponseResult(Integer state, T data) {
        this(state);
        this.data = data;
    }

    public ResponseResult(Integer state, String message, T data) {
        this(state,message);
        this.data = data;
    }
}
