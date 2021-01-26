package spring.security.api.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import spring.security.api.util.PayloadUtil;
import spring.security.api.util.ServerletResponseUtil;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        Map<String, String> errors = new HashMap<>();
        errors.put("access", AppConfig.UNAUTHORIZED_MSG);

        Map<String, Object> errorObject = new HashMap<>();
        errorObject.put("error", errors);

        ServerletResponseUtil.setServeletResponse(response, HttpServletResponse.SC_UNAUTHORIZED, PayloadUtil.setPayload(AppConfig.FAILED_MSG, AppConfig.UNAUTHORIZED_CODE, "0", errorObject));
    }
}