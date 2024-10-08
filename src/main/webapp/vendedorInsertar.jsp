<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Administrador" %>
<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Vendedor" %>
<%@ page import="com.tecsup.prj_fastquiz.services.VendedorService" %>
<%@ page import="com.tecsup.prj_fastquiz.services.impl.VendedorServiceImpl" %>
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
%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Nuevo Vendedor</title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
  <div class="row">
    <div class="col-md-6 mx-auto">
      <div class="card text-center">
        <div class="card-header">
          <h3 class="text-uppercase">CREAR VENDEDOR</h3>
        </div>
        <div class="card-body">
          <form action="vController" method="post">
            <div class="input-group mt-2">
              <label class="input-group-text">Código:</label>
              <input class="form-control" type="text" name="txtCodigo" id="codven" placeholder="Código" autofocus required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Nombre:</label>
              <input class="form-control" type="text" name="txtNombre" id="nomven" placeholder="Nombre" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Apellido:</label>
              <input class="form-control" type="text" name="txtApellido" id="apeven" placeholder="Apellido" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Sueldo:</label>
              <input class="form-control" type="text" name="txtSueldo" id="sueven" placeholder="Sueldo" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Fecha de Ingreso:</label>
              <input class="form-control" type="text" name="txtFechaIngreso" id="fecven" placeholder="Fecha de Ingreso" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Tipo:</label>
              <input class="form-control" type="number" name="txtTipo" id="tipven" placeholder="Tipo" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Usuario:</label>
              <input class="form-control" type="text" name="txtUsuario" id="usuven" placeholder="Usuario" required>
            </div>
            <div class="input-group mt-2">
              <label class="input-group-text">Contraseña:</label>
              <input class="form-control" type="password" name="txtPassword" id="pasven" placeholder="Contraseña" required>
            </div>

            <div class="form-group mt-4 d-grid gap-2">
              <input name="accion" type="hidden" value="insertar"/>
              <input class="btn btn-success" type="submit" value="Insertar"/>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<% } %>
</body>
</html>
