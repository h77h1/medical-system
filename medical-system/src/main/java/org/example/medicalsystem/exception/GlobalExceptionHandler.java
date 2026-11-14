package org.example.medicalsystem.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 核心注解：拦截所有 Controller 抛出的异常
public class GlobalExceptionHandler {

    // 专门拦截 @Validated 校验失败的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();

        // 遍历所有校验失败的字段，提取我们自己写的 message
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // 返回给前端的 JSON 就会是这个 errors 的内容
        return errors;
    }

    // 拦截自定义的业务异常
    @ExceptionHandler(BusinessException.class)
    public Map<String, String> handleBusinessException(BusinessException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage()); // 提取我们抛出的友好提示
        return errorMap;
    }
}