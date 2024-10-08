<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_fastquiz.services.IAAnswersService" %>
<%@ page import="com.tecsup.prj_fastquiz.services.impl.IAAnswersServiceImpl" %>
<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.IAAnswers" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        IAAnswersService servicio = new IAAnswersServiceImpl(); // Servicio para manejar las respuestas
        int id = Integer.parseInt(request.getParameter("id"));
        IAAnswers answer = servicio.buscar(id);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Actualizar Respuesta</title>
</head>
<body>

<div class="container" style="margin-top:70px;">
    <div class="row mt-5">
        <jsp:include page="master.jsp" />

        <h1>Actualizar Respuesta</h1>
        <form action="iaAnswerController" method="POST">
            <input type="hidden" name="txtId" value="<%= answer.getId() %>">
            <div class="input-group mt-2">
                <label class="input-group-text">Texto de Respuesta:</label>
                <input class="form-control" type="text" name="txtAnswerText" value="<%= answer.getAnswerText() %>" required>
            </div>
            <div class="input-group mt-2">
                <label class="input-group-text">¿Es Correcta?</label>
                <select class="form-control" name="chkIsCorrect">
                    <option value="true" <%= answer.isCorrect() ? "selected" : "" %>>Sí</option>
                    <option value="false" <%= !answer.isCorrect() ? "selected" : "" %>>No</option>
                </select>
            </div>
            <div class="input-group mt-2">
                <label class="input-group-text">ID de Pregunta:</label>
                <input class="form-control" type="number" name="txtQuestionId" value="<%= answer.getQuestionId() %>" required>
            </div>
            <div class="form-group mt-4 d-grid gap-2">
                <input name="accion" type="hidden" value="actualizar">
                <input class="btn btn-danger" type="submit" value="Actualizar">
            </div>
        </form>
    </div>
</div>
</body>
<% } %>
</html>
