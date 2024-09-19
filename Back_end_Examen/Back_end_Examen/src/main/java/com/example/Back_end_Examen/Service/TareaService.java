package com.example.Back_end_Examen.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Back_end_Examen.IService.ITareaService;
import com.example.Back_end_Examen.Interface.ITarea;
import com.example.Back_end_Examen.Models.Tarea;

@Service
public class TareaService implements ITareaService {
     @Autowired
    private ITarea tareaRepository;// Inyección de dependencia del repositorio de tareas

    // Método para obtener todas las tareas
    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();// Llama al método del repositorio para obtener todas las tareas
    }

     // Método para obtener una tarea específica por su ID
    @Override
    public Optional<Tarea> getTareaById(String id) {
        return tareaRepository.findById(id);// Llama al repositorio para buscar la tarea por ID
    }

    // Método para crear una nueva tarea
    @Override
    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);// Guarda la nueva tarea en el repositorio
    }

    // Método para actualizar una tarea existente
    @Override
    public Tarea updateTarea(String id, Tarea tarea) {
        return tareaRepository.findById(id).map(t -> {
             // Actualiza los campos de la tarea existente
            t.setTitle(tarea.getTitle());
            t.setDueDate(tarea.getDueDate());
            t.setAssignedTo(tarea.getAssignedTo());
            t.setStatus(tarea.getStatus());
            return tareaRepository.save(t);// Guarda la tarea actualizada
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));// Lanza excepción si no se encuentra la tarea
    }

    // Método para eliminar una tarea por su ID
    @Override
    public void deleteTarea(String id) {
        tareaRepository.deleteById(id);// Llama al repositorio para eliminar la tarea por ID
    }
}
