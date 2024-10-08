package com.tecsup.prj_educacion.services;

import com.tecsup.prj_educacion.modelo.entities.IAAnswers;

import java.util.List;

public interface IAAnswersService {
    public void grabar(IAAnswers answer);
    public IAAnswers buscar(int id);
    public List<IAAnswers> listar();
    public void actualizar(IAAnswers answer);
    public void borrar(int id);
    // Puedes agregar más métodos específicos si es necesario
}
