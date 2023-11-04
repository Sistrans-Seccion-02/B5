package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Tienda;
import uniandes.edu.co.proyecto.repositorio.TiendaRepository;

@Controller
public class TiendasController {
    
    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tiendas(Model model){
        model.addAttribute("tiendas", tiendaRepository.darTiendas());
        return "tiendas";
    }

    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model){
        model.addAttribute("tiendas", new Tienda());
        return "tiendaNuevo";
    }

    @GetMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda){
        tiendaRepository.insertarTienda(tienda.getNombre(), tienda.getAplicaCompartido(), tienda.getNombreHotel());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String tiendaEditarForm(@PathVariable("id") int id, Model model){
        Tienda tienda = tiendaRepository.darTienda(id);

        if (tienda != null){
            model.addAttribute("tienda", tienda);
            return "tiendaEditar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @GetMapping("/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Tienda tienda){
        tiendaRepository.actualizarTienda(id, tienda.getNombre(), tienda.getAplicaCompartido(), tienda.getNombreHotel());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String tiendaEliminar(@PathVariable("id") int id){
        tiendaRepository.eliminarTienda(id);
        return "redirect:/tiendas";
    }
}
