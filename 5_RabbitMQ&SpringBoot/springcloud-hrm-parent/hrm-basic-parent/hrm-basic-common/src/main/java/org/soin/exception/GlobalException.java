package org.soin.exception;

/**
 * 自定义局部异常
 * GlobalException
 * 主要返回一些友好的信息返回给前台查看
 */
public class GlobalException extends RuntimeException{
    //返回一个异常信息是String类型的
    public GlobalException (String message){
        super(message);
    }
}
