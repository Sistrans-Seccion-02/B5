package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaHoteles;
import uniandes.edu.co.proyecto.repositorio.ReservaHotelesRepository;

@Controller
public class ReservasController {
    @Autowired
    private ReservaHotelesRepository reservaHotelesRepository;

    @GetMapping("/reservasHotel")
    public String reservasHotel(Model model) {
        model.addAttribute("reservasHotel", reservaHotelesRepository.darReservasHotel());
        return "reservasHotel";
    }

    @GetMapping("/reservasHotel/new")
    public String reservaForm(Model model) {
        model.addAttribute("reservaHotel", new ReservaHoteles());
        return "reservaHotelNuevo";
    }

    @PostMapping("/reservasHotel/new/save")
    public String reservaGuardar(@ModelAttribute ReservaHoteles reserva) {
        reservaHotelesRepository.insertarReservaHotel(reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getPago(), reserva.getReservaTomada(), reserva.getHoteles_nombre().getNombre(), reserva.getHabitaciones_numeroHabitacion().getNumeroHabitacion(), reserva.getPromociones_nombrePlan().getNombrePlan());
        return "redirect:/reservasHotel";
    }

    @GetMapping("/reservasHotel/{numreserva}/edit")
    public String reservaEditarForm(@PathVariable("numreserva") Integer numreserva, Model model) {
        ReservaHoteles reserva = reservaHotelesRepository.darReservaHotel(numreserva);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservasHotel";
        }
    }

    @PostMapping("/reservasHotel/{numreserva}/edit/save")
    public String reservaEditarGuardar(@PathVariable("numreserva") Integer numreserva, @ModelAttribute ReservaHoteles reserva) {
        reservaHotelesRepository.actualizarReservaHotel(numreserva, reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getPago(), reserva.getReservaTomada(), reserva.getHoteles_nombre().getNombre(), reserva.getHabitaciones_numeroHabitacion().getNumeroHabitacion(), reserva.getPromociones_nombrePlan().getNombrePlan());
        return "redirect:/reservasHotel";
    }

    @GetMapping("/reservasHotel/{numreserva}/delete")
    public String reservaEliminar(@PathVariable("numreserva") Integer numreserva) {
        reservaHotelesRepository.eliminarReservaHotel(numreserva);
        return "redirect:/reservasHotel";
    }
}
