package com.example.reservashotel.service;

import com.example.reservashotel.model.ReservaHotel;
import com.example.reservashotel.repository.ReservaHotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaHotelService {

    private final ReservaHotelRepository repository;

    public ReservaHotelService(ReservaHotelRepository repository) {
        this.repository = repository;
    }

    public List<ReservaHotel> obtenerTodas() {
        return repository.findAll();
    }

    public ReservaHotel obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id: " + id));
    }

    public List<ReservaHotel> obtenerPorEstado(String estado) {
        return repository.findByEstadoReserva(estado);
    }

    public List<ReservaHotel> obtenerPorCiudad(String ciudad) {
        return repository.findByCiudad(ciudad);
    }

    public List<ReservaHotel> obtenerPorFechaEntrada(String fechaEntrada) {
        return repository.findByFechaEntrada(LocalDate.parse(fechaEntrada));
    }

    public ReservaHotel crear(ReservaHotel reserva) {
        return repository.save(reserva);
    }

    public ReservaHotel actualizar(Long id, ReservaHotel reservaActualizada) {
        ReservaHotel reservaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id: " + id));

        reservaExistente.setNombreCliente(reservaActualizada.getNombreCliente());
        reservaExistente.setHotel(reservaActualizada.getHotel());
        reservaExistente.setCiudad(reservaActualizada.getCiudad());
        reservaExistente.setFechaEntrada(reservaActualizada.getFechaEntrada());
        reservaExistente.setFechaSalida(reservaActualizada.getFechaSalida());
        reservaExistente.setTipoHabitacion(reservaActualizada.getTipoHabitacion());
        reservaExistente.setCantidadHuespedes(reservaActualizada.getCantidadHuespedes());
        reservaExistente.setEstadoReserva(reservaActualizada.getEstadoReserva());
        reservaExistente.setObservacion(reservaActualizada.getObservacion());

        return repository.save(reservaExistente);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }
}
