package com.duan.util;

/**
 * ThreadLocal工具类，用于全局存储用户信息
 */
public class TenantKeyContext{
 
    private static final ThreadLocal<String> TENANT_KEY = new ThreadLocal<String>();
 
    public static void setTenantKey(String tenantKey) {
        TENANT_KEY.set(tenantKey);
    }
 
    public static String getTenantKey() {
        return TENANT_KEY.get();
    }
 
    public static void remove(){
        TENANT_KEY.remove();
    }
}