package com.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String USER = "sagar";
    private static final String PASS = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String u = request.getParameter("username");
        String p = request.getParameter("password");

        if (USER.equals(u) && PASS.equals(p)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", u);
            response.sendRedirect("welcome.jsp");
        } else {
            // If login fails, go back to login.html
            response.sendRedirect("login.jsp");
        }
    }
}