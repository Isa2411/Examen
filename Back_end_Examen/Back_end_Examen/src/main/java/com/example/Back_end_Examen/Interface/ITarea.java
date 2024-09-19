package com.example.Back_end_Examen.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Back_end_Examen.Models.Tarea;

@Repository
public interface ITarea extends JpaRepository<Tarea, String> {

    @Query("SELECT T FROM Tarea T WHERE T.title LIKE %?1% OR T.assignedTo LIKE %?1%")
    List<Tarea> Filtros(String filtros);

    @Query("SELECT T FROM Tarea T WHERE T.assignedTo = ?1")
    Optional<Tarea> findByassignedTo(String assignedTo);

    Optional<Tarea> findBydue_date(String due_date);
}

