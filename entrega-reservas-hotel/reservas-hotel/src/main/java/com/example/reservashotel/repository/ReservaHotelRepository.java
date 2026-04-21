package com.example.reservashotel.repository;

import com.example.reservashotel.model.ReservaHotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaHotelRepository extends JpaRepository<ReservaHotel, Long> {
    List<ReservaHotel> findByEstadoReserva(String estadoReserva);
    List<ReservaHotel> findByCiudad(String ciudad);
    List<ReservaHotel> findByFechaEntrada(LocalDate fechaEntrada);
}
