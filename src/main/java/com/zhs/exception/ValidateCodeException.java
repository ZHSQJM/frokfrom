package com.zhs.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/31 15:26
 * @package: com.zhs.exception
 * @description:
 */
public class ValidateCodeException extends AuthenticationException {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
