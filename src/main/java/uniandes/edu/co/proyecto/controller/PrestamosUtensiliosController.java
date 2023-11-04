package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PrestamoUtensilio;
import uniandes.edu.co.proyecto.repositorio.PrestamoUtensilioRepository;

@Controller
public class PrestamosUtensiliosController {
    
    @Autowired
    private PrestamoUtensilioRepository prestamoUtensilioRepository;

    @GetMapping("/prestamosutensilios")
    public String prestamoUtensilios (Model model){
        model.addAttribute("prestamosutensilios", prestamoUtensilioRepository.darPrestamoUtensilios());
        return "prestamosutensilios";
    }

    @GetMapping("/prestamosutensilios/new")
    public String prestamosUtensiliosForm(Model model){
        model.addAttribute("prestamoutensilio", new PrestamoUtensilio());
        return "prestamosutensilioNuevo";
    }

    @PostMapping("/prestamosutensilios/new/save")
    public String prestamosutensiliosGuardar(@ModelAttribute PrestamoUtensilio prestamoUtensilio){
        prestamoUtensilioRepository.insertarPrestamoUtensilio(prestamoUtensilio.getNombre(), prestamoUtensilio.getRetornado(), prestamoUtensilio.getNombreHotel());
        return "redirect:/prestamosutensilios";
    }

    @GetMapping("/prestamosutensilios/{id}/edit")
    public String prestamosutensiliosEditarForm(@PathVariable("id") int id,Model model){
        PrestamoUtensilio prestamoUtensilio = prestamoUtensilioRepository.darPrestamoUtensilio(id);

        if (prestamoUtensilio != null){
            model.addAttribute("prestamosutensilio", prestamoUtensilio);
            return "prestamountensilioEditar";
        } else {
            return "redirect:/prestamoutensilios";
        }
    }

    @PostMapping("/prestamoutensilios/{id}/edit/save")
    public String prestamoutensilioEditarGuardar(@PathVariable("id")int id,@ModelAttribute PrestamoUtensilio prestamoUtensilio){
        prestamoUtensilioRepository.actualizarPrestamoUtensilio(id, prestamoUtensilio.getNombre(), prestamoUtensilio.getRetornado(), prestamoUtensilio.getNombreHotel());
        return "redirect:/prestamoutensilios";
    }

    @GetMapping("/prestamoutensilios/{id}/delete")
    public String prestamoutensiliosEliminar(@PathVariable("id") int id){
        prestamoUtensilioRepository.eliminarPrestamoUtensilio(id);
        return "redirect:/prestamoutensilios";
    }
    
    
}
