package spring.security.api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.security.api.Pojos.UserModel;
import spring.security.api.repositories.UserRepository;
import spring.security.api.util.PayloadUtil;
import spring.security.api.util.ServerletResponseUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    private UserModel userModel;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(AppConfig.LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            UserModel creds = new ObjectMapper().readValue(req.getInputStream(), UserModel.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        String username = ((User) auth.getPrincipal()).getUsername();
        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + AppConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(AppConfig.SECRET_KEY.getBytes()));

        Map<String, String> payloadObject = new HashMap<>();
        payloadObject.put("token", token);

        ServerletResponseUtil.setServeletResponse(res, HttpServletResponse.SC_OK, PayloadUtil.setPayload(AppConfig.SUCCESS_MSG, AppConfig.SUCCESS_CODE, "1", payloadObject));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> errors = new HashMap<>();
        errors.put("login", AppConfig.LOGIN_FAILED_MSG);

        Map<String, Object> errorObject = new HashMap<>();
        errorObject.put("error", errors);

        ServerletResponseUtil.setServeletResponse(response, HttpServletResponse.SC_NOT_FOUND, PayloadUtil.setPayload(AppConfig.FAILED_MSG, AppConfig.NOT_FOUND_CODE, "0", errorObject));
    }

}