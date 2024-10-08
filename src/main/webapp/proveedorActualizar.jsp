<%@ page import="com.tecsup.prj_educacion.modelo.entities.Administrador" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.Proveedor" %>
<%@ page import="com.tecsup.prj_educacion.services.ProveedorService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.ProveedorServiceImpl" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
        String sid = request.getParameter("id");
        ProveedorService servicio = new ProveedorServiceImpl();
        Proveedor proveedor = servicio.buscar(sid);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Proveedor Actualizar - <%= nombre %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">Actualizar Proveedor</h3>
                </div>
                <div class="card-body">
                    <form action="pController" method="post">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código:</label>
                            <input class="form-control" type="text" name="txtCodigo" placeholder="Código"
                                   value="<%= proveedor.getCod_prv() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Razón Social:</label>
                            <input class="form-control" type="text" name="txtRazSoc" placeholder="Razón Social"
                                   value="<%= proveedor.getRaz_soc_prv() %>" autofocus required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Dirección:</label>
                            <input class="form-control" type="text" name="txtDireccion" placeholder="Dirección"
                                   value="<%= proveedor.getDir_prv() %>" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Teléfono:</label>
                            <input class="form-control" type="text" name="txtTelefono" placeholder="Teléfono"
                                   value="<%= proveedor.getTel_prv() %>" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Distrito:</label>
                            <input class="form-control" type="text" name="txtCodDis" placeholder="Código Distrito"
                                   value="<%= proveedor.getCod_dis() %>" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Representante:</label>
                            <input class="form-control" type="text" name="txtRepVen" placeholder="Representante"
                                   value="<%= proveedor.getRep_ven() %>" required>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/>
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
