package com.imooc.domain.servlet.utils;

import javax.servlet.http.Cookie;

/**
 * Created by TangTian on 2018/7/27.
 */
public class CookieUtils {
    public static Cookie findCook(Cookie[] cookies, String name) {
        if (cookies == null) {
            //说明客户端没有携带Cookie
            return null;
        } else {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
            return null;
        }
    }
}
