package com.caosong.common.utils.result;
import java.io.Serializable;
import lombok.Data;

@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -1802122468331526708L;

    private Integer code; // 状态码
    private String msg ;// 返回信息
    private Object data;// 返回数据


    //自定义code,msg,data
    private Result(Integer code, String msg, Object data) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    //自定义data
    private Result(Object data) {
        this.data = data;
        this.code = ResultCode.SUCCESS;

    }

    //自定义code,msg
    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result() {
        this.code = ResultCode.SUCCESS;

    }

    public static Result error() {
        return new Result(ResultCode.ERROR,null);
    }

    public static Result error(String msg) {
        return new Result(ResultCode.ERROR,msg);
    }

    public static Result error(Object data ,String msg) {
        return new Result(ResultCode.ERROR,msg,data);
    }

    public static Result success() {
        return new Result();
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result success(Object data ,String msg) {
        return new Result(ResultCode.SUCCESS,msg,data);
    }

}
