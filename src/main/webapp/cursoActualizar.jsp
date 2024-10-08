<%@ page import="com.tecsup.prj_educacion.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.Proveedor" %>
<%@ page import="com.tecsup.prj_educacion.services.ProveedorService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.ProveedorServiceImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        String nombre = adm.getName();
        String sid = request.getParameter("id");
        ProveedorService servicio = new ProveedorServiceImpl();
        Proveedor proveedor = servicio.buscar(sid);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Actualizar Proveedor - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">Actualizar Proveedor</h3>
                </div>
                <div class="card-body">
                    <form action="pController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código</label>
                            <input class="form-control" type="text" name="txtCodigo"
                                   value="<%= proveedor.getCod_prv() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Razón Social</label>
                            <input class="form-control" type="text" name="txtRazonSocial"
                                   value="<%= proveedor.getRaz_soc_prv() %>" placeholder="Razón Social" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Dirección</label>
                            <input class="form-control" type="text" name="txtDireccion"
                                   value="<%= proveedor.getDir_prv() %>" placeholder="Dirección" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Teléfono</label>
                            <input class="form-control" type="text" name="txtTelefono"
                                   value="<%= proveedor.getTel_prv() %>" placeholder="Teléfono" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Distrito</label>
                            <input class="form-control" type="text" name="txtCodigoDistrito"
                                   value="<%= proveedor.getCod_dis() %>" placeholder="Código Distrito" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Representante</label>
                            <input class="form-control" type="text" name="txtRepresentante"
                                   value="<%= proveedor.getRep_ven() %>" placeholder="Representante" required>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/><br/>
                            <input class="btn btn-success" type="submit" value="Actualizar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<% } %>
</html>
