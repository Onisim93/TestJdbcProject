package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.io.IOException;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {

    private UserRepository repository;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repository = new UserRepository();
        userService = new UserService(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Boolean isAuth = false;

        if (username != null && password != null) {
            isAuth = userService.authentication(username, password);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(isAuth);
    }
}
