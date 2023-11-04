package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Supermercado;
import uniandes.edu.co.proyecto.repositorio.SupermercadoRepository;

@Controller
public class SupermercadosController {
    
    @Autowired
    private SupermercadoRepository supermercadoRepository;

    @GetMapping("/supermercados")
    public String supermercados(Model model){
        return "supermercados";
    }

    @GetMapping("/supermercados/new")
    public String supermercadoForm(Model model){
        model.addAttribute("supermercados", new Supermercado());
        return "supermercadoNuevo";
    }

    @PostMapping("/supermercados/new/save")
    public String supermercadoGuardar(@ModelAttribute Supermercado supermercado){
        supermercadoRepository.insertarSupermercado(supermercado.getNombre(), supermercado.getAplicaCompartido(), supermercado.getNombreHotel());
        return "redirect:/supermercados";
    }

    @GetMapping("/supermercados/{id}/edit")
    public String supermercadoEditarForm(@PathVariable ("id") int id, Model model){
        Supermercado supermercado = supermercadoRepository.darSupermercado(id);

        if (supermercado != null){
            model.addAttribute("supermercado", supermercado);
            return "supermercadoEditar";
        } else {
            return "redirect:/supermercados";
        }
    }

    @PostMapping("/supermercados/{id}/edit/save")
    public String supermercadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Supermercado supermercado){
        supermercadoRepository.actualizarSupermercado(id, supermercado.getNombre(), supermercado.getAplicaCompartido(), supermercado.getNombreHotel());
        return "redirect:/supermercados";
    }

    @GetMapping("/supermercados/{id}/delete")
    public String supermercadoEliminar(@PathVariable("id") int id){
        supermercadoRepository.eliminarSupermercado(id);
        return "redirect:/supermercados";
    }
}
