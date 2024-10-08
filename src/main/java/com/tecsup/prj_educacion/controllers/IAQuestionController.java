package com.tecsup.prj_educacion.controllers;

import com.tecsup.prj_educacion.modelo.entities.IAQuestion;
import com.tecsup.prj_educacion.services.IAQuestionService;
import com.tecsup.prj_educacion.services.impl.IAQuestionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IAQuestionController", urlPatterns = {"/iaqController", "/sIAQuestion", "/iaQuestionController"})
public class IAQuestionController extends HttpServlet {

    private IAQuestionService servicio = new IAQuestionServiceImpl(); // Inicializar el servicio

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAQuestion question = new IAQuestion();

        String action = request.getParameter("accion");

        try {
            switch (action) {
                case "insertar":
                    // Asignar valores para insertar
                    question.setQuestionText(request.getParameter("txtQuestionText"));
                    question.setTimeLimit(String.valueOf(Integer.parseInt(request.getParameter("txtTimeLimit")))); // Asegúrate de que sea un entero
                    question.setQuizId(Integer.parseInt(request.getParameter("txtQuizId")));
                    question.setQuestionTypeId(Integer.parseInt(request.getParameter("txtQuestionTypeId")));
                    servicio.grabar(question); // Llamar al método grabar
                    break;

                case "actualizar":
                    // Asignar valores para actualizar
                    question.setId(Integer.parseInt(request.getParameter("txtId"))); // Obtener ID desde el formulario
                    question.setQuestionText(request.getParameter("txtQuestionText"));
                    question.setTimeLimit(String.valueOf(Integer.parseInt(request.getParameter("txtTimeLimit")))); // Asegúrate de que sea un entero
                    question.setQuizId(Integer.parseInt(request.getParameter("txtQuizId")));
                    question.setQuestionTypeId(Integer.parseInt(request.getParameter("txtQuestionTypeId")));
                    servicio.actualizar(question); // Llamar al método actualizar
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
            response.sendRedirect("IAQuestionMan.jsp"); // Redirigir a la página de gestión

        } catch (NumberFormatException e) {
            // Manejar excepciones de formato
            response.sendRedirect("error.jsp?message=ID o formato inválido: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción
            response.sendRedirect("error.jsp?message=Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
