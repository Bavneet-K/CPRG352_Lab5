/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.User;
import services.AccountService;

/**
 *
 * @author Bavneet
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(user != null){
            response.sendRedirect("home");
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
//        HttpSession session = request.getSession();
//        
//        String user = (String) request.getAttribute("username");
//        String password = (String) request.getAttribute("password");
//        String operation = request.getParameter("operation");
//        
//        if( operation != null && operation.equals("Log in") ){}
//        
//        if(user == "abe" || user == "barb" && password == "password"){
//            request.setAttribute("name", user);
//            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//        }
//        else{
//            session.invalidate();
//            session = request.getSession();
//        }
//        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountService accountService = new AccountService();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = user = accountService.login(username, password);
        session.setAttribute("user", user);
        
        if (user == null){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("home");
        }
    }

}
