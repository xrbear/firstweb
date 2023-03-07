package com.study.demo.enums;

public enum ErrorCodeEnum {
    SUCCESS(200,"成功"),
    OTHER(99999, "未知错误"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
