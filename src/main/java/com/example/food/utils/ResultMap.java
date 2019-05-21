package com.example.food.utils;

public class ResultMap<T> {
    private String code = "200";
    private String message = "本次请求成功!";
    private T data = null;

    public ResultMap() {
    }

    public ResultMap(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultMap(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResultMap<T> ok(T data) {
        return new ResultMap("200", "本次请求成功", data);
    }

    public static <T> ResultMap<T> fail(T data) {
        return new ResultMap("500", "本次请求失败", data);
    }

    public ResultMap(T data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
