package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class TiposHabitacionesController {
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tiposHabitacionForm(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getTipoHabitacion());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipoHabitacion}/edit")
    public String tipoHabitacionlEditarForm(@PathVariable("tipohabitacion") String pktipohabitacion, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(pktipohabitacion);
        if (tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/tiposHabitacion";
        }
    }

    @PostMapping("/tiposHabitacion/{tipoHabitacion}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("tipohabitacion") String pktipohabitacion, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(pktipohabitacion, tipoHabitacion.getTipoHabitacion());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipoHabitacion}/delete")
    public String tipoHabitacionEliminar(@PathVariable("tipohabitacion") String tipohabitacion) {
        tipoHabitacionRepository.eliminarTipoHabitacion(tipohabitacion);;
        return "redirect:/tiposHabitacion";
    }
}
