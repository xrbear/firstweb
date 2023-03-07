package com.study.demo.dto;

import com.study.demo.enums.ErrorCodeEnum;

/**
 * @author ：xurong02
 * @date ：2023/3/7 2:49 下午
 */
public class ResponseDTO<T> {
    public static final String DEFAULT_ERROR_MSG = "error";
    public static final int DEFAULT_ERROR_CODE = 500;
    /**
     * 状态码
     */
    private Integer code = 200;
    /**
     * msg说明
     */
    private String msg = "success";
    /**
     * 数据
     */
    private T data;

    public ResponseDTO() {
    }

    public ResponseDTO(String msg) {
        this.msg = msg;
    }

    public static <T> ResponseDTO<T> successMsg(String message) {
        return new ResponseDTO<T>(message);
    }

    public static <T> ResponseDTO<T> success(T data) {
        ResponseDTO<T> tResponseDTO = new ResponseDTO<>();
        tResponseDTO.setData(data);
        return tResponseDTO;
    }

    public static <T> ResponseDTO<T> success(String message,T data) {
        ResponseDTO<T> responseDTO = success(data);
        responseDTO.setMsg(message);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(Integer code, String msg) {
        ResponseDTO<T> tResponseDTO = new ResponseDTO();
        tResponseDTO.setMsg(msg);
        tResponseDTO.setCode(code);
        return tResponseDTO;
    }

    public static <T> ResponseDTO<T> error(ErrorCodeEnum errorCodeEnum) {
        ResponseDTO<T> tResponseDTO = new ResponseDTO();
        tResponseDTO.setMsg(errorCodeEnum.getMsg());
        tResponseDTO.setCode(errorCodeEnum.getCode());
        return tResponseDTO;
    }

    public static <T> ResponseDTO<T> error(String msg) {
        return error(DEFAULT_ERROR_CODE, msg);
    }

    public static <T> ResponseDTO<T> error(String msg, T data) {
        ResponseDTO<T> tResponseDTO = new ResponseDTO();
        tResponseDTO.setMsg(msg);
        tResponseDTO.setCode(DEFAULT_ERROR_CODE);
        tResponseDTO.setData(data);
        return tResponseDTO;
    }

    public static <T> ResponseDTO<T> error() {
        return error(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseDTO{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
