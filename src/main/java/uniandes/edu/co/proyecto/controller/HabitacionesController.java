package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

@Controller
public class HabitacionesController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getTipoHabitacion().getTipoHabitacion());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{numerohabitacion}/edit")
    public String habitacionEditarForm(@PathVariable("numerohabitacion") Integer numerohabitacion, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(numerohabitacion);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{numerohabitacion}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("numerohabitacion") Integer numerohabitacion, @ModelAttribute TipoHabitacion tipoHabitacion) {
        habitacionRepository.actualizarHabitacion(numerohabitacion, tipoHabitacion.getTipoHabitacion());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{numerohabitacion}/delete")
    public String habitacionEliminar(@PathVariable("numerohabitacion") Integer numerohabitacion) {
        habitacionRepository.eliminarHabitacion(numerohabitacion);
        return "redirect:/habitaciones";
    }
}
