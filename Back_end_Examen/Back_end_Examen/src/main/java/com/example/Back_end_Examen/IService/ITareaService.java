package com.example.Back_end_Examen.IService;

import java.util.List;
import java.util.Optional;

import com.example.Back_end_Examen.Models.Tarea;

public interface ITareaService {
    List<Tarea> getAllTareas();
    Optional<Tarea> getTareaById(String id);
    Tarea createTarea(Tarea tarea);
    Tarea updateTarea(String id, Tarea tarea);
    void deleteTarea(String id);
}
