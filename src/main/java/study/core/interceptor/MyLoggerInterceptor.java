package study.core.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import study.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RequiredArgsConstructor
@Component
public class MyLoggerInterceptor implements HandlerInterceptor {

    private final MyLogger myLogger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String uuid = myLogger.getUuid();
        String requestURL = request.getRequestURL().toString();

        log.info("[{}] [{}] : interceptor", uuid, requestURL);

        return true;

    }
}


