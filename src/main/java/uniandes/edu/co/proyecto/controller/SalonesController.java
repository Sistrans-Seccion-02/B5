package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.repositorio.SalonRepository;

@Controller
public class SalonesController {
    
    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salones(Model model){
        model.addAttribute("salones",salonRepository.darSalones());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String salonForm(Model model){
        model.addAttribute("salones",new Salon());
        return "salonNuevo";
    }

    @PostMapping("/salones/new/save")
    public String salonGuardar(@ModelAttribute Salon salon){
        salonRepository.insertarSalon(salon.getAforo(), salon.getEquipo(), salon.getAplicaCompartido(), salon.getNombreHotel());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/edit")
    public String salonEditarForm(@PathVariable("id") int id, Model model){
        Salon salon = salonRepository.darSalon(id);
        if (salon != null){
            model.addAttribute("salon", salon);
            return "salonEditar";
        } else{
            return "redirect:/salones";
        }
    }

    @PostMapping("/salones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, @ModelAttribute Salon salon){
        salonRepository.actualizarSalon(id, salon.getAforo(), salon.getEquipo(), salon.getAplicaCompartido(), salon.getNombreHotel());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id){
        salonRepository.eliminarSalon(id);
        return "redirect:/salones";
    }
}
