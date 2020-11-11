package com.znv.peim.bpm.common.result;


import com.znv.peim.bpm.common.exception.BusinessException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class Result<T> {

    /**
     * 默认返回状态码
     */
    private int code = ResultCodeEnum.NORMAL.getCode();
    /**
     * 默认返回状态说明
     */
    private String message = ResultCodeEnum.NORMAL.getName();

    /**
     * 返回数据对象
     */
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> error(BusinessException e) {
        return new Result<>(e.getCode(), e.getMessage());
    }

    public static Result<?> error(HttpStatus httpStatus) {
        return new Result<>(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static Result<?> error(int value, String message) {
        return new Result<>(value, message);
    }

}
