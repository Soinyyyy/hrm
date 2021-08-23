package org.soin.util;


import org.soin.exception.GlobalException;
import org.springframework.util.StringUtils;

/**
 * 断言工具类的抽取
 * 如果为什么什么我就直接通过
 * 如果报错我就直接报错
 * 那么我们就可以不用写Try cath
 * 避免代码冗余不停的Ajaxresult
 */
public class AssertUtils {
    //你是空我就报错
    public static void isNull(Object object, String message){
        if(object == null){
            throw new GlobalException(message);
        }
        if(object instanceof String){
            if(StringUtils.isEmpty((String)object)){
                throw new GlobalException(message);
            }
        }
    }
    //不是信用码 我就报错
    public static void isNotLicense(String num, String message){
        if( !ValidatorUtils.isLicense15(num) && !ValidatorUtils.isLicense18(num)){
            throw new GlobalException(message);
        }
    }
    //不是信用码 我就报错
    public static void isNotMobile(String mobile, String message){
        if( !ValidatorUtils.isMobile(mobile)){
            throw new GlobalException(message);
        }
    }
    //是true 我就报错
    public static void isTrue(boolean flag, String message){
        if( flag ){
            throw new GlobalException(message);
        }
    }
    //是false 我就报错
    public static void isFalse(boolean flag, String message){
        isTrue(!flag,message);
    }
}
