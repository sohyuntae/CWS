package com.api.cws.interceptor;

import com.api.cws.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

import static javax.servlet.http.HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION;

@Slf4j
@Controller
/*
   maxAge : 클라이언트에서 preflight 의 요청 결과를 저장할 기간을 지정
            3600초 동안 preflight 요청을 캐시하는 설정으로, 첫 요청 이후 60초 동안은 OPTIONS 메소드를 사용하는 예비 요청을 보내지 않는다.
   allowCredentials : 클라이언트 요청이 쿠키를 통해서 자격 증명을 해야 하는 경우에 true.
   exposedHeaders : 기본적으로 브라우저에게 노출이 되지 않지만, 브라우저 측에서 접근할 수 있게 허용해주는 헤더를 지정
* */
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class interceptor implements HandlerInterceptor {
    private final JwtTokenProvider jwtTokenProvider;

    public interceptor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("requestIP : " + request.getRemoteAddr() + "  => requestURI : " + requestURI);

        if (!Objects.equals(requestURI, "/Login")) {
            String token = request.getHeader("Authorization");
            boolean isValidToken = jwtTokenProvider.validateToken(token);
            if(!isValidToken) {
                response.setStatus(SC_NON_AUTHORITATIVE_INFORMATION);
                return false;
            }
            // 토큰 생성.
        }

        return true;
    }
}
