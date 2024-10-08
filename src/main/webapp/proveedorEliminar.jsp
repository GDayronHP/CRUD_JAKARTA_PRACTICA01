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
  <title>Eliminar Proveedor - <%= nombre %></title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
  <div class="row">
    <div class="col-md-8 mx-auto">
      <div class="card text-center">
        <div class="card-header">
          <h3 class="text-uppercase">Eliminar Proveedor</h3>
        </div>
        <div class="card-body">
          <form action="pController" method="post">
            <div class="input-group mt-2">
              <label class="input-group-text">Código:</label>
              <input class="form-control" type="text" name="txtCodigo"
                     value="<%= proveedor.getCod_prv() %>" readonly>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Razón Social:</label>
              <input class="form-control" type="text" name="txtRazonSocial"
                     value="<%= proveedor.getRaz_soc_prv() %>" readonly>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Dirección:</label>
              <input class="form-control" type="text" name="txtDireccion"
                     value="<%= proveedor.getDir_prv() %>" readonly>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Teléfono:</label>
              <input class="form-control" type="text" name="txtTelefono"
                     value="<%= proveedor.getTel_prv() %>" readonly>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Código Distrito:</label>
              <input class="form-control" type="text" name="txtCodigoDistrito"
                     value="<%= proveedor.getCod_dis() %>" readonly>
            </div>

            <div class="input-group mt-2">
              <label class="input-group-text">Representante:</label>
              <input class="form-control" type="text" name="txtRepresentante"
                     value="<%= proveedor.getRep_ven() %>" readonly>
            </div>

            <div class="form-group mt-4 d-grid gap-2">
              <!-- Solo se necesita el código para eliminar el proveedor -->
              <input name="accion" type="hidden" value="eliminar"/>
              <input name="codigo" type="hidden" value="<%= proveedor.getCod_prv() %>"/>
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
