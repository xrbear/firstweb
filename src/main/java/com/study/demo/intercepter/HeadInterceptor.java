package com.study.demo.intercepter;

import com.study.demo.util.HeadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：xurong02
 * @date ：2023/2/15 10:11 上午
 */
@Component
public class HeadInterceptor implements HandlerInterceptor {
    ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String header = request.getHeader("qf-auth-token");
        if (StringUtils.isBlank(header)){
            return true;
        }
        String[] strings = header.split("--item--");
        String companyUuid = strings[0];

        HeadUtil.setThreadLocal(companyUuid);
        return true;
    }
}
