package spring.security.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import spring.security.api.Pojos.ResponsePayload;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerletResponseUtil {

    public static void setServeletResponse(HttpServletResponse response, int statusCode, ResponsePayload payload) throws IOException {
        response.setStatus(statusCode);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(payload));
    }
}
