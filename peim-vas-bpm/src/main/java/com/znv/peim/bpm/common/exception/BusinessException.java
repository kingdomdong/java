package com.znv.peim.bpm.common.exception;

import com.znv.peim.bpm.common.result.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Business Exception for APIs
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-14 17:16:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private Integer code;
    private String message;

    public BusinessException(ResultCodeEnum code) {
        this.code = code.getCode();
        this.message = code.getName();
    }

}
