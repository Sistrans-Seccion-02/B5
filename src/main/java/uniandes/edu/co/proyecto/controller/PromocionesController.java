package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Promocion;
import uniandes.edu.co.proyecto.repositorio.PromocionRepository;

@Controller
public class PromocionesController {
    @Autowired
    private PromocionRepository promocionRepository;

    @GetMapping("/promociones")
    public String promociones(Model model) {
        model.addAttribute("promociones", promocionRepository.darPromociones());
        return "promociones";
    }

    @GetMapping("/promociones/new")
    public String promocionForm(Model model) {
        model.addAttribute("promocion", new Promocion());
        return "promocionNuevo";
    }

    @PostMapping("/promociones/new/save")
    public String promocionGuardar(@ModelAttribute Promocion promocion) {
        promocionRepository.insertarPromocion(promocion.getNombrePlan(), promocion.getDescuentoAlojamiento(),
        promocion.getDescuentoComida(), promocion.getDescuentoServicios(), promocion.getCosto(), promocion.getDiasMinimaEstadia());
        return "redirect:/promociones";
    }

    @GetMapping("/promociones/{nombreplan}/edit")
    public String promocionEditarForm(@PathVariable("nombreplan") String nombreplan, Model model) {
        Promocion promocion = promocionRepository.darPromocion(nombreplan);
        if (promocion != null) {
            model.addAttribute("promocion", promocion);
            return "promocionEditar";
        } else {
            return "redirect:/promociones";
        }
    }

    @PostMapping("/promociones/{nombreplan}/edit/save")
    public String promocionEditarGuardar(@PathVariable("nombreplan") String nombreplan, @ModelAttribute Promocion promocion) {
        promocionRepository.actualizarPromocion(nombreplan, promocion.getNombrePlan(), promocion.getDescuentoAlojamiento(), promocion.getDescuentoComida(), promocion.getDescuentoServicios(), promocion.getCosto(), promocion.getDiasMinimaEstadia());;
        return "redirect:/promociones";
    }

    @GetMapping("/promociones/{nombreplan}/delete")
    public String promocionEliminar(@PathVariable("nombreplan") String nombreplan) {
        promocionRepository.eliminarPromocion(nombreplan);
        return "redirect:/promociones";
    }
}
