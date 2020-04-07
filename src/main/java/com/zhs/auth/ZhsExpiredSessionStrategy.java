package com.zhs.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/21 21:22
 * @package: com.zhs.auth
 * @description: session超时的策略
 */

public class ZhsExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    private ObjectMapper objectMapper  =  new ObjectMapper();
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","在另一台电脑登录,被迫下线了");
        sessionInformationExpiredEvent
                .getResponse()
                .setContentType("application/json;charset=UTF-8");
        sessionInformationExpiredEvent.getResponse()
                .getWriter().write(objectMapper.writeValueAsString(map));
    }
}
