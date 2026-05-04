package com.example.reservashotel;

import com.example.reservashotel.model.ReservaHotel;
import com.example.reservashotel.repository.ReservaHotelRepository;
import com.example.reservashotel.service.ReservaHotelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReservaHotelServiceTest {

    @Test
    void obtenerTodasDebeRetornarListaDeReservas() {
        ReservaHotelRepository repository = Mockito.mock(ReservaHotelRepository.class);
        ReservaHotelService service = new ReservaHotelService(repository);

        ReservaHotel reserva = crearReservaEjemplo();

        when(repository.findAll()).thenReturn(List.of(reserva));

        List<ReservaHotel> resultado = service.obtenerTodas();

        assertEquals(1, resultado.size());
        assertEquals("Carlos Soto", resultado.get(0).getNombreCliente());
        assertEquals("Hotel Central", resultado.get(0).getHotel());
        assertEquals("CONFIRMADA", resultado.get(0).getEstadoReserva());
    }

    @Test
    void obtenerPorIdDebeRetornarReservaCuandoExiste() {
        ReservaHotelRepository repository = Mockito.mock(ReservaHotelRepository.class);
        ReservaHotelService service = new ReservaHotelService(repository);

        ReservaHotel reserva = crearReservaEjemplo();

        when(repository.findById(1L)).thenReturn(Optional.of(reserva));

        ReservaHotel resultado = service.obtenerPorId(1L);

        assertEquals(1L, resultado.getId());
        assertEquals("Carlos Soto", resultado.getNombreCliente());
    }

    @Test
    void crearDebeGuardarReserva() {
        ReservaHotelRepository repository = Mockito.mock(ReservaHotelRepository.class);
        ReservaHotelService service = new ReservaHotelService(repository);

        ReservaHotel reserva = crearReservaEjemplo();

        when(repository.save(reserva)).thenReturn(reserva);

        ReservaHotel resultado = service.crear(reserva);

        assertEquals("Carlos Soto", resultado.getNombreCliente());
        verify(repository, times(1)).save(reserva);
    }

    @Test
    void eliminarDebeLanzarErrorSiNoExiste() {
        ReservaHotelRepository repository = Mockito.mock(ReservaHotelRepository.class);
        ReservaHotelService service = new ReservaHotelService(repository);

        when(repository.existsById(99L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> service.eliminar(99L));
    }

    private ReservaHotel crearReservaEjemplo() {
        ReservaHotel reserva = new ReservaHotel();
        reserva.setId(1L);
        reserva.setNombreCliente("Carlos Soto");
        reserva.setHotel("Hotel Central");
        reserva.setCiudad("Santiago");
        reserva.setFechaEntrada("2026-05-10");
        reserva.setFechaSalida("2026-05-15");
        reserva.setTipoHabitacion("Doble");
        reserva.setCantidadHuespedes(2);
        reserva.setEstadoReserva("CONFIRMADA");
        reserva.setObservacion("Reserva de prueba");
        return reserva;
    }
}