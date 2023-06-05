package com.lostsheep.technology.learning.async.upload.domain;

import lombok.*;

/**
 * <b><code>APIResult</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/1.
 *
 * @author dengzhen
 * @since technology-learning
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiVO<T> {

    private Integer code;
    private String message;
    private T data;

    @Getter
    enum ApiEnum {

        /**
         * 成功
         */
        SUCCESS(200, "请求成功"),
        /**
         * 失败
         */
        FAILED(400, "无法处理的请求"),
        /**
         * 异常
         */
        ERROR(500, "服务器内部异常"),
        ;
        private final Integer code;
        private final String message;

        ApiEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public static <R> ApiVO<R> success(R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.SUCCESS.getCode())
                .message(ApiEnum.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <R> ApiVO<R> success(String message, R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.SUCCESS.getCode())
                .message(message)
                .data(data)
                .build();
    }

    public static <R> ApiVO<R> failed(R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.FAILED.getCode())
                .message(ApiEnum.FAILED.getMessage())
                .data(data)
                .build();
    }

    public static <R> ApiVO<R> failed(String message, R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.FAILED.getCode())
                .message(message)
                .data(data)
                .build();
    }

    public static <R> ApiVO<R> error(R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.ERROR.getCode())
                .message(ApiEnum.ERROR.getMessage())
                .data(data)
                .build();
    }

    public static <R> ApiVO<R> error(String message, R data) {
        return ApiVO.<R>builder()
                .code(ApiEnum.ERROR.getCode())
                .message(message)
                .data(data)
                .build();
    }
}
