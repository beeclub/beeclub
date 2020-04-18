package cn.h.beeclub.core.util;

public class EncodeUtils {

    public static String encodePwd(String pwd){
        return Integer.toHexString(pwd.hashCode() + 1998);
    }
}
