<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Administrador" %>
<%@ page import="com.tecsup.prj_fastquiz.services.VendedorService" %>
<%@ page import="com.tecsup.prj_fastquiz.services.impl.VendedorServiceImpl" %>
<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Vendedor" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        VendedorService servicio = new VendedorServiceImpl();
        Vendedor vendedor = servicio.buscar(sid);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Vendedor - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ELIMINAR VENDEDOR</h3>
                </div>
                <div class="card-body">
                    <form action="vController" method="post">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código</label>
                            <input class="form-control" type="text" name="txtCodigo"
                                   value="<%= vendedor.getCod_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Nombre</label>
                            <input class="form-control" type="text" name="txtNombre"
                                   value="<%= vendedor.getNom_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Apellido</label>
                            <input class="form-control" type="text" name="txtApellido"
                                   value="<%= vendedor.getApe_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Sueldo</label>
                            <input class="form-control" type="text" name="txtSueldo"
                                   value="<%= vendedor.getSue_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha de Ingreso</label>
                            <input class="form-control" type="text" name="txtFechaIngreso"
                                   value="<%= vendedor.getFec_ing() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Tipo</label>
                            <input class="form-control" type="text" name="txtTipo"
                                   value="<%= vendedor.getTip_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Usuario</label>
                            <input class="form-control" type="text" name="txtUsuario"
                                   value="<%= vendedor.getUsu_ven() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Contraseña</label>
                            <input class="form-control" type="text" name="txtPassword"
                                   value="<%= vendedor.getPas_ven() %>" readonly>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="eliminar"/>
                            <input class="btn btn-danger" type="submit" value="Eliminar"/>
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
