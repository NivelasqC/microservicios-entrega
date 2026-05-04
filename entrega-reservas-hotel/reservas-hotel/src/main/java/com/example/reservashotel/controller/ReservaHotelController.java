package com.example.reservashotel.controller;

import com.example.reservashotel.model.ReservaHotel;
import com.example.reservashotel.service.ReservaHotelService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaHotelController {

    private final ReservaHotelService service;

    public ReservaHotelController(ReservaHotelService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<ReservaHotel>> obtenerTodas() {
        List<EntityModel<ReservaHotel>> reservas = service.obtenerTodas().stream()
                .map(reserva -> EntityModel.of(reserva,
                        linkTo(methodOn(ReservaHotelController.class).obtenerPorId(reserva.getId())).withSelfRel(),
                        linkTo(methodOn(ReservaHotelController.class).obtenerTodas()).withRel("todas")))
                .collect(Collectors.toList());

        return CollectionModel.of(reservas,
                linkTo(methodOn(ReservaHotelController.class).obtenerTodas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<ReservaHotel> obtenerPorId(@PathVariable Long id) {
        ReservaHotel reserva = service.obtenerPorId(id);

        return EntityModel.of(reserva,
                linkTo(methodOn(ReservaHotelController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(ReservaHotelController.class).obtenerTodas()).withRel("todas"));
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
    public EntityModel<ReservaHotel> crear(@RequestBody ReservaHotel reserva) {
        ReservaHotel nuevaReserva = service.crear(reserva);

        return EntityModel.of(nuevaReserva,
                linkTo(methodOn(ReservaHotelController.class).obtenerPorId(nuevaReserva.getId())).withSelfRel(),
                linkTo(methodOn(ReservaHotelController.class).obtenerTodas()).withRel("todas"));
    }

    @PutMapping("/{id}")
    public EntityModel<ReservaHotel> actualizar(@PathVariable Long id, @RequestBody ReservaHotel reserva) {
        ReservaHotel reservaActualizada = service.actualizar(id, reserva);

        return EntityModel.of(reservaActualizada,
                linkTo(methodOn(ReservaHotelController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(ReservaHotelController.class).obtenerTodas()).withRel("todas"));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Reserva eliminada correctamente";
    }
}
