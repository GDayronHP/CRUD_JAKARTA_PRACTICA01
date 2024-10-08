package com.tecsup.prj_educacion.services;

import com.tecsup.prj_educacion.modelo.entities.IAQuestion;

import java.util.List;

public interface IAQuestionService {
    public void grabar(IAQuestion question);
    public IAQuestion buscar(int id);
    public List<IAQuestion> listar();
    public void actualizar(IAQuestion question);
    public void borrar(int id);
    // Puedes agregar más métodos específicos si es necesario
}
