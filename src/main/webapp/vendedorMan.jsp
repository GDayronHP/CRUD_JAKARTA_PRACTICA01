<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Vendedor" %>
<%@ page import="com.tecsup.prj_fastquiz.services.VendedorService" %>
<%@ page import="com.tecsup.prj_fastquiz.services.impl.VendedorServiceImpl" %>
<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Administrador" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
  HttpSession misesion = request.getSession();
  if(misesion.getAttribute("eladministrador") == null){
    response.sendRedirect("error.jsp");
  } else {
    Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
    String nombre = adm.getNombres() + " " + adm.getApellidos();
    VendedorService servicio = new VendedorServiceImpl();
%>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Mantenimiento de Vendedores - <%= nombre %></title>
</head>
<body>

<div class="container" style="margin-top:70px ;">
  <div class="row mt-5">

    <jsp:include page="master.jsp" />

    <h1>Mantenimiento de Vendedores</h1>
    <div style="padding: 10px;">
      <button class="btn btn-danger">
        <a class="nav-link link-light" aria-current="page" href="vendedorInsertar.jsp">Nuevo Vendedor</a>
      </button>
    </div>

    <table class="table table-dark table-hover">
      <tr align="center">
        <th>CÓDIGO</th>
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>SUELDO</th>
        <th>FECHA INGRESO</th>
        <th>TIPO</th>
        <th>USUARIO</th>
        <th>ACCIONES</th>
      </tr>
      <% for (Vendedor vendedor : servicio.listar()) { %>
      <tr>
        <td><%= vendedor.getCod_ven() %></td>
        <td><%= vendedor.getNom_ven() %></td>
        <td><%= vendedor.getApe_ven() %></td>
        <td><%= vendedor.getSue_ven() %></td>
        <td><%= vendedor.getFec_ing() %></td>
        <td><%= vendedor.getTip_ven() %></td>
        <td><%= vendedor.getUsu_ven() %></td>
        <td>
          <a class="btn btn-warning" href="vendedorEliminar.jsp?id=<%= vendedor.getCod_ven() %>">
            <i class="fa-solid fa-trash"></i> Borrar
          </a>
          <a class="btn btn-danger" href="vendedorActualizar.jsp?id=<%= vendedor.getCod_ven() %>">
            <i class="fa-solid fa-pencil"></i> Actualizar
          </a>
        </td>
      </tr>
      <% } %>
    </table>
  </div>
</div>
</body>
<% } %>
</html>
