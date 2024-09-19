package com.example.Back_end_Examen.IService;

import java.util.List;
import java.util.Optional;

import com.example.Back_end_Examen.Models.Tarea;

// Interfaz que define los métodos del servicio para manejar tareas
public interface ITareaService {
    List<Tarea> getAllTareas();// Método para obtener todas las tareas
    Optional<Tarea> getTareaById(String id);// Método para obtener una tarea por su ID
    Tarea createTarea(Tarea tarea);// Método para crear una nueva tarea
    Tarea updateTarea(String id, Tarea tarea);// Método para actualizar una tarea existente
    void deleteTarea(String id);// Método para eliminar una tarea por su ID
}
