package study.core.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class MyLogger {

    private String uuid;
    private String requestURL;

    public String getUuid() {
        return uuid;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void log(String msg) {
        log.info("[{}] [{}] : {}", uuid, requestURL, msg);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        log.info("[{}] request scope bean create : {}", uuid, this);
    }

    @PreDestroy
    public void close() {
        log.info("[{}] request scope bean close : {}", uuid, this);
    }
}

