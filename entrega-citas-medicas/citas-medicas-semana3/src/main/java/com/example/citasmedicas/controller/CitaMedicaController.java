package com.example.citasmedicas.controller;

import com.example.citasmedicas.model.CitaMedica;
import com.example.citasmedicas.service.CitaMedicaService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<CitaMedica>> obtenerTodas() {
        List<EntityModel<CitaMedica>> citas = service.obtenerTodas().stream()
                .map(cita -> EntityModel.of(cita,
                        linkTo(methodOn(CitaMedicaController.class).obtenerPorId(cita.getId())).withSelfRel(),
                        linkTo(methodOn(CitaMedicaController.class).obtenerTodas()).withRel("todas")))
                .collect(Collectors.toList());

        return CollectionModel.of(citas,
                linkTo(methodOn(CitaMedicaController.class).obtenerTodas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<CitaMedica> obtenerPorId(@PathVariable Long id) {
        CitaMedica cita = service.obtenerPorId(id);

        return EntityModel.of(cita,
                linkTo(methodOn(CitaMedicaController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(CitaMedicaController.class).obtenerTodas()).withRel("todas"));
    }

    @GetMapping("/estado/{estado}")
    public List<CitaMedica> obtenerPorEstado(@PathVariable String estado) {
        return service.obtenerPorEstado(estado);
    }

    @GetMapping("/fecha")
    public List<CitaMedica> obtenerPorFecha(@RequestParam String fecha) {
        return service.obtenerPorFecha(fecha);
    }

    @GetMapping("/disponibles")
    public List<CitaMedica> obtenerDisponiblesPorFecha(@RequestParam String fecha) {
        return service.obtenerDisponiblesPorFecha(fecha);
    }

    @PostMapping
    public EntityModel<CitaMedica> crear(@RequestBody CitaMedica cita) {
        CitaMedica nuevaCita = service.crear(cita);

        return EntityModel.of(nuevaCita,
                linkTo(methodOn(CitaMedicaController.class).obtenerPorId(nuevaCita.getId())).withSelfRel(),
                linkTo(methodOn(CitaMedicaController.class).obtenerTodas()).withRel("todas"));
    }

    @PutMapping("/{id}")
    public EntityModel<CitaMedica> actualizar(@PathVariable Long id, @RequestBody CitaMedica cita) {
        CitaMedica citaActualizada = service.actualizar(id, cita);

        return EntityModel.of(citaActualizada,
                linkTo(methodOn(CitaMedicaController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(CitaMedicaController.class).obtenerTodas()).withRel("todas"));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Cita eliminada correctamente";
    }
}