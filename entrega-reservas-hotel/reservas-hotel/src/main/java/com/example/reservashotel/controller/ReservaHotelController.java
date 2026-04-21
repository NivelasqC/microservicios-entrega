package com.example.reservashotel.controller;

import com.example.reservashotel.model.ReservaHotel;
import com.example.reservashotel.service.ReservaHotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaHotelController {

    private final ReservaHotelService service;

    public ReservaHotelController(ReservaHotelService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReservaHotel> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ReservaHotel obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/estado/{estado}")
    public List<ReservaHotel> obtenerPorEstado(@PathVariable String estado) {
        return service.obtenerPorEstado(estado);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<ReservaHotel> obtenerPorCiudad(@PathVariable String ciudad) {
        return service.obtenerPorCiudad(ciudad);
    }

    @GetMapping("/fecha-entrada")
    public List<ReservaHotel> obtenerPorFechaEntrada(@RequestParam String fecha) {
        return service.obtenerPorFechaEntrada(fecha);
    }

    @PostMapping
    public ReservaHotel crear(@RequestBody ReservaHotel reserva) {
        return service.crear(reserva);
    }

    @PutMapping("/{id}")
    public ReservaHotel actualizar(@PathVariable Long id, @RequestBody ReservaHotel reserva) {
        return service.actualizar(id, reserva);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Reserva eliminada correctamente";
    }
}
