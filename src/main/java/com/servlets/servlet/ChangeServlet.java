package com.servlets.servlet;

import com.servlets.entity.User;
import com.servlets.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change")
public class ChangeServlet extends HttpServlet {
    private final UserDAO userDAO = UserDAO.getInctance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder()
                .id(Integer.parseInt(req.getParameter("id")))
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .age(Integer.valueOf(req.getParameter("age")))
                .build();
        userDAO.update(user);
        resp.sendRedirect("/");
    }


}
