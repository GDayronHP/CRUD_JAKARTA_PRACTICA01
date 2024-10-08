<%@ page import="com.tecsup.prj_educacion.modelo.entities.Administrador" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.Vendedor" %>
<%@ page import="com.tecsup.prj_educacion.services.VendedorService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.VendedorServiceImpl" %>
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
    VendedorService servicio = new VendedorServiceImpl();
    Vendedor vendedor = servicio.buscar(sid);
%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Actualizar Vendedor - <%= nombre %></title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
  <div class="row">
    <div class="col-md-8 mx-auto">
      <div class="card text-center">
        <div class="card-header">
          <h3 class="text-uppercase">Actualizar Vendedor</h3>
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
                     value="<%= vendedor.getNom_ven() %>" placeholder="Nombre" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Apellido</label>
              <input class="form-control" type="text" name="txtApellido"
                     value="<%= vendedor.getApe_ven() %>" placeholder="Apellido" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Sueldo</label>
              <input class="form-control" type="text" name="txtSueldo"
                     value="<%= vendedor.getSue_ven() %>" placeholder="Sueldo" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Fecha de Ingreso</label>
              <input class="form-control" type="text" name="txtFecIngreso"
                     value="<%= vendedor.getFec_ing() %>" placeholder="Fecha de Ingreso" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Tipo de Vendedor</label>
              <input class="form-control" type="text" name="txtTipoVendedor"
                     value="<%= vendedor.getTip_ven() %>" placeholder="Tipo de Vendedor" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Usuario</label>
              <input class="form-control" type="text" name="txtUsuario"
                     value="<%= vendedor.getUsu_ven() %>" placeholder="Usuario" required>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Contraseña</label>
              <input class="form-control" type="password" name="txtContraseña"
                     value="<%= vendedor.getPas_ven() %>" placeholder="Contraseña" required>
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
