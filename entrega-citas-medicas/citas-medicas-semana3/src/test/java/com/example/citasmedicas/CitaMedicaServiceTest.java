package com.example.citasmedicas;

import com.example.citasmedicas.model.CitaMedica;
import com.example.citasmedicas.repository.CitaMedicaRepository;
import com.example.citasmedicas.service.CitaMedicaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CitaMedicaServiceTest {

    @Test
    void obtenerTodasDebeRetornarListaDeCitas() {
        CitaMedicaRepository repository = Mockito.mock(CitaMedicaRepository.class);
        CitaMedicaService service = new CitaMedicaService(repository);

        CitaMedica cita = crearCitaEjemplo();

        when(repository.findAll()).thenReturn(List.of(cita));

        List<CitaMedica> resultado = service.obtenerTodas();

        assertEquals(1, resultado.size());
        assertEquals("Juan Perez", resultado.get(0).getNombrePaciente());
        assertEquals("Medicina General", resultado.get(0).getEspecialidad());
        assertEquals("Disponible", resultado.get(0).getEstado());
    }

    @Test
    void obtenerPorIdDebeRetornarCitaCuandoExiste() {
        CitaMedicaRepository repository = Mockito.mock(CitaMedicaRepository.class);
        CitaMedicaService service = new CitaMedicaService(repository);

        CitaMedica cita = crearCitaEjemplo();

        when(repository.findById(1L)).thenReturn(Optional.of(cita));

        CitaMedica resultado = service.obtenerPorId(1L);

        assertEquals(1L, resultado.getId());
        assertEquals("Juan Perez", resultado.getNombrePaciente());
    }

    @Test
    void crearDebeGuardarCita() {
        CitaMedicaRepository repository = Mockito.mock(CitaMedicaRepository.class);
        CitaMedicaService service = new CitaMedicaService(repository);

        CitaMedica cita = crearCitaEjemplo();

        when(repository.save(cita)).thenReturn(cita);

        CitaMedica resultado = service.crear(cita);

        assertEquals("Juan Perez", resultado.getNombrePaciente());
        verify(repository, times(1)).save(cita);
    }

    @Test
    void eliminarDebeLanzarErrorSiNoExiste() {
        CitaMedicaRepository repository = Mockito.mock(CitaMedicaRepository.class);
        CitaMedicaService service = new CitaMedicaService(repository);

        when(repository.existsById(99L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> service.eliminar(99L));
    }

    private CitaMedica crearCitaEjemplo() {
        CitaMedica cita = new CitaMedica();
        cita.setId(1L);
        cita.setNombrePaciente("Juan Perez");
        cita.setNombreMedico("Dra. Ana Lopez");
        cita.setEspecialidad("Medicina General");
        cita.setFecha("2026-05-10");
        cita.setHora("10:30");
        cita.setEstado("Disponible");
        cita.setObservacion("Control general");
        return cita;
    }
}