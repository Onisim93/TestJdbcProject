package org.example.exception;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class ExceptionHandler implements Filter {

    private ObjectMapper mapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mapper = new ObjectMapper();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        catch (NumberFormatException e) {
            sendError((HttpServletResponse) servletResponse, HttpServletResponse.SC_BAD_REQUEST, "invalid ID");
        }
        catch (IllegalArgumentException e) {
            sendError((HttpServletResponse) servletResponse, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
        catch (IOException | ServletException e ) {
            sendError((HttpServletResponse) servletResponse, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void sendError(HttpServletResponse response, int statusCode, String message) throws IOException {
        try {
            response.setStatus(statusCode);
            response.setContentType("application/json");
            ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
            response.getWriter().write(mapper.writeValueAsString(errorResponse));
        }
        catch (IOException e) {
            response.setStatus(500);
        }
    }
}
