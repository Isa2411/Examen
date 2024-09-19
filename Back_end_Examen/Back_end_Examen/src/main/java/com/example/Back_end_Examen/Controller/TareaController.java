package com.example.Back_end_Examen.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Back_end_Examen.IService.ITareaService;
import com.example.Back_end_Examen.Models.Tarea;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    // Método para obtener todas las tareas
    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    // Método para obtener una tarea específica por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable String id) {
        Optional<Tarea> tarea = tareaService.getTareaById(id);
        return tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para crear una nueva tarea
    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaService.createTarea(tarea);
    }

     // Método para actualizar una tarea existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable String id, @RequestBody Tarea tarea) {
        try {
            Tarea updatedTarea = tareaService.updateTarea(id, tarea);
            return ResponseEntity.ok(updatedTarea);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para eliminar una tarea por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable String id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.ok().build();
    }
}
