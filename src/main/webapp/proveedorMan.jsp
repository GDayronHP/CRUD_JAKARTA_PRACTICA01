<%@ page import="com.tecsup.prj_educacion.modelo.entities.Administrador" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.Proveedor" %>
<%@ page import="com.tecsup.prj_educacion.services.ProveedorService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.ProveedorServiceImpl" %>
<%@ page import="java.util.List" %> <!-- Importar java.util.List -->
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
    ProveedorService servicio = new ProveedorServiceImpl();
    List<Proveedor> proveedores = servicio.listar(); // Asegúrate de que listar() devuelve una lista de Proveedores
%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Mantenimiento de Proveedores - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
  <div class="row">
    <div class="col-md-12">
      <h1>Mantenimiento de Proveedores</h1>
      <div style="padding: 10px;">
        <button class="btn btn-danger">
          <a class="nav-link link-light" aria-current="page" href="proveedorInsertar.jsp">Nuevo Vendedor</a>
        </button>
      </div>
      <table class="table table-dark table-hover">
        <thead>
        <tr>
          <th>Código</th>
          <th>Razón Social</th>
          <th>Dirección</th>
          <th>Teléfono</th>
          <th>Código Distrito</th>
          <th>Representante</th>
          <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
          for (Proveedor proveedor : proveedores) {
        %>
        <tr>
          <td><%= proveedor.getCod_prv() %></td>
          <td><%= proveedor.getRaz_soc_prv() %></td>
          <td><%= proveedor.getDir_prv() %></td>
          <td><%= proveedor.getTel_prv() %></td>
          <td><%= proveedor.getCod_dis() %></td>
          <td><%= proveedor.getRep_ven() %></td>
          <td>
            <a class="btn btn-warning" href="proveedorEliminar.jsp?id=<%= proveedor.getCod_prv() %>">
              <i class="fa-solid fa-trash"></i> Borrar
            </a>
            <a class="btn btn-success" href="proveedorActualizar.jsp?id=<%= proveedor.getCod_prv() %>">
              <i class="fa-solid fa-pencil"></i> Actualizar
            </a>
          </td>
        </tr>
        <%
          }
        %>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
<%
  }
%>