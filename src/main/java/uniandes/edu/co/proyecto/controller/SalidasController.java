package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Salida;
import uniandes.edu.co.proyecto.repositorio.SalidaRepository;

@Controller
public class SalidasController {
    @Autowired
    private SalidaRepository salidaRepository;

    @GetMapping("/salidas")
    public String salidas(Model model) {
        model.addAttribute("salidas", salidaRepository.darSalidas());
        return "salidas";
    }

    @GetMapping("/salidas/new")
    public String salidaForm(Model model) {
        model.addAttribute("salida", new Salida());
        return "salidaNuevo";
    }

    @PostMapping("/salidas/new/save")
    public String salidaGuardar(@ModelAttribute Salida salida) {
        salidaRepository.insertarSalida(salida.getPk().getNumreserva().getNumReserva(), salida.getCuentatotal());
        return "redirect:/salidas";
    }

    @GetMapping("/salidas/{numreserva}/edit")
    public String salidaEditarForm(@PathVariable("numreserva") Integer numreserva, Model model) {
        Salida salida = salidaRepository.darSalida(numreserva);
        if (salida != null) {
            model.addAttribute("salida", salida);
            return "salidaEditar";
        } else {
            return "redirect:/salidas";
        }
    }

    @PostMapping("/salidas/{numreserva}/edit/save")
    public String salidaEditarGuardar(@PathVariable("numreserva") Integer numreserva, @ModelAttribute Salida salida) {
        salidaRepository.actualizarSalida(numreserva, salida.getCuentatotal(), salida.getPk().getNumreserva().getNumReserva());
        return "redirect:/salidas";
    }

    @GetMapping("/salidas/{numreserva}/delete")
    public String salidaEliminar(@PathVariable("numreserva") Integer numreserva) {
        salidaRepository.eliminarSalida(numreserva);
        return "redirect:/salidas";
    }
}
