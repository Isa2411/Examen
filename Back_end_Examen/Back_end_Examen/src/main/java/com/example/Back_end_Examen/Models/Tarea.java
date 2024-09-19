package com.example.Back_end_Examen.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "assigned_to", nullable = false)
    private String assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTarea status;


     // Constructor vacío
    public Tarea() {
    }

    // Constructor con parámetros
    public Tarea(String id, String title, LocalDate dueDate, String assignedTo, EstadoTarea status) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    // Métodos getter y setter para acceder y modificar los campos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public EstadoTarea getStatus() {
        return status;
    }

    public void setStatus(EstadoTarea status) {
        this.status = status;
    }

    public enum EstadoTarea {
        PENDIENTE, FINALIZADA, VENCIDA, TERMINADA_VENCIDA
    }


}
