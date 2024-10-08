package com.tecsup.prj_educacion.controllers;

import com.tecsup.prj_educacion.modelo.entities.Vendedor;
import com.tecsup.prj_educacion.modelo.daos.VendedorDao;
import com.tecsup.prj_educacion.modelo.daos.impl.VendedorDaoCallableStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VendedorController", urlPatterns = {"/vController"})
public class VendedorController extends HttpServlet {

    private final VendedorDao vendedorDao = new VendedorDaoCallableStatement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String codigo = request.getParameter("id");

        if ("eliminar".equals(accion)) {
            vendedorDao.delete(codigo);
            response.sendRedirect("vendedorMan.jsp");
        } else if ("editar".equals(accion)) {
            Vendedor vendedor = vendedorDao.find(codigo);
            request.setAttribute("vendedor", vendedor);
            request.getRequestDispatcher("vendedorEditar.jsp").forward(request, response);
        } else {
            response.sendRedirect("vendedorMan.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        Vendedor vendedor = new Vendedor();
        vendedor.setCod_ven(request.getParameter("txtCodigo"));
        vendedor.setNom_ven(request.getParameter("txtNombre"));
        vendedor.setApe_ven(request.getParameter("txtApellido"));
        vendedor.setSue_ven(request.getParameter("txtSueldo"));
        vendedor.setFec_ing(request.getParameter("txtFechaIngreso"));
        vendedor.setTip_ven(Integer.parseInt(request.getParameter("txtTipo")));
        vendedor.setUsu_ven(request.getParameter("txtUsuario"));
        vendedor.setPas_ven(request.getParameter("txtPassword"));

        switch (accion) {
            case "insertar":
                vendedorDao.create(vendedor);
                break;
            case "actualizar":
                vendedorDao.update(vendedor);
                break;
        }
        response.sendRedirect("vendedorMan.jsp");
    }
}
