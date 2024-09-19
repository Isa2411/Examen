package com.example.Back_end_Examen.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Back_end_Examen.Models.Tarea;

@Repository
public interface ITarea extends JpaRepository<Tarea, String> {

    // Consulta para filtrar tareas por título o persona asignada
    @Query("SELECT T FROM Tarea T WHERE T.title LIKE %?1% OR T.assignedTo LIKE %?1%")
    List<Tarea> Filtros(String filtros);// Devuelve una lista de tareas que coinciden con el filtro

    // Consulta para encontrar una tarea asignada a una persona específica
    @Query("SELECT T FROM Tarea T WHERE T.assignedTo = ?1")
    Optional<Tarea> findByassignedTo(String assignedTo);// Devuelve una tarea si se encuentra

    // Método para encontrar una tarea por su fecha de vencimiento
    Optional<Tarea> findBydue_date(String due_date);// Devuelve una tarea si se encuentra
}

