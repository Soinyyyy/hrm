package org.soin.exception;

import org.soin.util.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 定义全局的Global异常
 * 在所有的controller都可以使用它来操作异常数据
 */
@RestControllerAdvice
/**
 * @RestControllerAdvice
 * 在Controller之前或者之后执行
 */
public class CommonGlobalException {
    /**
     * 返回的是一个AjaxResult
     * success为false
     * message为获取的Global异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = GlobalException.class)
    public AjaxResult handleExceptionGlobal(GlobalException e){
        return AjaxResult.me().setSuccess(false).setMessage(e.getMessage());
    }

    /**
     * 返回未知错误
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult handleExceptionGlobal(Exception e){
        e.printStackTrace();
        return AjaxResult.me().setSuccess(false).setMessage("全局异常系统错误请重试");
    }

}
