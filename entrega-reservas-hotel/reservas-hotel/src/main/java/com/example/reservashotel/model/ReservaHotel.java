package com.example.reservashotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "RESERVAS_HOTEL")
public class ReservaHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE_CLIENTE", nullable = false, length = 100)
    private String nombreCliente;

    @Column(name = "HOTEL", nullable = false, length = 100)
    private String hotel;

    @Column(name = "CIUDAD", nullable = false, length = 80)
    private String ciudad;

    @Column(name = "FECHA_ENTRADA", nullable = false)
    private LocalDate fechaEntrada;

    @Column(name = "FECHA_SALIDA", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "TIPO_HABITACION", nullable = false, length = 50)
    private String tipoHabitacion;

    @Column(name = "CANTIDAD_HUESPEDES", nullable = false)
    private Integer cantidadHuespedes;

    @Column(name = "ESTADO_RESERVA", nullable = false, length = 20)
    private String estadoReserva;

    @Column(name = "OBSERVACION", length = 200)
    private String observacion;

    public ReservaHotel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaEntrada() {
        return fechaEntrada != null ? fechaEntrada.toString() : null;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = (fechaEntrada != null && !fechaEntrada.isBlank()) ? LocalDate.parse(fechaEntrada) : null;
    }

    public String getFechaSalida() {
        return fechaSalida != null ? fechaSalida.toString() : null;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = (fechaSalida != null && !fechaSalida.isBlank()) ? LocalDate.parse(fechaSalida) : null;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
