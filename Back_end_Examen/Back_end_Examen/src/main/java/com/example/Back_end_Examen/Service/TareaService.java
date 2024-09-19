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
    private ITarea tareaRepository;

    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> getTareaById(String id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea updateTarea(String id, Tarea tarea) {
        return tareaRepository.findById(id).map(t -> {
            t.setTitle(tarea.getTitle());
            t.setDueDate(tarea.getDueDate());
            t.setAssignedTo(tarea.getAssignedTo());
            t.setStatus(tarea.getStatus());
            return tareaRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    @Override
    public void deleteTarea(String id) {
        tareaRepository.deleteById(id);
    }
}
