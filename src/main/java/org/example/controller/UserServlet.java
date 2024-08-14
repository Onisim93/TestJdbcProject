package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.UserDto;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private UserService userService;
    private ObjectMapper objectMapper;


    @Override
    public void init(ServletConfig config) throws ServletException {
        UserRepository ur = new UserRepository();
        this.userService = new UserService(ur);
        objectMapper = new ObjectMapper();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path == null || path.equals("/") || path.isEmpty()) {
            List<UserDto> dtos = userService.findAll();

            String json = objectMapper.writeValueAsString(dtos);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }
        else {
            String[] paths = path.split("/");
            if (paths.length > 1) {
                Integer id = Integer.parseInt(paths[1]);
                UserDto userDto = userService.findById(id);
                String json = objectMapper.writeValueAsString(userDto);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.setContentType("application/json");
                resp.getWriter().write(json);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] paths = path.split("/");
        if (paths.length > 1) {
            Integer id = Integer.parseInt(paths[1]);
            userService.deleteById(id);

            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || path.equals("/") || path.isEmpty()) {
            UserDto userDto = objectMapper.readValue(req.getReader(), UserDto.class);
            UserDto createdDto = userService.create(userDto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(createdDto));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] paths = path.split("/");
        if (paths.length > 1) {
            Integer id = Integer.parseInt(paths[1]);
            UserDto userDto = objectMapper.readValue(req.getReader(), UserDto.class);
            UserDto updated = userService.put(id, userDto);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(updated));
        }

    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] paths = path.split("/");
        if (paths.length > 1) {
            Integer id = Integer.parseInt(paths[1]);
            UserDto userDto = objectMapper.readValue(req.getReader(), UserDto.class);
            UserDto patchedDto = userService.patch(id, userDto);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(patchedDto));
        }
    }
}
