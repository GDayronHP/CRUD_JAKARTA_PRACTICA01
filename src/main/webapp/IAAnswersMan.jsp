<%@ page import="com.tecsup.prj_educacion.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_educacion.services.IAAnswersService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.IAAnswersServiceImpl" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.IAAnswers" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        String nombre = adm.getName();
        IAAnswersService servicio = new IAAnswersServiceImpl(); // Servicio para manejar las respuestas
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Respuestas - <%= nombre %></title>
</head>
<body>

<div class="container" style="margin-top:70px;">
    <div class="row mt-5">
        <jsp:include page="master.jsp" />

        <h1>Mantenimiento de Respuestas</h1>
        <div style="padding: 10px;">
            <button class="btn btn-success">
                <a class="nav-link link-light" aria-current="page" href="IAAnswersInsertar.jsp">Nueva Respuesta</a>
            </button>
        </div>

        <table class="table table-dark table-hover">
            <tr align="center">
                <th>ID</th>
                <th>Texto de Respuesta</th>
                <th>Es Correcta</th>
                <th>ID de Pregunta</th>
                <th>ACCIONES</th>
            </tr>
            <% for (IAAnswers answer : servicio.listar()) { %>
            <tr>
                <td><%= answer.getId() %></td>
                <td><%= answer.getAnswerText() %></td>
                <td><%= answer.isCorrect() ? "Sí" : "No" %></td>
                <td><%= answer.getQuestionId() %></td>
                <td>
                    <a class="btn btn-warning" href="IAAnswersEliminar.jsp?id=<%= answer.getId() %>">Borrar</a>
                    <a class="btn btn-danger" href="IAAnswersActualizar.jsp?id=<%= answer.getId() %>">Actualizar</a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
<% } %>
</html>
