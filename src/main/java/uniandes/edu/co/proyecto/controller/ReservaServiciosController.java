package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ReservaServicios;
import uniandes.edu.co.proyecto.repositorio.ReservaServiciosRepository;

import java.util.Optional;

@RestController
public class ReservaServiciosController {

    @Autowired
    private ReservaServiciosRepository reservaRepository;

    @GetMapping("/reservasServicios")
    public String reservas(Model model){
        model.addAttribute("reservasServicios", reservaRepository.darReservaServicio());
        return "reservasServicios";
    }

    @GetMapping("/reservasServicios/new")
    public String createReservasForm(Model model){
        model.addAttribute("reservasServicios", new ReservaServicios());
        return "create_reservasServicios";
    }

    @PostMapping("/reservasServicios/new/save")
    public String reservaGuardar(@ModelAttribute ReservaServicios reserva){
        reservaRepository.crearReservaServicio(reserva.getFecha(), reserva.getAtendida(), reserva.getHabitaciones_numeroHabitacion(), reserva.getLavanderias_idTipoServicio(), reserva.getBares_idTipoServicio(), reserva.getSpas_idTipoServicio(), reserva.getGimnasios_idTipoServicio(), reserva.getSalones_idTipoServicio() ,reserva.getRestaurantes_idTipoServicio(), reserva.getPiscinas_idTipoServicio());
        return "redirect:/reservasServicios";
    }
    
    @GetMapping("/reservasServicios/{id}/edit/")
    public String reservaEditarForm(@PathVariable("id") int id, Model model){
        ReservaServicios reserva = reservaRepository.darReservaServicioPorNumReserva(id);
        if (reserva == null) {
            model.addAttribute("reservasServicios", reserva);
            return "reservasServiciosEditar";}
        else {
            return "redirect:/reservasServicios";
        }
        }

    

    @PostMapping("/reservasServicios/{id}/edit/save")
    public String reservaEditGuardar(@PathVariable("id") int id, @ModelAttribute ReservaServicios reserva){
        reservaRepository.actualizarReservaServicio(reserva.getFecha(), reserva.getAtendida(), reserva.getHabitaciones_numeroHabitacion(), reserva.getLavanderias_idTipoServicio(), reserva.getBares_idTipoServicio(), reserva.getSpas_idTipoServicio(), reserva.getGimnasios_idTipoServicio(), reserva.getSalones_idTipoServicio() ,reserva.getRestaurantes_idTipoServicio(), reserva.getPiscinas_idTipoServicio());
        return "redirect:/reservasServicios";
    }

     @PostMapping("/reservasServicios/{id}/atendida")
    public ResponseEntity<String> actualizarAtendida(@PathVariable("id") int id, @RequestParam("atendida") boolean atendida) {
        Optional<ReservaServicios> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            ReservaServicios reserva = optionalReserva.get();
            reserva.setAtendida(atendida);
            reservaRepository.save(reserva);
            return new ResponseEntity<>("Atendida actualizada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró la reserva con id " + id, HttpStatus.NOT_FOUND);}
    }

    @GetMapping("/reservasServicios/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservaRepository.deleteById(id);
        return "redirect:/reservasServicios";
    }
    
}

