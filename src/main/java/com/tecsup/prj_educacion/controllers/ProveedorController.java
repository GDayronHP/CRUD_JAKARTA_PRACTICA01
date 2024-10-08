package com.tecsup.prj_educacion.controllers;

import com.tecsup.prj_educacion.modelo.entities.Proveedor;
import com.tecsup.prj_educacion.modelo.daos.ProveedorDao;
import com.tecsup.prj_educacion.modelo.daos.impl.ProveedorDaoCallableStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProveedorController", urlPatterns = {"/pController"})
public class ProveedorController extends HttpServlet {

    private final ProveedorDao proveedorDao = new ProveedorDaoCallableStatement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String codigo = request.getParameter("id");

        if ("eliminar".equals(accion)) {
            proveedorDao.delete(codigo);
            response.sendRedirect("proveedorMan.jsp");
        } else if ("editar".equals(accion)) {
            Proveedor proveedor = proveedorDao.find(codigo);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("proveedorEditar.jsp").forward(request, response);
        } else {
            response.sendRedirect("proveedorMan.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        Proveedor proveedor = new Proveedor();
        proveedor.setCod_prv(request.getParameter("txtCodigo"));
        proveedor.setRaz_soc_prv(request.getParameter("txtRazonSocial"));
        proveedor.setDir_prv(request.getParameter("txtDireccion"));
        proveedor.setTel_prv(Integer.parseInt(request.getParameter("txtTelefono")));
        proveedor.setCod_dis(request.getParameter("txtCodigoDistrito"));
        proveedor.setRep_ven(request.getParameter("txtRepresentante"));

        switch (accion) {
            case "insertar":
                proveedorDao.create(proveedor);
                break;
            case "actualizar":
                proveedorDao.update(proveedor);
                break;
        }
        response.sendRedirect("proveedorMan.jsp");
    }
}
