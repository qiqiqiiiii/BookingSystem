package com.njupt.common.exception;

import com.njupt.common.result.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "自定义全局异常")
public class SystemException extends RuntimeException {
    @ApiModelProperty(value = "异常状态码")
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     */
    public SystemException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     */
    public SystemException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "SystemException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
