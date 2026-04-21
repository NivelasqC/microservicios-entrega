package com.example.citasmedicas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "CITAS_MEDICAS")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE_PACIENTE", nullable = false, length = 100)
    private String nombrePaciente;

    @Column(name = "NOMBRE_MEDICO", nullable = false, length = 100)
    private String nombreMedico;

    @Column(name = "ESPECIALIDAD", nullable = false, length = 80)
    private String especialidad;

    @Column(name = "FECHA_CITA", nullable = false)
    private LocalDate fecha;

    @Column(name = "HORA_CITA", nullable = false, length = 5)
    private String hora;

    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;

    @Column(name = "OBSERVACION", length = 200)
    private String observacion;

    public CitaMedica() {
    }

    public CitaMedica(Long id, String nombrePaciente, String nombreMedico, String especialidad,
                      String fecha, String hora, String estado, String observacion) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.fecha = LocalDate.parse(fecha);
        this.hora = hora;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha != null ? fecha.toString() : null;
    }

    public void setFecha(String fecha) {
        this.fecha = (fecha != null && !fecha.isBlank()) ? LocalDate.parse(fecha) : null;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}