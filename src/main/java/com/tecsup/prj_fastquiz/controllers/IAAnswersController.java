package com.tecsup.prj_fastquiz.controllers;

import com.tecsup.prj_fastquiz.modelo.entities.IAAnswers;
import com.tecsup.prj_fastquiz.services.IAAnswersService;
import com.tecsup.prj_fastquiz.services.impl.IAAnswersServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IAAnswerController", urlPatterns = {"/iaaController", "/sIAAnswer", "/iaAnswerController"})
public class IAAnswersController extends HttpServlet {

    private IAAnswersService servicio = new IAAnswersServiceImpl(); // Inicializar el servicio

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAAnswers answer = new IAAnswers();

        // Obtener los parámetros del formulario
        String action = request.getParameter("accion");

        try {
            switch (action) {
                case "insertar":
                    // Asignar valores para insertar
                    answer.setAnswerText(request.getParameter("txtAnswerText"));
                    answer.setCorrect(Boolean.parseBoolean(request.getParameter("chkIsCorrect"))); // Checkbox para la corrección
                    answer.setQuestionId(Integer.parseInt(request.getParameter("txtQuestionId")));
                    servicio.grabar(answer); // Llamar al método grabar
                    break;

                case "actualizar":
                    // Asignar valores para actualizar
                    answer.setId(Integer.parseInt(request.getParameter("txtId"))); // Obtener ID desde el formulario
                    answer.setAnswerText(request.getParameter("txtAnswerText"));
                    answer.setCorrect(Boolean.parseBoolean(request.getParameter("chkIsCorrect")));
                    answer.setQuestionId(Integer.parseInt(request.getParameter("txtQuestionId")));
                    servicio.actualizar(answer); // Llamar al método actualizar
                    break;

                case "eliminar":
                    // Asegurarse de que txtId esté presente antes de intentar convertirlo
                    String txtId = request.getParameter("txtId");
                    if (txtId != null && !txtId.isEmpty()) {
                        servicio.borrar(Integer.parseInt(txtId)); // Llamar al método borrar
                    } else {
                        throw new NumberFormatException("ID no proporcionado o vacío"); // Lanzar excepción si el ID es nulo o vacío
                    }
                    break;

                default:
                    // Acción no válida, manejar error
                    response.sendRedirect("error.jsp?message=Acción no válida");
                    return;
            }
            response.sendRedirect("IAAnswersMan.jsp"); // Redirigir a la página de gestión

        } catch (NumberFormatException e) {
            // Manejar excepciones de formato
            response.sendRedirect("error.jsp?message=ID inválido: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción
            response.sendRedirect("error.jsp?message=Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
