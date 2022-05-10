package com.backend.Authentication.config;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backend.UserManagement.Exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        final String expired = (String) request.getAttribute("expired");
        System.out.println(expired);
        if (expired!=null) {
            String message = new ErrorMessage(
                    HttpStatus.UNAUTHORIZED.value(),
                    new Date(),
                    "JWT token expired",
                    request.getRequestURI())
                    .toJson();

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(message);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized LOL");
        }
    }
}
