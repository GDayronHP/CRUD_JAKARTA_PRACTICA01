package com.tecsup.prj_fastquiz.controllers;

import com.tecsup.prj_fastquiz.modelo.entities.User;
import com.tecsup.prj_fastquiz.services.UserService;
import com.tecsup.prj_fastquiz.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = {"/sValidador", "/admin"})
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sUsuario = request.getParameter("txtname");
        String sPassword = request.getParameter("txtpassword");

        UserService servicio = new UserServiceImpl();

        User adm = servicio.validar(sUsuario, sPassword);

        if(adm!=null){
            request.getSession().setAttribute("eladministrador", adm);
            response.sendRedirect("principal.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }
}

